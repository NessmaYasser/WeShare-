package pharaoh.com.weshare.ui.activities.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;

import java.util.ArrayList;
import java.util.List;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;
import pharaoh.com.weshare.models.Home;
import pharaoh.com.weshare.ui.activities.activities.adapters.HomeAdapter;


public class MainActivity extends RootActivity {

    AHBottomNavigation bottomNavigationBar;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HomeFragment fragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit();



        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        AHBottomNavigationAdapter navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.menu_main);
        navigationAdapter.setupWithBottomNavigation(bottomNavigation);

        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigation.setCurrentItem(2);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#ffffff"));
        // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

        // Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#3B96D2"));
        bottomNavigation.setInactiveColor(Color.parseColor("#000000"));

        bottomNavigation.setForceTint(true);


        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                switch (position)
                {
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace
                                (R.id.fragment_container,new SearchFragment()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace
                                (R.id.fragment_container,new InboxFragment()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace
                                (R.id.fragment_container,new HomeFragment()).commit();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Heddd", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        getSupportFragmentManager().beginTransaction().replace
                                (R.id.fragment_container,new UserProfileFragment()).commit();
                        break;

                    default:
                            break;
                }

                return  true;
            }
        });

        //  bottomNavigation.setColored(true);

       // startActivity(new Intent(this, StarterActivity.class));



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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        switch (id)
        {
            case R.id.inbox:
                Toast.makeText(this, "Heddd", Toast.LENGTH_SHORT).show();
                break;




            default:
                break;
        }


        return super.onOptionsItemSelected(item);


    }


}