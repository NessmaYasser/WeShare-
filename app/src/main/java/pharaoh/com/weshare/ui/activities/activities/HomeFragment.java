package pharaoh.com.weshare.ui.activities.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.models.Home;
import pharaoh.com.weshare.ui.activities.activities.adapters.HomeAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    RelativeLayout addPostview;
    ImageButton addPostIcon;


    public HomeFragment() {
        // Required empty public constructor
    }


    View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root= inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        addPostview = (RelativeLayout) root.findViewById(R.id.add_post_view);
        addPostview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(root.getContext(), AddPost.class);
                startActivity(i);
            }});

        addPostIcon = (ImageButton) root.findViewById(R.id.add_post_icon);
        addPostIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(root.getContext(), AddPost.class);
                startActivity(i);
            }
        });


        //set home content with adapter
        recyclerView = (RecyclerView) root.findViewById(R.id.home_recycler_view);
        adapter = new HomeAdapter(getData(), getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager( getActivity()));


        return root;
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


}
