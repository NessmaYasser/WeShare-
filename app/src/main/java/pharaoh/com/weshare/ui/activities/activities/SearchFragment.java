package pharaoh.com.weshare.ui.activities.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.models.Home;
import pharaoh.com.weshare.ui.activities.activities.adapters.HomeAdapter;


public class SearchFragment extends Fragment {

    View root;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root = inflater.inflate(R.layout.fragment_search, container, false);

        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        Spinner spinner1 = (Spinner) root.findViewById(R.id.spinner1);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_items1, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);

        Spinner spinner = (Spinner) root.findViewById(R.id.spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_items2, R.layout.spinner_item_text_custom);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter2);

        recyclerView = (RecyclerView) root.findViewById(R.id.search_recycler_view);
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
