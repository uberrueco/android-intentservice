package com.uberrueco.intentservice;

/* uberrueco
 * @author: Ulises Cuevas Berrueco
 * date:    May/5/2013
 */

import android.os.Bundle;
import android.os.Messenger;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	private CustomHandler handler = new CustomHandler(MainActivity.this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view) {
	    
		//Intent created for IntentService
		Intent intent = new Intent(this, MyIntentService.class);
	    
	    // A messenger should be sent as an extra in the intent with our handler
	    Messenger messenger = new Messenger(handler);
	    intent.putExtra("MESSENGER", messenger);
	    
	    // Start the service
	    startService(intent);
	}
}
