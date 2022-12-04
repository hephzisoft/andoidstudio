package com.hephzisoft.hephziwhatsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Chats extends Fragment {


    public Chats() {
        // Required empty public constructor
    }

  ListView  chats_layout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_chats, container, false);
        chats_layout = view.findViewById(R.id.chats);
        int[] chat_img = new int[]{R.drawable.profilepics, R.drawable.profilepics};
        String[] no_of_msg = new String[]{"0", "10"};
        String[] chat_username = new String[]{"Hephzi", "David"};
        String[] last_message = new String[]{"Hello, How are you", "I am fine "};
        String[] last_chat_date = new String[]{"12:30am", "11:20pm"};

        ChatsAdapter chatsAdapter = new ChatsAdapter(getActivity(), chat_img, no_of_msg, chat_username, last_chat_date, last_message);
        chats_layout.setAdapter(chatsAdapter);

        return view;
    }

    class ChatsAdapter extends BaseAdapter{
        Context context;
        LayoutInflater inflater;
        String[] no_of_msg, chat_username, last_message, last_chat_date;
        int[] chat_img;

        public ChatsAdapter(Context context, int[] chat_img, String[] no_of_msg, String[] chat_username, String[] last_chat_date, String[] last_message) {
            this.chat_img = chat_img;
            this.context = context;
            this.no_of_msg = no_of_msg;
            this.chat_username = chat_username;
            this.last_chat_date = last_chat_date;
            this.last_message = last_message;
            inflater = (LayoutInflater.from(context.getApplicationContext()));
        }

        @Override
        public int getCount() {
            return chat_username.length;
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
        public View getView(int position, View chatView, ViewGroup parent) {
            chatView = inflater.inflate(R.layout.chats_layout, null);

            ImageView image = chatView.findViewById(R.id.chat_img);
            TextView chat_usernames = chatView.findViewById(R.id.chat_username);
            TextView last_messages = chatView.findViewById(R.id.last_message);
            TextView date_time = chatView.findViewById(R.id.last_message_time);
            TextView no_of_message = chatView.findViewById(R.id.no_of_message);

            image.setImageResource(chat_img[position]);
            chat_usernames.setText(chat_username[position]);
            no_of_message.setText(no_of_msg[position]);
            last_messages.setText(last_message[position]);
            date_time.setText(last_chat_date[position]);



            return chatView;
        }
    }
}