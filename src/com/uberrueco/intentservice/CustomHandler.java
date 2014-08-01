package com.uberrueco.intentservice;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class CustomHandler extends Handler{
	
	private Context context;
	
	/*
	 * Custom constructor for our handler
	 * @params context: Context from where our handler is being called.
	 */
	public CustomHandler (Context context){
		this.context = context;
	}

	@Override
	public void handleMessage(Message msg) {
		
		super.handleMessage(msg);
		if (msg.arg1 == 1) {
    		Toast.makeText(context,
	            "Message received, IntentService finished.", Toast.LENGTH_LONG)
	            .show();
    	} else {
    		Toast.makeText(context, "Error message received.",
	            Toast.LENGTH_LONG).show();
    	}
	}

}
