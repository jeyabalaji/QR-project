package in.blogspot.khurram2java;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.teamjas.srmqrscan.R;

public class MainActivity extends Activity {
	TextView tvStatus;
	TextView tvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvStatus = (TextView) findViewById(R.id.tvStatus);
		tvResult = (TextView) findViewById(R.id.tvResult);
		
		Button scanBtn = (Button) findViewById(R.id.btnScan);

		//in some trigger function e.g. button press within your code you should add:
		scanBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				try {
					
					Intent intent = new Intent("com.google.zxing.client.android.SCAN");
					intent.putExtra("SCAN_MODE", "QR_CODE_MODE,PRODUCT_MODE");
					View.OnClickListener handler = new View.OnClickListener(){
				        public void onClick(View v) {
				            
				            switch (v.getId()) {

				                case R.id.btnScan:
				                	showNotification();
				                    break;
				             
				            }
				        }
				    };
					
					
					startActivityForResult(intent, 0);
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), "ERROR:" + e, 1).show();

				}

			}
		});

	}
	//In the same activity you�ll need the following to retrieve the results:
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {

			if (resultCode == RESULT_OK) {
				tvStatus.setText(intent.getStringExtra("SCAN_RESULT_FORMAT"));
				tvResult.setText(intent.getStringExtra("SCAN_RESULT"));
			} else if (resultCode == RESULT_CANCELED) {
				tvStatus.setText("Press a button to start a scan.");
				tvResult.setText("Scan cancelled.");
			}
		}
	}
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@SuppressLint("NewApi")
	public void showNotification(){

		// define sound URI, the sound to be played when there's a notification
		Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		
		// intent triggered, you can add other intent for other actions
		Intent intent = new Intent(MainActivity.this, MainActivity.class);
		PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
		
		// this is it, we'll build the notification!
		// in the addAction method, if you don't want any icon, just set the first param to 0
		Notification mNotification = new Notification.Builder(this)
			
			.setContentTitle("New Post!")
			.setContentText("Here's an awesome update for you!")
			.setSmallIcon(R.drawable.ninja)
			.setContentIntent(pIntent)
			.setSound(soundUri)
			
			.addAction(R.drawable.ninja, "View", pIntent)
			.addAction(0, "Remind", pIntent)
			
			.build();
		
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		// If you want to hide the notification after it was selected, do the code below
		// myNotification.flags |= Notification.FLAG_AUTO_CANCEL;
		
		notificationManager.notify(0, mNotification);
	}
	

}
