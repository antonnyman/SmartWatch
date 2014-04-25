package se.antonnyman.watchywatch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("Testing", intent.getAction());
		intent.setClass(context, MyExtensionService.class);
		context.startService(intent);
		
	}

}
