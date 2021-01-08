package com.example.er01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ShowHospitalActivity extends AppCompatActivity {

    Button btn_abt,btn_hospial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hospital);

        btn_abt =(Button)findViewById(R.id.button);
        btn_abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  in = new Intent(ShowHospitalActivity.this,AboutActivity.class);
                startActivity(in);
            }
        });



        btn_hospial =(Button)findViewById(R.id.btn3);
        btn_hospial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rs = new Intent(ShowHospitalActivity.this,HospitalListActivity.class);
                startActivity(rs);
            }
        });


    }
}
