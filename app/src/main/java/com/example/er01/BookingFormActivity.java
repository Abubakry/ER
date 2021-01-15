package com.example.er01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.er01.Adapters.HospitalsAdapter;
import com.example.er01.Controller.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BookingFormActivity extends AppCompatActivity {

    Button btn_book;
    EditText patientName, pateintAge, assistantName, assistantPhoneNumber, assistantRelation;
    ProgressDialog loader;
    JSONObject hospitalInfo;
    private final String TAG = "BookingForm Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_form);
        setTitle(R.string.reverse_room);
        btn_book = (Button) findViewById(R.id.btn);
        patientName = findViewById(R.id.patientName);
        pateintAge = findViewById(R.id.patientAge);
        assistantName = findViewById(R.id.assistantName);
        assistantPhoneNumber = findViewById(R.id.assistantPhoneNumber);
        assistantRelation = findViewById(R.id.assistantRelation);
        loader = new ProgressDialog(this);
        loader.setMessage(getResources().getString(R.string.loading));
        loader.setCancelable(false);

        try {
            hospitalInfo = new JSONObject(getIntent().getStringExtra("itemSelected"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sendBookingRequest();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private void sendBookingRequest() throws JSONException {
        loader.show();
        JSONObject params = new JSONObject();
        params.put("hos_name",hospitalInfo.getString("hos_name"));
        params.put("hos_id",hospitalInfo.getString("hos_id"));
        params.put("patient_name",patientName.getText());
        params.put("age",pateintAge.getText());
        params.put("booking_perosn_name",assistantName.getText());
        params.put("booking_perosn_phone",assistantPhoneNumber.getText());
        params.put("relationship_with_patient",assistantRelation.getText());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "https://postsudan.000webhostapp.com/er/booking_room.php",
                params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                loader.hide();
                try {
                    int responseCode = response.getInt("responseCode");
                    if (responseCode == 0){
                        startActivity(new Intent(BookingFormActivity.this, PaymentOptionsActivity.class));
                        finish();
//                        Toast.makeText(BookingFormActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    }else {
                    badAlert(getResources().getString(R.string.failed),response.getString("responseMessage"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(BookingFormActivity.this, "error parsing response", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ", error);
                loader.hide();
                Toast.makeText(BookingFormActivity.this, "request error", Toast.LENGTH_SHORT).show();
            }
        }) {
        };
        AppController.getInstance().addToRequestQueue(request);
    }

    private void badAlert(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(R.drawable.ic_cancel_black_24dp);
        builder.setPositiveButton(R.string.ok,null);
        builder.create().show();
    }
}
