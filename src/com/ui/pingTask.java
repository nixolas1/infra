package com.ui;

import java.util.Calendar;
import java.util.TimerTask;

import com.socket.SocketClient;

public class pingTask extends TimerTask {
	
	SocketClient client;
	Calendar time = Calendar.getInstance();
	long sentTime=-1;
	long ping=-1;
	boolean sent = false;
	
	public pingTask(SocketClient client) {
		this.client = client;
	}

	@Override
	public void run() {
		client.send("PING", "INFRA");
		sentTime=time.getTimeInMillis();
		sent=true;
	}
	
	public int getPing(){
		if(sent){
			ping=time.getTimeInMillis()-sentTime;
			sent=false;
		}
		return (int) ping;
	}

}
