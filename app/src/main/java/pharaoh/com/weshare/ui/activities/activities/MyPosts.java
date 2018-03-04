package pharaoh.com.weshare.ui.activities.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;
import pharaoh.com.weshare.models.Home;
import pharaoh.com.weshare.ui.activities.activities.adapters.HomeAdapter;

public class MyPosts extends RootActivity {

    private TextView actionBarTitle;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_posts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_RTL) {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_right_black_24dp);
        } else {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        }
        actionBarTitle = (TextView) findViewById(R.id.toolbar_title);
        actionBarTitle.setText("My Posts");



        //set home content with adapter
        recyclerView = (RecyclerView)  findViewById(R.id.myposts_recycler_view);
        adapter = new HomeAdapter(getData(), getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager( getApplicationContext()));



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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
