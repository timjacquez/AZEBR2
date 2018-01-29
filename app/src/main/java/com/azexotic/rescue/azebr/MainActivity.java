package com.azexotic.rescue.azebr;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Context;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String directions = "https://www.google.com/maps/dir/?api=1&destination=AZ+Exotic+Bird+Rescue+Scottsdale+AZ";
    private String donations = "https://www.paypal.com/us/cgi-bin/webscr?cmd=_donations&business=info@azebr.org&lc=US&no_note=0&currency_code=USD&bn=PP-DonationsBF%3Abtn_donateCC_LG.gif%3ANonHostedGuest&submit.x=76&submit.y=8#";
    private String phoneNumber = "tel:4805354999";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create channel to show notifications.
            String channelId  = getString(R.string.default_notification_channel_id);
            String channelName = getString(R.string.default_notification_channel_name);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel(channelId,
                    channelName, NotificationManager.IMPORTANCE_LOW));
        }


        // If a notification message is tapped, any data accompanying the notification
        // message is available in the intent extras. In this sample the launcher
        // intent is fired when the notification is tapped, so any accompanying data would
        // be handled here. If you want a different intent fired, set the click_action
        // field of the notification message to the desired intent. The launcher intent
        // is used when no click_action is specified.
        //
        // Handle possible data accompanying notification message.
        // [START handle_data_extras]
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d(TAG, "Key: " + key + " Value: " + value);
            }
        }
        // [END handle_data_extras]


        String token = FirebaseInstanceId.getInstance().getToken();

        // Log and toast
        String msg = getString(R.string.msg_token_fmt, token);
        Log.d(TAG, msg);


    }

    //Starts navigation
    public void getDirections(View view){
        Intent directionsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(directions));
        startActivity(directionsIntent);
    }

    //Makes phone call
    public void makeCall(View view){
        ContextCompat.checkSelfPermission( this, Manifest.permission.CALL_PHONE );
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse(phoneNumber));
        startActivity(callIntent);

    }

    //Opens bird adoption activity
    public void getBirds(View view){
        Intent birdIntent = new Intent(this, BirdsActivity.class);
        startActivity(birdIntent);
    }

    //Opens events activity
    public void getDonation(View view){
        Intent donationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(donations));
        startActivity(donationIntent);
        String token = FirebaseInstanceId.getInstance().getToken();


    }

    //Opens services activity
    public void getServices(View view){
        Intent serviceIntent = new Intent(this, ServicesActivity.class);
        startActivity(serviceIntent);
    }

    //Opens education activity
    public void getEvents(View view){
        Intent eventIntent = new Intent(this, EventsActivity.class);
        startActivity(eventIntent);
    }

}
