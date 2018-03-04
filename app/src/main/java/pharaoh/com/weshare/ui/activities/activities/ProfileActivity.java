package pharaoh.com.weshare.ui.activities.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;
import pharaoh.com.weshare.models.Home;
import pharaoh.com.weshare.ui.activities.activities.adapters.HomeAdapter;

public class ProfileActivity extends RootActivity {

    TextView actionBarTitle;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    View myFollowers;
    View myFollowing;
    boolean clicked=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_RTL) {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_right_black_24dp);
        } else {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        }
        setSupportActionBar(toolbar);
        actionBarTitle = (TextView) findViewById(R.id.toolbar_title);
        actionBarTitle.setText("Profile");

        recyclerView = (RecyclerView) findViewById(R.id.list);
        adapter = new HomeAdapter(getData(), getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        myFollowers = (View)  findViewById(R.id.following);
        myFollowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MyFollowing1.class);
                startActivity(i);
            }
        });

        myFollowing = (View)  findViewById(R.id.my_followers);
        myFollowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MyFollowers1.class);
                startActivity(i);
            }
        });

    }

    public List<Home> getData() {
        List<Home> data = new ArrayList<>();
        int[] imge = {R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile};
        String[] post = {"asdfghjkmnbvcxzxcvbnbvcxzxcghnbvcxzsdfghjmnbvcxz", "asdfghjkmnbvcxzxcvbnbvcxzxcghnbvcxzsdfghjmnbvcxz", "asdfghjkmnbvcxzxcvbnbvcxzxcghnbvcxzsdfghjmnbvcxz", "asdfghjkmnbvcxzxcvbnbvcxzxcghnbvcxzsdfghjmnbvcxz", "asdfghjkmnbvcxzxcvbnbvcxzxcghnbvcxzsdfghjmnbvcxz"};
        String[] postername = {"Posted By: Ahmade Mohamed", "Posted By: Ahmade Mohamed", "Posted By: Ahmade Mohamed", "Posted By: Ahmade Mohamed", "Posted By: Ahmade Mohamed"};
        String[] date = {"20 November 2018", "20 November 2018", "20 November 2018", "20 November 2018", "20 November 2018"};

        for (int i = 0; i < imge.length; i++) {
            Home current = new Home();
            current.img = imge[i];
            current.body = post[i];
            current.posterName = postername[i];
            current.date = date[i];
            data.add(current);
        }

        return data;
    }

    public void FollowProfile(View view){
        Button follow = (Button) view.findViewById(R.id.follow);
        if (clicked) {
            follow.setText("UNFOLLOW");
            follow.setBackgroundResource(R.drawable.follow_btn_shape);
            follow.setTextColor(Color.parseColor("#000000"));
            clicked = false;
        } else {
            follow.setText("FOLLOW");
            follow.setTextColor(Color.parseColor("#ffffff"));
            follow.setBackgroundResource(R.drawable.button_background);
            clicked = true;
        }
    }

    public void SendMessage(View view){
        startActivity(new Intent(getApplicationContext(), ChatActivity.class));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
