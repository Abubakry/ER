package com.example.er01;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.er01.Adapters.HospitalsAdapter;
import com.example.er01.Controller.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HospitalListActivity extends AppCompatActivity {


    ListView listView;
    HospitalsAdapter adapter;
    ProgressBar loader;
    private final String TAG = "HospitalList Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);
        listView = findViewById(R.id.listView2);
        loader = findViewById(R.id.loader);
        getHospitalsList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    if (!adapter.getIsRoomEmpty(i)){
                        AlertDialog.Builder builder = new AlertDialog.Builder(HospitalListActivity.this);
                        builder.setTitle(R.string.sorry);
                        builder.setMessage(R.string.no_empty_rooms);
                        builder.setIcon(R.drawable.ic_cancel_black_24dp);
                        builder.setPositiveButton(R.string.ok,null);
                        builder.create().show();
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONObject itemSelected = (JSONObject) adapter.getItem(i);
                Intent intent= new Intent(HospitalListActivity.this,BookingFormActivity.class);
                intent.putExtra("itemSelected",itemSelected.toString());
                startActivity(intent);
            }
        });


    }


    private void getHospitalsList() {
        loader.setVisibility(View.VISIBLE);
        StringRequest request = new StringRequest(Request.Method.GET, "https://postsudan.000webhostapp.com/er/list.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loader.setVisibility(View.GONE);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    adapter = new HospitalsAdapter(jsonArray, HospitalListActivity.this);
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(HospitalListActivity.this, "error parsing response", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ", error);
                loader.setVisibility(View.GONE);
            }
        });
        AppController.getInstance().addToRequestQueue(request);
    }
}
