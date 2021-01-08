package com.example.er01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookingFormActivity extends AppCompatActivity {

    Button btn_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_form);


        btn_book = (Button) findViewById(R.id.btn);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BookingFormActivity.this,BookingLetterActivity.class);
                startActivity(in);
            }
        });



    }
}
