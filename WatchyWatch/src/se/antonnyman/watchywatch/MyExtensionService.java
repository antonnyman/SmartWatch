package se.antonnyman.watchywatch;

import android.content.ContentValues;
import android.content.Intent;

import com.sonyericsson.extras.liveware.aef.notification.Notification;
import com.sonyericsson.extras.liveware.extension.util.ExtensionService;
import com.sonyericsson.extras.liveware.extension.util.notification.NotificationUtil;
import com.sonyericsson.extras.liveware.extension.util.registration.RegistrationInformation;

public class MyExtensionService extends ExtensionService {
	
	public static final String ID = "Test.ID";
	public static final String KEY = "Test.Key";
	public static final String NAME = "Test.Name";
	
	public static final String INTENT_SENDNOTIFICATION = "SEND_NOTIFICATIONTEST";
	public static final String EXTRA_TITLE = "EXTRA_TITLE";
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	public static final String EXTRA_ICON = "TESTICON";
	
	public MyExtensionService() {
		super(KEY);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		int val = super.onStartCommand(intent, flags, startId);
		if(intent != null) {
			if(intent.getAction().equals(INTENT_SENDNOTIFICATION)) {
				String title = intent.getExtras().getString(EXTRA_TITLE);
				String message = intent.getExtras().getString(EXTRA_MESSAGE);
				String icon = intent.getExtras().getString(EXTRA_ICON);
				sendNotifications(title, message, icon);
			}
		}
		
		return val;
	}

	@Override
	protected RegistrationInformation getRegistrationInformation() {
		return new MyRegistrationInformation(this, ID, KEY, NAME);
	}

	@Override
	protected boolean keepRunningWhenConnected() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void sendNotifications(String title, String message, String icon) {
	    long sourceId = NotificationUtil.getSourceId(this, ID);
	    
	    if(sourceId == NotificationUtil.INVALID_ID) {
	        return;
	    }
	 
	    ContentValues data = new ContentValues();
	    data.put(Notification.EventColumns.SOURCE_ID, sourceId);
	    data.put(Notification.EventColumns.DISPLAY_NAME, title);
	    data.put(Notification.EventColumns.MESSAGE, message);
	    data.put(Notification.EventColumns.PROFILE_IMAGE_URI, icon);
	    data.put(Notification.EventColumns.PUBLISHED_TIME, System.currentTimeMillis());
	    data.put(Notification.EventColumns.PERSONAL, 1);
	 
	    getContentResolver().insert(Notification.Event.URI, data);
	}

}
