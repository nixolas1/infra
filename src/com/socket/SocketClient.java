package com.socket;

import com.ui.ChatFrame;
import com.ui.pingTask;

import java.io.*;
import java.net.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;

import com.apple.eawt.Application;

public class SocketClient implements Runnable {

	public int port;
	public String serverAddr;
	public Socket socket;
	// private String password = "";
	public ChatFrame ui;
	public BufferedReader In;
	public BufferedWriter Out;
	public StringBuffer txtEnc = new StringBuffer();
	public StringBuffer txtDec = new StringBuffer();
	public boolean verbose = true;
	public pingTask Ping;
	public boolean keepRunning = true;

	public SocketClient(ChatFrame frame) throws IOException {
		ui = frame;
		this.serverAddr = ui.serverAddr;
		this.port = ui.port;
		socket = new Socket(InetAddress.getByName(serverAddr), port); // initsialize socket & buffers

		Out = new BufferedWriter(new OutputStreamWriter(
				socket.getOutputStream()));
		In = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    
		Out.flush();
	}

	@Override
	public void run() { // thread input
		while (keepRunning) {
			try {

				String raw = In.readLine();
				readMessage(raw);
			} catch (IOException | GeneralSecurityException e) {
				keepRunning = false;
				System.out.println(e);

				ui.enableLogin();
				for (int i = 1; i < ui.model.size(); i++) {
					ui.model.removeElementAt(i);
				}

				ui.clientThread.stop();

				System.out.println("Exception SocketClient run()");
				e.printStackTrace();
				if(ui.joined){
					ui.print("~", "Connection Failure, reconnecting");
					ui.connect(); // try to reconnect on disconnect error
				}
			}
		}
	}
	
	public void readMessage(String raw) throws GeneralSecurityException, UnsupportedEncodingException{
		String msg[] = raw.split(":");
		String type = msg[0];
		String middle[] = msg[1].split(" ");
		System.out.println("Incoming : "+ raw);

		switch (type) {
		case "PING ":
			send("PONG", msg[1]); // reply to pings
			break;
		case "ERROR ":
			ui.print("***", "Trying to reconnect");
			ui.connect();
			ui.print("***", "Connecting...");
			break;
		}
		
		if(!ui.joined){
			ui.jPasswordField1.requestFocus();
			ui.join();
		}
		
		if(msg.length==2 && middle.length>=2){ //rewrite mode messages so it gets processed properly
			if(middle[1].equals("MODE")){
				String sendstring = ":"+middle[0]+" MODE :"+raw.substring(middle[0].length()+7);
				readMessage(sendstring);
				return;
			}
			
		}

		//if (msg.length >= 3) { }// message is a type we want to process
			
			String content;
			if(msg.length>=3)content = raw.substring(raw.indexOf(" :"+msg[2])+2);
			else content="*";
			type = middle[1];
			//if(msg.length<3)
			String sender = msg[1].split("!")[0];
			System.out.println(type + ":" + sender +":"+ content);

			switch(type){
			
			case "PRIVMSG": 								//process normal message
				String from = middle[2];
				String begin = "["+from+"]"+" "+sender+":";
				String out = content;

				ui.toFront(); // flash icon in windows

				if (ui.isMac()) { // bounce icon on mac
					Application application = Application.getApplication();
					application.requestUserAttention(false);
				}
				
				if (ui.secure){
					out = ui.crypt.decrypt(ui.crypt.unKek(content)); // try to decrypt message
					
					if (out.equals("000")) { // message is not ecrypted with kek
						out = ui.crypt.decrypt(content);
						if (out.equals("000")) { //not encrypted at all
							out = content;
							begin = "!"+ begin;
						}
					}
				}else{
					begin = "!" + begin;
				}
				
				if(ui.doBot && !sender.equals(ui.username))ui.badBot.botCheck(sender, from, out);

				if (out.startsWith("/")) { // recieved a command
					String[] args = out.split(" ");
					String cmd = args[0].substring(1).toLowerCase();

					switch (cmd) {
					case "me":
						out = sender + " "+out.substring(4); begin="["+from+"] *";
						break;

					case "quote":
						out = "'"+ out.substring(8 + args[1].length()) + "' ~" + args[1]; begin="["+from+"] *";
						break;
						
					}
					if(!ui.secure)begin = "!" + begin;
				}

				if (ui.hidden) { // client is in hidden mode, store messages for later
					txtDec.append(begin + out + "\n");
					out = content;
				}
				txtEnc.append(begin + content + "\n"); // store encrypted content for later
				
				ui.print(begin, out); //print recieved message
				
				break;
					
			case "001": // login successful
				ui.model.addElement(ui.username);
				startPing();
				ui.print("~", "Login Successful");
				break;
					
			case "433": // nick taken
				ui.print("~", "Could not log in: nick '" + ui.username + "' already in use");
				ui.jTextField3.setText(System.getProperty("user.name"));
				ui.quit();
				break;
					
					
			case "353": // userlist  :Rass IRC 353 Nixo = #badnat :Nixo Fedorov FooteBot majahi
				String users[] = content.split(" ");
				for (int i = 1; i < users.length; i++) 
					if (!ui.model.contains(users[i])) 
						ui.model.addElement(users[i]);
				break;
			
			case "PONG":
				//ui.print("[PONG] ~", Ping.getPing()+" ms");
				//System.out.println("Ping: "+Ping.getPing()+" ms");
				break;
				
					
			case "NICK": // user has changed nick
				//sender=ui.strip(sender); nope. must stript the model entity!
				if (ui.model.contains(sender)) {
					ui.print("~", sender+" has changed nick to "+content);
					int i = ui.model.indexOf(sender);
					ui.model.set(i, content);
					
					if(sender.equals(ui.username)){
						ui.username=content;
						ui.jTextField3.setText(content);
						ui.pre=" "+content+" > ";
						ui.jTextField4.setText(ui.pre);
					}
					// maxName
				}
				break;
					
			case "JOIN": // someone joined
				ui.print("["+content+"] ~", sender + " has joined");

				ArrayList<String> tList = new ArrayList<String>();
				if (!ui.model.contains(content)) {
					ui.model.addElement(content);
				} // add name/chan if not already in list

				for (int i = 0; i < ui.model.getSize(); i++)
					tList.add(ui.model.get(i));

				Collections.sort(tList);
				for (int i = 0; i < ui.model.getSize(); i++)
					ui.model.set(i, tList.get(i)); // sort and insert sorted list
				break;
					
			case "QUIT":
				for (int i = 0; i < ui.model.getSize(); i++){
					if(ui.strip(ui.model.get(i).toString()).equals(sender))ui.model.removeElementAt(i);
				}			
				ui.print("[QUIT] ~",sender + " has signed out - "+content);
				break;
			
			case "MODE":
				ui.print("[MODE] ~", sender + " sets mode "+content);
				break;
			
			case "KICK":
				ui.print("[KICK] ~", sender + " has kicked "+ middle[3]+" ("+content+")");
				break;
				
			default:
				if (verbose && !type.equals("366")) {
					if(middle.length<=3)
						ui.print("[" + type + "] ~", content);  //:Nixolas1!~Nixo@s180c.studby.ntnu.no KICK #badnat Nixolas2 :no reason
					else										
						ui.print("["+type+"] ~",msg[1].substring(middle[0].length()+middle[1].length()+middle[2].length()+3)+": "+content);
				}
				break;
				
			} //switch

	//	} // msg >2
	}

	public void send(String cmd, String msg) {
		send(cmd, "", msg);
	}

	public void send(String cmd, String target, String msg) {
		
		String out = cmd.toUpperCase(), end = "\r\n";
		// NICK USER JOIN PING PRIVMSG QUIT
		switch (cmd) {
		case "NICK": case "JOIN": case "QUIT": case "PONG":
			out += " :" + msg + end;
			break;
		}
		if(target.equals(""))out += " :" + msg + end;
		else{     
			out += " " + target + " :" + msg + end;// "PRIVMSG": case "USER":
		}
		
		sendRaw(out);
	}
	
	public void sendRaw(String out){

			try {
				Out.write(out);// write & flush message to server
				Out.flush();
				System.out.println("Outgoing : " + out);
			} catch (IOException e ) {
				//e.printStackTrace();
				ui.print("***","Tried sending to dead socket");
				 try{Ping.cancel();}catch(NullPointerException ez){System.out.println("Tried to ping dead thread. Suicide.");}
				//keepRunning=false;
			}
	}

	public void closeThread(Thread t) {
		t = null;
	}
	
    public void startPing(){
    	Timer timer = new Timer();
    	Ping = new pingTask(this);
        timer.schedule(Ping, 0, 15000); 
    }
    

}
