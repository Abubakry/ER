package com.example.er01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TheFormActivity extends AppCompatActivity {

    Button btn_fomrm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_form);




        btn_fomrm = (Button) findViewById(R.id.button);
        btn_fomrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(TheFormActivity.this,PaymentOptionsActivity.class);
                startActivity(in);
            }
        });




    }
}
