package com.example.er01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    Button btn_loc, btn_reg, btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btn_loc = (Button) findViewById(R.id.button2);
        btn_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/d/viewer?mid=16YhaZGXMUi-xRTsXG12dQ7sGbPUO187j&ll=15.357414070071286%2C30.346528249999984&z=7"));
                startActivity(browserIntent);
            }
        });
        btn_reg=(Button)findViewById(R.id.btn3);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AboutActivity.this,HospitalListActivity.class);
                startActivity(in);
            }
        });
        btn_home=(Button)findViewById(R.id.btn_1);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AboutActivity.this,MainActivity.class);
                startActivity(in);
            }
        });

    }
}
