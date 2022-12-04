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


public class Calls extends Fragment {


    public Calls() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    ListView call_layouts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calls, container, false);
        call_layouts = view.findViewById(R.id.calls);
        int[] calls_img = new int[]{R.drawable.profilepics, R.drawable.profilepics};
        String[] noOfCalls = new String[]{"0", "10"};
        String[] caller_name = new String[]{"Hephzi", "Hephzibah"};
        String[] date = new String[]{"Monday october 2020", "Tuesday march 2021"};

        CallsAdapter callAdapter = new CallsAdapter(getActivity(), calls_img, noOfCalls, caller_name, date);
        call_layouts.setAdapter(callAdapter);

        return view;
    }

    class CallsAdapter extends BaseAdapter {
        Context context;
        LayoutInflater inflater;
        int[] calls_img;
        String[] noOfCalls, caller_name, date;

        public CallsAdapter(Context context, int[] calls_img, String[] noOfCalls, String[] caller_name, String[] date) {
            this.calls_img = calls_img;
            this.context = context;
            this.noOfCalls = noOfCalls;
            this.caller_name = caller_name;
            this.date = date;
            inflater = (LayoutInflater.from(context.getApplicationContext()));
        }

        @Override
        public int getCount() {
            return caller_name.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.call_layout, null);
            ImageView image = view.findViewById(R.id.call_pics);
            TextView username = view.findViewById(R.id.caller_username);
            TextView last_date = view.findViewById(R.id.last_time_called);
            TextView no_of_calls = view.findViewById(R.id.no_of_calls);

            image.setImageResource(calls_img[i]);
            username.setText(caller_name[i]);
            last_date.setText(date[i]);
            no_of_calls.setText(noOfCalls[i]);
            return view;
        }
    }
}