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
import java.util.List;

public class ContactListAdapter extends ArrayAdapter<Contact> {
    LayoutInflater inflater;
    List<Contact> contactArrayList;
    public ContactListAdapter(Context ctx, List<Contact> contactArrayList) {
        super(ctx, R.layout.contact_item, contactArrayList);
        this.contactArrayList = contactArrayList;
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
        userName.setText(contact.getId());
        lastMsg.setText(contact.getLast());
        time.setText(contact.getLastDate());
        return convertView;
    }
    public void setContacts(List<Contact> c) {
        contactArrayList.clear();
        contactArrayList.addAll(c);
        notifyDataSetChanged();
    }

}


