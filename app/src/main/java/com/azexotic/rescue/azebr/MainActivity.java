package com.azexotic.rescue.azebr;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String directions = "https://www.google.com/maps/dir/?api=1&destination=AZ+Exotic+Bird+Rescue+Scottsdale+AZ";
    private String phoneNumber = "tel:4805354999";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void getEvents(View view){
        Intent eventIntent = new Intent(this, EventsActivity.class);
        startActivity(eventIntent);
    }

    //Opens services activity
    public void getServices(View view){
        Intent serviceIntent = new Intent(this, ServicesActivity.class);
        startActivity(serviceIntent);
    }

    //Opens education activity
    public void getEducation(View view){
        Intent educationIntent = new Intent(this, EducationActivity.class);
        startActivity(educationIntent);
    }

}
