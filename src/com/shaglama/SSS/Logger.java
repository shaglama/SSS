package com.shaglama.SSS;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import com.shaglama.Messenger.Handle;
import com.shaglama.Messenger.Message;
import com.shaglama.Messenger.MessageType;

public class Logger extends Module{

	public Logger(Handle handle){
		super("logger",handle);
	}
	@Override
	public void newMessage(Message message){
		MessageType type = message.getType();
		switch(type){
		case EVENT:
			
			break;
		case ERROR:
			
			break;
		case INFO:
			
			break;
		case LOG:
			try(	FileWriter fw = new FileWriter(message.getAudience() + "_log.txt",true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw)){
				out.println(message.getData().toString());
			} catch (IOException ioe){
				
			}
			break;
		default:
			//error		
		}
		
	}
}
