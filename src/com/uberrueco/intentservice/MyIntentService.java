package com.uberrueco.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MyIntentService extends IntentService{

	public MyIntentService(){
		super("MyIntentService");
	}
	
	public MyIntentService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		Log.d("MyIntentService", "handling intent...");
		Bundle extras = intent.getExtras();
		
		//Get the messenger sent by the class who called the service to send the message back.
		Messenger messenger = (Messenger) extras.get("MESSENGER");		
		Message msg = Message.obtain();
		msg.arg1 = 1;
		
		//Send the message
		try {
			messenger.send(msg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
