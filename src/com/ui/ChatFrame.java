package com.ui;

import TopKek.Crypto;

import com.socket.BadBot;
import com.socket.SocketClient;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class ChatFrame extends javax.swing.JFrame implements AWTEventListener  {


	private static final long serialVersionUID = 1L;
	public SocketClient client;
    public int port;
    public String serverAddr, username=InetAddress.getLocalHost().getHostName();
    private String salt = "Shhhh!! MuCH NSA must BE SECTRETORNMONOERN KLASUI GDas7das7kt6RDas57rjD iuYTSYU&ARDU(AS% (IASG KslSHf dkya g,UGSdo6asfio76GIOsdt7 ASFkd";
    public Thread clientThread;
    public DefaultListModel<String> model;
    public static int wbg=0x7A7A6C; //color(0x7A7A6C, 0x272822, 0x8ACB07);
	public static int bg=0x272822;
	public static int txtCol=0x8ACB07;
    public Crypto crypt;
    public String passid = InetAddress.getLocalHost().getHostName();
    public boolean hidden = false;
    private int lword = 1;
    private String tabword = "", tabtxt="";
    public String pre = " INSECURE > ";
    private JPanel top = new JPanel(), left = new JPanel();
    public String title = "Infra 777nm - Hack Hunter"; //97 128 256 512 601 666 720 777 808 812 840 888 911 991 999nm, 1�m
    public boolean secure = false;
    public final static int MAX_MESSAGE_LENGTH = 456;
    public int maxBegin = 22;
    public boolean joined = false, doBot=false;
    public String subTitle = "";//" - Hello Privacy";
    public BadBot badBot;
    
    
    public ChatFrame() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, FileNotFoundException, FontFormatException, IOException {
    	System.setProperty("file.encoding","UTF-8");
    	Field charset = Charset.class.getDeclaredField("defaultCharset");
    	charset.setAccessible(true);
    	charset.set(null,null);
        initComponents();
        this.setTitle(title);
        
        model.addElement("#badnat");
        jList1.setSelectedIndex(0);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ChatFrame.class.getResource("infra_icon.png")));
        
        jTextField6.setEditable(false);
        jTextField6.setVisible(false);
        jTextField4.setText(pre);
        
        this.getToolkit().addAWTEventListener(this, AWTEvent.KEY_EVENT_MASK);
        
        
        this.addWindowListener(new WindowListener() {

            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) { 
            	try{ 
            		client.send("QUIT", title+subTitle);
            		clientThread.stop();  }catch(Exception ex){ex.printStackTrace();} }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
        
    }
    
    public boolean isWin32(){
        return System.getProperty("os.name").startsWith("Windows");
    }

    public boolean isMac(){
        return System.getProperty("os.name").startsWith("Mac");
    }

    public boolean isLinux(){
        return System.getProperty("os.name").startsWith("Linus");
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("serial")
	private void initComponents() throws FileNotFoundException, FontFormatException, IOException {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();//{@Override public void setBorder(Border border) {}};
        msgArea = new javax.swing.JTextArea(){@Override public void setBorder(Border border) {}};
        jScrollPane2 = new javax.swing.JScrollPane(){@Override public void setBorder(Border border) {}};
        jList1 = new javax.swing.JList<String>();
        jTextField4 = new javax.swing.JTextField(){@Override public void setBorder(Border border) {}};
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Host Address : ");

        jTextField1.setText("rass.nixo.no");

        jLabel2.setText("Host Port : ");

        jTextField2.setText("6667");

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.setText(System.getProperty("user.name"));

        jPasswordField1.setText("");
        
        msgArea.setColumns(40);
        msgArea.setFont(new java.awt.Font("Consolas", 0, 13));
        msgArea.setRows(5);
        jScrollPane1.setViewportView(msgArea);
        msgArea.setLineWrap(true);
        msgArea.setWrapStyleWord(true);
        msgArea.setEditable(false);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        jTextField1.setFont(new java.awt.Font("Consolas", 0, 12));
        jTextField2.setFont(new java.awt.Font("Consolas", 0, 12));
        jTextField3.setFont(new java.awt.Font("Consolas", 0, 12));
        jTextField4.setFont(new java.awt.Font("Consolas", 0, 12));
        jTextField5.setFont(new java.awt.Font("Consolas", 0, 12));
        jTextField6.setFont(new java.awt.Font("Consolas", 0, 12));
        
        //UIManager.put(jScrollPane1, ScrollBar.background());

        jList1.setModel((model = new DefaultListModel<String>()));
        jScrollPane2.setViewportView(jList1);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
           	 try {
					jButton2ActionPerformed(evt);
				} catch ( UnsupportedEncodingException | UnknownHostException | GeneralSecurityException e) {
					e.printStackTrace();
				}
           }
       });
        

     
        jButton2.setText("Encrypt");

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton2ActionPerformed(evt);
				} catch (UnknownHostException | UnsupportedEncodingException | GeneralSecurityException e) {
					e.printStackTrace();
				}
            }
        });

        jTextField5.setVisible(false);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 try {
 					jButton4ActionPerformed(evt);
 				} catch (UnsupportedEncodingException | GeneralSecurityException e) {
 					e.printStackTrace();
 				}
            }
        });        

        
        BorderLayout layout = new BorderLayout(0,0);
        Container panel = getContentPane();
        
        ((JComponent) panel).setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.setLayout(layout);
        panel.setBackground(Color.getColor("",wbg));
        
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));
        jScrollPane2.setPreferredSize(new Dimension(100, 0));

        jTextField1.setPreferredSize(new Dimension(90, 20));
        jTextField2.setPreferredSize(new Dimension(35, 20));
        jTextField3.setPreferredSize(new Dimension(90, 20));
        jPasswordField1.setPreferredSize(new Dimension(90, 20));
        
        top.add(jTextField1);
        top.add(jTextField2);
        top.add(jTextField3);
        top.add(jPasswordField1);
        top.add(jButton2);top.add(jButton1);
        
        panel.add(top, BorderLayout.NORTH);
        
        panel.add(jScrollPane1, BorderLayout.CENTER);
        panel.add(jScrollPane2, BorderLayout.EAST );
        panel.add(jTextField4, BorderLayout.SOUTH);
        
        layout.removeLayoutComponent(jPasswordField1);
        this.setSize(new Dimension(1000,600));
        color(wbg, bg, txtCol);
        
        connect();
        
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	if(jButton1.getText().equals("Connect")){
        	connect();
    	}
    	else
    		quit();
    		
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws UnknownHostException, UnsupportedEncodingException, GeneralSecurityException {//GEN-FIRST:event_jButton2ActionPerformed
       if(jButton2.getText().equals("Encrypt")){
	    	String password = new String(jPasswordField1.getPassword());
	        initCrypto(password);
       }else{
    	  disableEncryption();
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) throws UnsupportedEncodingException, GeneralSecurityException {//GEN-FIRST:event_jButton4ActionPerformed
        String msg = jTextField4.getText().substring(pre.length());
        String target = "";
        try{ target = jList1.getSelectedValue().toString();} catch(NullPointerException e){System.out.println("ERROR: No value selected in list when getting target");}
        target=strip(target);
        if(!msg.isEmpty() && !msg.equals("") && !target.isEmpty()){
        	boolean doSend = true;
        	
        	 if(msg.startsWith("/")){
        		doSend=false;
         		String[] args = msg.split(" ");
         		String cmd = args[0].substring(1).toLowerCase();
         		
         		switch(cmd){
         			
	         		case "cmd":
	         			if(args.length==3)sendCMD(args[1].toUpperCase(),args[2]);
	         			else if(args.length>=4)sendCMD(args[1].toUpperCase(), args[2], msg.substring(args[1].length()+args[2].length()+7));
	         			else print("*","Illegal cmd format, supply 2 or more args, eg /cmd kick #beta Gamma because");
	         			break;
	         		
	         		case "raw":
	         			client.sendRaw(msg.substring(5)+"\r\n");
	         			break;
	         		
	         		case "dec":
	         			String dec = crypt.decrypt(crypt.unKek(msg.substring(5)));
	         			if(dec.equals("000"))dec=crypt.decrypt(msg.substring(5));
	         			print("Decrypted *", dec);
	         			break;
	         		
	         		case "join": case "nick":
	         			if(args.length==2)sendCMD(cmd.toUpperCase(), args[1]);
	         			else if(args.length==3)sendCMD(cmd.toUpperCase(), args[1], args[2]);
	         			else print("*","Illegal "+cmd+" format, supply 2 or 3 args.");
	         			break;
	         			
	         		case "i":
	         			disableEncryption();
	         			break;
	         		
	         		case "verbose":
	         			client.verbose= !client.verbose;
	         			print("*","Verbosity is now "+  (client.verbose ? "ON" : "OFF"));
	         			
	         		case "show":
	         			top.setVisible(true);
	         			break;
	         		
	         		case "e":
	         			initCrypto(msg.substring(3));
	         			break;
         			
         			case "logout": case "quit": case "exit": case "signout": case "q":
         				quit();
         				enableLogin();
         				break;
         				
         			case "white":color(0xAAAAAA, 0xFFFFFF, 0x444444);break;	
         			case "black":color(0x444444, 0x111111, 0xAAAAAA);break;
         			case "blue": color(0x3399FF, 0x111111, 0x3399FF);break;
         			case "lightblue": color(0xF5F1D8, 0x5B9CA2, 0xF5F1D8);break;
         			case "cold": color(0x8A949B,0x243743,0x28B78D);break;
         			
         			case "darkred":  color(0xFF3B00, 0x111111, 0xFF3B00);break;
         			case "red":  color(0x4E4E56, 0xDA635D,0x3E3E46);break;
         			case "dark": color(0x8EFF00, 0x1D2C2E, 0x8EFF00);break;
         			case "green":color(0x8EFF00, 0x1D2C2E, 0x8EFF00);break;
         			case "normal":color(0x7A7A6C, 0x272822, 0x8ACB07);break;
         			case "brown":color(0x7A7A6C, 0x42382F, 0x9A9A8C);break;
         			case "gray": color(0x7A7A6C, 0x272822, 0x7F7F6F);break;
         			case "b�sj": color(0xFFFFFF, 0x473107, 0xFFFFFF);break;
         			
         			case "color":
         				color(Integer.parseInt(args[1], 16), Integer.parseInt(args[2], 16), Integer.parseInt(args[3], 16));
         				break;
         			
         			case "help":
         				//String[] commands = "";
         				print("***","List of commands: /CommandName [arg] (optionalArg) - Explanation");
         				print("***","/i - Go insecure /e [pass] - start encrypting");
         				print("***","/show - Shows top bar /cmd [command] [arg1] (arg2) - Sends an IRC command (eg. /cmd KICK #beta Gamma)");
         				print("***","/verbose - print all server messages (default) /join [#chan] - Joins Channel /quit - Disconnects from server");
         				print("***","/slap [SOMEONE] - Slaps someone /me [DOES THIS] - Do an action in chat");
         				print("***","/white, /black, /green /blue /brown, /bæsj, /dark, /gray, /cold, /lightblue, /darkred, /normal - sets chat style");
         				print("***","/color [window hex] [textfield hex] [text hex] - sets custom color (eg. /color FFFFFF 000000 FF0000)");
         				print("***","/quote [NAME] [QUOTE] - quotes someone, /uuddlrlrab, /nick [nick] - set nick, /dec [encrypted] - decrypts text");
         				print("***","/raw [message] - sends a raw IRC message (eg. :Nick!~User@host PRIVMSG #beta Gamma :Hello NSA )");
         				break;
         				
         			case "uuddlrlrba":
         				String t = "\n\t\t\t\t";
         				msg=t+"       /\\"+t+"      /  \\"+t+"     /,--.\\"+t+"    /< () >\\"+t+"   /  `--'  \\"+t+"  /          \\"+t+" /   CICADA   \\"+t+"/______________\\\n";
         				doSend=true;
         				break;
         				
         			case "slap":
         				msg="/me slaps "+args[1]+" with a "+crypt.topKek(username, args[1]);
         				doSend=true;
         				break;
         			
         			case "bot":
         				doBot=!doBot;
         				if(doBot){
         					badBot = new BadBot(client, this);
         					sendCMD("NICK", "BadBot"); //System.getProperty("user.name").substring(0, 1)+
         					}
         				print("*","The bot is now "+  (client.verbose ? "ON" : "OFF"));
         				break;
         				
         			default:
         				doSend=true;
         				break;
         				
         		}
         	 }
        	
        	if(doSend){
        		prepareSend(msg, target);
        	}
        	jTextField4.setText(pre);
        }
    }
    
    public void prepareSend(String msg, String target) throws UnsupportedEncodingException, GeneralSecurityException{
    	
    	String temp=msg;
    	if(secure){
    		try{ temp =crypt.kek(crypt.encrypt(msg)); }
	        catch( NullPointerException e){print("***","Error encrypting message!"); }
    		if(temp.length()>MAX_MESSAGE_LENGTH){
    			temp=crypt.encrypt(msg);
    		}
		}
    	
    	if(temp.length()>MAX_MESSAGE_LENGTH){
    		prepareSend(msg.substring(0, msg.length()/2), target);
    		prepareSend(msg.substring(msg.length()/2), target);
    		return;
    	}
    	
    	msg=temp;
    	
        System.out.println(msg + "---" + target);
        client.send("PRIVMSG", target, msg);
        client.readMessage(":"+username+"!~local@local PRIVMSG "+target+" :"+msg);
        jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getMaximum());
    }
    
    private void disableEncryption(){
    	   secure=false;
	  	   pre="INSECURE > ";
	  	   jTextField4.setText(pre);
	  	   jButton2.setText("Encrypt");
	  	   print("***","ENCRYPTION HAS BEEN DISABLED!");
    }
    
    public String strip(String txt) {
    	if(txt.length()>0 && !txt.startsWith("#")){
	    	String first=txt.substring(0, 1).replaceAll("[^a-zA-Z0-9]", "");
	    	return first+txt.substring(1);
    	}
    	return txt;
	}
    
    public void sendCMD(String arg1, String arg2){
 			client.send(arg1, arg2);
 			print("*","Sent command ["+arg1+", "+arg2+"]");
    }
    public void sendCMD(String arg1, String arg2, String arg3){
			client.send(arg1, arg2, arg3);
			print("*","Sent command ["+arg1+", "+arg2+", "+arg3+"]");
    }

	public void color(int bgi, int txtbgi, int txti){
    	Color bg = Color.getColor("", bgi);
    	Color txtbg = Color.getColor("", txtbgi);
    	Color txt = Color.getColor("", txti);	
    	
         getContentPane().setBackground(txtbg);
         top.setBackground(txt);
         left.setBackground(txtbg);
         jLabel1.setForeground( txt);
         jLabel2.setForeground( txt);
         jLabel3.setForeground( txt);
         jLabel4.setForeground( txt);
         
         jTextField1.setCaretColor( txt);
         jTextField1.setForeground( txt);
         jTextField2.setForeground( txt);
         jTextField2.setCaretColor( txt);
         jTextField3.setForeground( txt);
         jTextField3.setCaretColor( txt);
         jTextField4.setCaretColor( txt);
         jTextField5.setForeground( txt);
         jTextField5.setCaretColor( txt);
         jTextField6.setForeground( txt);
         jTextField6.setCaretColor( txt);
          msgArea.setForeground( txt);
          jPasswordField1.setBackground(txtbg);
         jPasswordField1.setForeground( txt);
         jPasswordField1.setCaretColor( txt);
         
         jTextField1.setBackground(txtbg);
         jTextField2.setBackground(txtbg);
         jTextField3.setBackground(txtbg);
         
         jTextField4.setBackground(bg); //chat input box
         jTextField4.setForeground(txtbg);
         
         msgArea.setBackground(txtbg);
         jScrollPane1.setBackground(txtbg);
         jList1.setBackground( txtbg);
         jList1.setForeground( txt);
         
         jButton1.setBackground(null);
         jButton2.setBackground(null);
         jButton3.setBackground(null);
         jButton4.setBackground(null);
         jButton5.setBackground(null);
         
    }
    
    public void print(String begin, String out){
    	String chans[] = begin.split(" ");
    	String chan = " ", separator = " ", spacing = " ", msgTime = (new Date()).toString().split(" ")[3].substring(0,5);
    	if(begin.length()>=maxBegin){ maxBegin=begin.length();}
    	if(begin.contains(" ") && chans[0].length()>0){
    		chan=chan+chans[0];
    		begin=begin.substring(chans[0].length()+1);
    	}
    	
    	
    	spacing = new String(new char[maxBegin-begin.length()-chan.length()+1]).replace('\0', ' ');
    	
    	msgArea.append(msgTime+chan+spacing+begin+separator+out+"\n");
    	int msglen = msgArea.getText().length();
    	msgArea.select(msglen, msglen);

    }
    
    public void append(JEditorPane pane, String s) {
    	   try {
    	      Document doc = pane.getDocument();
    	      doc.insertString(doc.getLength(), s, null);
    	   } catch(BadLocationException exc) {
    	      exc.printStackTrace();
    	   }
    	}
    
    public void quit(){
    	 joined=false;
    	 jButton1.setEnabled(true); 
    	 jButton1.setText("Connect");
         jTextField1.setEditable(true); jTextField2.setEditable(true);
         client.send("QUIT", title+subTitle);
         print("~","Disconnected from server");
         for(int i = 1; i < model.size(); i++){
             model.removeElementAt(i);
         }
         clientThread.stop();
         top.setVisible(true);
         try{client.Ping.cancel();}catch(NullPointerException e){System.out.println("Tried to ping dead thread. Suicide.");}
    }
    
    private void initCrypto(String password) throws UnsupportedEncodingException, GeneralSecurityException{
    	if(!password.isEmpty()){
        	crypt = new Crypto(password, salt);
            jPasswordField1.setText("");
            hideConnect();
           
            password=null;
            secure=true;
            pre=" "+username+" > ";
            jTextField4.setText(pre);
            jTextField4.requestFocus();
            jButton2.setText("Go insecure");
            print("[CRYPTO] ~", "Encryption has been enabled!");
        }
        else{
        	print("~","Malformed encryption password");
        }
    }
    
    public void hideConnect(){
    	top.setVisible(false);
    }
    
    public void join(){
    	joined=true;
    	username = jTextField3.getText();
    	client.send("USER", passid+" 8 *", username);
    	client.send("NICK", username);
        client.send("JOIN", jList1.getSelectedValue().toString());
        print("~", "Connected to " + jTextField1.getText());
    }
    
    public void check() {
  	  String txt = jTextField4.getText();
  	     if (txt.length()<pre.length()){
  	    	 jTextField4.setText(pre);
  	     }else if (!txt.substring(0, pre.length()).equals(pre)){
  	    	 jTextField4.setText(pre+txt.substring(pre.length()));
  	     }
  	}

    
    public void enableLogin(){
    	top.setVisible(true);
    	jPasswordField1.requestFocus();
    }
    
    public void connect(){
    	jButton1.setText("Disconnect");
    	serverAddr = jTextField1.getText(); port = Integer.parseInt(jTextField2.getText());
        jPasswordField1.requestFocus();
        if(!serverAddr.isEmpty() && !jTextField2.getText().isEmpty()){
                try {
					client = new SocketClient(this);
					clientThread = new Thread(client);
	                clientThread.start();

				} catch (IOException e) {
					print("***","Error starting socket thread!");
					e.printStackTrace();
				}
                
           
        }
        }

    @Override
    public void eventDispatched(AWTEvent event) {
      if(event instanceof KeyEvent){
        KeyEvent key = (KeyEvent)event;
        if(key.getID()==KeyEvent.KEY_PRESSED){ //Handle key presses
        	int k = key.getKeyCode();
        	if(k == 123){ //f12 toggle encryption
        		if(!hidden){
	        		msgArea.setText(client.txtEnc.toString());
	        		hidden=true;
        		}else{
        			msgArea.setText(client.txtDec.toString());
        			client.txtDec = new StringBuffer();
	        		hidden=false;
        		}
        		//key.consume();
        	}else if(k>= 112 && k<=122){ //f1-f11 link opening 
        		ArrayList<String> li = extractUrls(msgArea.getText());
        		int pos = li.size()-k+111;
        		if(pos<0)pos=0;
        		if(pos<=li.size()-1)
        		openWebpage(URI.create(li.get(pos)));
        	}
        	
        	else if(k==9 && jTextField4.isFocusOwner()){ //TAB - Nick-COMPLETION
        		String last,txt;
        		
        		if(lword != 1){
        			txt=tabtxt;
        			last=tabword;
        			if(lword>=model.getSize())lword=1;
        		}else{
        			txt=jTextField4.getText();
        			last=txt.split(" ")[txt.split(" ").length-1];
        			tabword = last;
        			tabtxt=txt;
        		}
        		for(int i = lword; i<model.getSize(); i++){
        			String m = strip((String) model.get(i));
        			if(last.length() < m.length() && last.equalsIgnoreCase(m.substring(0, last.length()))){
        				jTextField4.setText(txt.substring(0, txt.length()-last.length())+m);
        				lword=i+1;
        				break;
        			}
        		}
        		key.consume();
        	}
        	
        	else{
        		//System.out.println(k);
        		lword=1;
        		check();
        	}
        }
      }
    }
    
    public static ArrayList<String> extractUrls(String input) {
        ArrayList<String> result = new ArrayList<String>();

        Pattern pattern = Pattern.compile(
            "\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" + 
            "(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov" + 
            "|mil|biz|info|mobi|name|aero|jobs|museum" + 
            "|travel|[a-z]{2}))(:[\\d]{1,5})?" + 
            "(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?" + 
            "((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" + 
            "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)" + 
            "(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" + 
            "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*" + 
            "(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b");

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }
   
    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    } // THE END

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex){
            System.out.println("Look & Feel exception");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new ChatFrame().setVisible(true);
				} catch (NoSuchFieldException | SecurityException| IllegalArgumentException | IllegalAccessException | FontFormatException | IOException e) {
					e.printStackTrace();
				}
            }
        });
    }
    // Variables declaration
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JList<String> jList1;
    public javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea msgArea;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}


