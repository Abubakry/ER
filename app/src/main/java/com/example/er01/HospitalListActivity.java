package com.example.er01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class HospitalListActivity extends AppCompatActivity {


    ListView listView ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);


        listView =(ListView)findViewById(R.id.listView2) ;



        String [] values = new String[] {"مستشفى الشرطة" , "مستشفى رويال كير", "مستشفى الساحة", "مستشفى القلب", "مستشفى بحري", "مستشفى البراحة", "مستشفى براهيم مالك", "مستشفى السلاح الطبي", "مستشفى علياء"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,values );

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {

                    Intent myIntent = new Intent(view.getContext(), Hospital01Activity.class);
                    startActivityForResult(myIntent, 0);

                }

                if (position == 1) {


                    Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                    startActivityForResult(myIntent, 0);

                }


                if (position == 2) {


                    Intent myIntent = new Intent(view.getContext(), BookingActivity.class);
                    startActivityForResult(myIntent, 0);

                }
                if (position == 3) {


                    Intent myIntent = new Intent(view.getContext(), AboutActivity.class);
                    startActivityForResult(myIntent, 0);

                }
                if (position == 4) {


                    Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                    startActivityForResult(myIntent, 0);

                }
                if (position == 5) {


                    Intent myIntent = new Intent(view.getContext(), AboutActivity.class);
                    startActivityForResult(myIntent, 0);

                }
                if (position == 6) {


                    Intent myIntent = new Intent(view.getContext(), AboutActivity.class);
                    startActivityForResult(myIntent, 0);

                }


            }
        });







    }
}
