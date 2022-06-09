package com.example.wappbiu_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wappbiu_android.R;
import com.example.wappbiu_android.entities.Message;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class MessageListAdapter extends RecyclerView.Adapter {
    //LayoutInflater inflater;
    private Context ctx;
    private List<Message> MessageList;
    public MessageListAdapter (Context ctx) {
        this.ctx = ctx;
        this.MessageList = new ArrayList<Message>();
    }

    @Override
    public int getItemCount() {
        return MessageList.size();
    }

    public List<Message> getMessageList() {return MessageList;}

    public void setMessageList(List<Message> messageList) {
        MessageList.clear();
        MessageList.addAll(messageList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        Message message =  MessageList.get(position);

        if (message.isSent()) {
            // If the current user is the sender of the message
            return 1;
        } else {
            // If some other user sent the message
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_in, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == 2) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_out, parent, false);
            return new ReceivedMessageHolder(view);
        }
        return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message message =  MessageList.get(position);

        switch (holder.getItemViewType()) {
            case 1:
                ((SentMessageHolder) holder).bind(message);
                break;
            case 2:
                ((ReceivedMessageHolder) holder).bind(message);
        }
    }
    private class SentMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText;

        SentMessageHolder(View itemView) {
            super(itemView);
            messageText = (TextView) itemView.findViewById(R.id.message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_time);
        }

        void bind(Message message) {
            messageText.setText(message.getContent());
            //timeText.setText(message.getCreated().toString());
//            String strTime2 = DateFormat.getTimeInstance().format(message.getCreated());
            timeText.setText(message.getCreated());

        }
    }

    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText;

        ReceivedMessageHolder(View itemView) {
            super(itemView);
            messageText = (TextView) itemView.findViewById(R.id.message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_time);
        }

        void bind(Message message) {
            messageText.setText(message.getContent());
//            String strDate = DateFormat.getDateInstance().format(message.getCreated());
//            String strTime = DateFormat.getDateTimeInstance().format(message.getCreated());
//            String strTime2 = DateFormat.getTimeInstance().format(message.getCreated());
            timeText.setText(message.getCreated());
        }
    }
}







