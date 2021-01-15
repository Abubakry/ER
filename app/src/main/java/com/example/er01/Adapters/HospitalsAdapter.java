package com.example.er01.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.er01.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HospitalsAdapter extends BaseAdapter {
    JSONArray items;
    Context context;
    LayoutInflater inflater;
    boolean isRoomEmpty;

    public HospitalsAdapter(JSONArray items, Context context) {
        this.items = items;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.length();
    }

    @Override
    public Object getItem(int i) {
        try {
            return items.getJSONObject(i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.hospital_item, null);
        TextView hospitalName = view.findViewById(R.id.hospitalName);
        ImageView indicator = view.findViewById(R.id.indicator);
        try {
            JSONObject currentItem = items.getJSONObject(position);
            hospitalName.setText(currentItem.getString("hos_name"));
            if (getIsRoomEmpty(position)) {
                indicator.setImageResource(R.drawable.ic_check_circle_black_24dp);
            } else {
                indicator.setImageResource(R.drawable.ic_cancel_black_24dp);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }

    public boolean getIsRoomEmpty(int position) throws JSONException {
        JSONObject currentItem = items.getJSONObject(position);
        int allRooms = currentItem.getInt("ER_rooms");
        int takenRooms = currentItem.getInt("ER_use_rooms");
        int emptyRooms = allRooms - takenRooms;
        if (emptyRooms > 0) isRoomEmpty = true;
        else isRoomEmpty = false;
        return isRoomEmpty;
    }
}
