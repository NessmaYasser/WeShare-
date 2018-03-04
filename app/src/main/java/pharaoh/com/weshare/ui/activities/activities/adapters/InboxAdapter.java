package pharaoh.com.weshare.ui.activities.activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.models.InboxList;
import pharaoh.com.weshare.ui.activities.activities.ChatActivity;

/**
 * Created by Comptia Ware on 2/18/2018.
 */

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.MyViewHolder> {

    List<InboxList> data ;
    Context context;
    private LayoutInflater inflater;

    public InboxAdapter(List<InboxList> data, Context context){
        this.data = data;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public InboxAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.inbox_row_of_list, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(InboxAdapter.MyViewHolder holder, int position) {
        InboxList inboxData = data.get(position);
        holder.ChatImg.setImageResource(inboxData.profile_img);
        holder.Name.setText(inboxData.name);
        holder.Message.setText(inboxData.message);
        holder.Date.setText(inboxData.date);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ChatActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView ChatImg;
        TextView Name;
        TextView Message;
        TextView Date;

        public MyViewHolder(View itemView) {
            super(itemView);

            ChatImg = (ImageView) itemView.findViewById(R.id.profile_image);
            Name = (TextView) itemView.findViewById(R.id.name_textview);
            Message = (TextView) itemView.findViewById(R.id.message_textview);
            Date = (TextView) itemView.findViewById(R.id.date_and_time);
        }

    }
    }
