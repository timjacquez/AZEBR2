package com.azexotic.rescue.azebr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ServicesActivity extends AppCompatActivity {

    private String schedule = "http://www.azexoticbirdrescue.org/boarding-grooming";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
    }
    //Launches web browser to grooming/boarding scheduler page
    public void getSchedule(View view){
        Intent scheduleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(schedule));
        startActivity(scheduleIntent);
    }
}