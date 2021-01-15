package com.example.er01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Hospital01Activity extends AppCompatActivity {


    Button  btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital01);


        btn_reg = (Button) findViewById(R.id.btn_BookRoom);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Hospital01Activity.this,TheFormActivity.class);
                startActivity(in);
            }
        });


    }






    public void btn_phone_number(View view)

    {
        Intent intent = new Intent (Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0914819837"));
        startActivity(intent);
    }




    public void btn_google_map(View view)

    {
        Intent google_Map = new Intent (Intent.ACTION_VIEW);
        google_Map.setData(Uri.parse("geo:15.579764,32.574669?z=17"));
        startActivity(google_Map);
    }










}
