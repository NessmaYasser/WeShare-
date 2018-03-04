package pharaoh.com.weshare.ui.activities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;
import pharaoh.com.weshare.models.Follow;
import pharaoh.com.weshare.ui.activities.activities.adapters.FollowAdapter;

public class MyFollowing1 extends RootActivity {

    private RecyclerView recyclerview;
    private FollowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_following1);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_RTL) {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_right_black_24dp);
        } else {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        }

        recyclerview = (RecyclerView) findViewById(R.id.inbox_recyclerview);
        recyclerview.setHasFixedSize(true);
        adapter = new FollowAdapter(getData(), getApplicationContext());
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public static List<Follow> getData(){
        List<Follow> data = new ArrayList<>();

        int[] imgIcon = {R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile};
        String[] Name = {"Ahmad Ali Omran","Ahmad Ali Omran", "Ahmad Ali Omran", "Ahmad Ali Omran", "Ahmad Ali Omran", "Ahmad Ali Omran" , "Ahmad Ali Omran", "Ahmad Ali Omran" };
        String[] location = {"Maadi, Cairo", "Maadi, Cairo", "Maadi, Cairo", "Maadi, Cairo", "Maadi, Cairo", "Maadi, Cairo", "Maadi, Cairo", "Maadi, Cairo"};
        for(int i = 0; i< imgIcon.length; i++){

            Follow current = new Follow();
            current.name = Name[i];
            current.profile_img = imgIcon[i];
            current.location =location[i];
            data.add(current);
        }
        return data;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
