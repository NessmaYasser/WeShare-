package pharaoh.com.weshare.ui.activities.activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.models.Follow;
import pharaoh.com.weshare.ui.activities.activities.ProfileActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Comptia Ware on 2/20/2018.
 */

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.MyViewHolder> {

    List<Follow> data;
    Context context;
    private LayoutInflater inflater;
    boolean clicked = true;


    public FollowersAdapter(List<Follow> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public FollowersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.followers_row, parent, false);
        FollowersAdapter.MyViewHolder holder = new FollowersAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FollowersAdapter.MyViewHolder holder, int position) {
        Follow followData = data.get(position);
        holder.Profileimg.setImageResource(followData.profile_img);
        holder.Profileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProfileActivity.class);
                i.setFlags(FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
        holder.Name.setText(followData.name);
        holder.Location.setText(followData.location);
        holder.followbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickFollow(view);
            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void ClickFollow(View view) {
        Button follow = (Button) view.findViewById(R.id.follow_btn);
        if (clicked) {
            follow.setText("UNFOLLOW");
            follow.setBackgroundResource(R.drawable.follow_btn_shape);
            follow.setTextColor(Color.parseColor("#000000"));
            clicked = false;
        } else {
            follow.setText("+ FOLLOW");
            follow.setTextColor(Color.parseColor("#ffffff"));
            follow.setBackgroundResource(R.drawable.button_background);
            follow.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            clicked = true;
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView Profileimg;
        TextView Name;
        TextView Location;
        Button followbtn;

        public MyViewHolder(View itemView) {
            super(itemView);

            Profileimg = (ImageView) itemView.findViewById(R.id.profile_image);
            Name = (TextView) itemView.findViewById(R.id.name_textview);
            Location = (TextView) itemView.findViewById(R.id.location);
            followbtn = (Button) itemView.findViewById(R.id.follow_btn);
        }

    }
}
