package com.socket;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ui.ChatFrame;

public class BadBot {
	
	SocketClient client;
	ChatFrame ui;
	ArrayList<String> items = new ArrayList<String>();

	public BadBot(SocketClient client, ChatFrame chatFrame) {
		this.client = client;
		this.ui = chatFrame;
	}

	public void botCheck(String sender, String chan, String msg) throws UnsupportedEncodingException, GeneralSecurityException{
    	
        if(msg.startsWith("/me gives "+ui.username)){
    		String item = msg.substring(11+ui.username.length());
    		items.add(item);
    		ui.prepareSend("/me now has "+item+" up his bum. Yay!" , chan);
    	}
    	else if(msg.startsWith("!inventory")){
    		ui.prepareSend("/me has "+items.toString()+" in his bum.", chan);
    	}
    	else if(msg.startsWith("!invent")){
    		if(items.size()>0)
    		ui.prepareSend("/me combines "+getRandom(items)+" and "+getRandom(items)+" to make "+getRandom(items), chan);
    	}
    	else if(msg.contains("kuk")){
    		String[] kuk = {(sender.toUpperCase()+", SOG KOKK A"), "GAAAYYYYY!", "/me tar kuken til "+sender+" og løper", msg.replaceAll("kuk", "kek")};
    		ui.prepareSend(getRandom(kuk), chan);
    	}
    	
    	//save stuff in file
    }
    
    public String getRandom(String[] arr){
    	return getRandom(Arrays.asList(arr));
    }
    public String getRandom(List<String> arr){
    	if(arr.size()>0){
    		Collections.shuffle(arr);
    		return arr.get(0);
    	}
    	return null;
    }
	
}
