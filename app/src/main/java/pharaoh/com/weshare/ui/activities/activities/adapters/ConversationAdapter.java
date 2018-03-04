package pharaoh.com.weshare.ui.activities.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.models.Message;


/**
 * Created by Comptia Ware on 2/17/2018.
 */

public class ConversationAdapter extends BaseAdapter {

    public Context context;
    LayoutInflater inflater;
    private ArrayList<Message> messages;

    public ConversationAdapter(Context context, ArrayList<Message> messages) {
        this.context = context;
        this.messages = messages;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (messages.get(i).fromSender) {
            view = inflater.inflate(R.layout.item_message_send, null);
        } else {
            view = inflater.inflate(R.layout.item_chat_recieve, null);
        }


        TextView message = (TextView) view.findViewById(R.id.messageText);
        message.setText(messages.get(i).getContent());

        TextView date = (TextView) view.findViewById(R.id.messageTime);
        date.setText(messages.get(i).date);

        return view;
    }


}

