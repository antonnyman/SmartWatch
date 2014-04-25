package se.antonnyman.watchywatch;

import android.content.ContentValues;
import android.content.Context;

import com.sonyericsson.extras.liveware.aef.notification.Notification;
import com.sonyericsson.extras.liveware.aef.registration.Registration;
import com.sonyericsson.extras.liveware.extension.util.registration.RegistrationInformation;

public class MyRegistrationInformation extends RegistrationInformation {
	
	public final Context context;
	public final String extensionId;
	public final String extensionName;
	public final String extensionKey;

	public MyRegistrationInformation(Context context, String extensionId, String extensionName, String extensionKey) {
		this.context = context;
		this.extensionId = extensionId;
		this.extensionName = extensionName;
		this.extensionKey = extensionKey;
	}
	
	@Override
	public int getRequiredNotificationApiVersion() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public ContentValues getExtensionRegistrationConfiguration() {
		ContentValues values = new ContentValues();
		values.put(Registration.ExtensionColumns.NAME, "WatchyWatch");
		values.put(Registration.ExtensionColumns.HOST_APP_ICON_URI, R.drawable.ic_launcher);
		values.put(Registration.ExtensionColumns.EXTENSION_KEY, this.extensionKey);
		values.put(Registration.ExtensionColumns.EXTENSION_ICON_URI, R.drawable.ic_launcher);
		values.put(Registration.ExtensionColumns.CONFIGURATION_ACTIVITY, MainActivity.class.getName());
		return values;
	}
	
	@Override
	public ContentValues[] getSourceRegistrationConfigurations() {
		ContentValues[] values = new ContentValues[1];
		values[0] = new ContentValues();
		values[0].put(Notification.SourceColumns.EXTENSION_SPECIFIC_ID, extensionId);
		values[0].put(Notification.SourceColumns.NAME, extensionName);
		values[0].put(Notification.SourceColumns.ENABLED, true);
		
		return values;
		
	}

	@Override
	public int getRequiredWidgetApiVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRequiredControlApiVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRequiredSensorApiVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

}
