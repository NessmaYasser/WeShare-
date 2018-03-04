package pharaoh.com.weshare.ui.activities.activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.models.Home;
import pharaoh.com.weshare.ui.activities.activities.MainActivity;
import pharaoh.com.weshare.ui.activities.activities.PostDetails;
import pharaoh.com.weshare.ui.activities.activities.ProfileActivity;
import pharaoh.com.weshare.ui.activities.activities.StarterActivity;

/**
 * Created by Comptia Ware on 2/8/2018.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    List<Home> homeData;
    Context context;
    private LayoutInflater inflater;

    public HomeAdapter(List<Home> data, Context context){
        this.homeData = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.MyViewHolder holder, int position) {
        Home current = homeData.get(position);
        holder.Image.setImageResource(current.img);
        holder.postBody.setText(current.body);
        holder.posterName.setText(current.posterName);
        holder.dateView.setText(current.date);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,PostDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return homeData.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView Image;
        TextView postBody;
        TextView posterName;
        TextView dateView;

        public MyViewHolder(View itemView) {
            super(itemView);

            Image = (ImageView) itemView.findViewById(R.id.poster_image);
            postBody = (TextView) itemView.findViewById(R.id.post_body);
            posterName = (TextView) itemView.findViewById(R.id.poster_name);
            dateView = (TextView) itemView.findViewById(R.id.date);

        }
    }
}
