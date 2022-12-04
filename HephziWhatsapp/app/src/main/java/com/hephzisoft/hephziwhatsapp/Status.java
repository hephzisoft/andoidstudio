package com.hephzisoft.hephziwhatsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Status extends Fragment {


    public Status() {
        // Required empty public constructor
    }

    ListView status_layouts;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status, container, false);
        status_layouts = view.findViewById(R.id.status);
        int[] status_img = new int[]{R.drawable.profilepics, R.drawable.profilepics};
        String[] status_username = new String[]{"Hephzi", "Hephzibah"};
        String[] date = new String[]{"Monday october 2020", "Tuesday march 2021"};

        StatusAdapter statusAdapter = new StatusAdapter(getActivity(), status_img,  status_username, date);
        status_layouts.setAdapter(statusAdapter);
        return view;
    }
    class StatusAdapter extends BaseAdapter{
        Context context;
        LayoutInflater inflater;
        int[] status_img;
        String[] status_username , date;
        public StatusAdapter(Context context, int[] status_img, String[] status_username, String[] date){
            this.status_img = status_img;
            this.context = context;
            this.status_username = status_username;
            this.date = date;
            inflater = (LayoutInflater.from(context.getApplicationContext()));
        }
        @Override
        public int getCount() {
            return status_username.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.status_layout, null);
            ImageView image = convertView.findViewById(R.id.status_pics);
            TextView username = convertView.findViewById(R.id.status_username);
            TextView last_time = convertView.findViewById(R.id.last_added_status);

            image.setImageResource(status_img[position]);
            username.setText(status_username[position]);
            last_time.setText(date[position]);
            return convertView;
        }
    }
}