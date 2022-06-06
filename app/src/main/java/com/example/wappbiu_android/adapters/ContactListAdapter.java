package com.example.wappbiu_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wappbiu_android.R;
import com.example.wappbiu_android.entities.Contact;

import java.util.ArrayList;

public class ContactListAdapter extends ArrayAdapter<Contact> {
    LayoutInflater inflater;
    public ContactListAdapter(Context ctx, ArrayList<Contact> contactArrayList) {
        super(ctx, R.layout.contact_item, contactArrayList);
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Contact contact = getItem(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.contact_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.profile_image);
        TextView userName = convertView.findViewById(R.id.user_name);
        TextView lastMsg = convertView.findViewById(R.id.last_massage);
        TextView time = convertView.findViewById(R.id.time);

        imageView.setImageResource(R.drawable.profileimage);
        userName.setText(contact.getName());
        lastMsg.setText(contact.getLast());
        time.setText(contact.getLastDate().toString());
        return convertView;
    }

}
