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


import pharaoh.com.weshare.models.InboxList;
import java.util.ArrayList;
import java.util.List;


import pharaoh.com.weshare.R;
import pharaoh.com.weshare.ui.activities.activities.adapters.InboxAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class InboxFragment extends Fragment {

    View root;
    private RecyclerView recyclerview;
    private InboxAdapter adapter;

    public InboxFragment() {
        // Required empty public constructor
    }

    public static List<InboxList> getData(){
        List<InboxList> data = new ArrayList<>();

        int[] imgIcon = {R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile};
        String[] Name = {"Ahmad Ali Omran","Ahmad Ali Omran", "Ahmad Ali Omran", "Ahmad Ali Omran", "Ahmad Ali Omran", "Ahmad Ali Omran" , "Ahmad Ali Omran", "Ahmad Ali Omran" };
        String[] date = {"16 Jun At 12 AM", "16 Jun At 12 AM", "16 Jun At 12 AM", "16 Jun At 12 AM", "16 Jun At 12 AM", "16 Jun At 12 AM", "16 Jun At 12 AM", "16 Jun At 12 AM"};
        String[] message = {"edsfghjkjljhgfdghjkl;'lkjhgfdsfghjkl;'lkjhgfdghjkl;", "sdfghjkl;lkjhgfdxcfvbhnjkml,;'lkjh", "dfghjkl;lkjhgfdsdfghjkl;lkmjnhbg", "mnbvcxzsdfghjkl;'lkjuhygtfrdsdfghjkl", "jhgvfcdxsdfghjklkjhgfdfghjkl;l,mnbvcxcxcvbnm", "dfghjkl;lkjhbgvcvbnm", "sdfghjkl", "dcfvgbhnjklokijuhg"};

        for(int i = 0; i< imgIcon.length; i++){

            InboxList current = new InboxList();
            current.name = Name[i];
            current.profile_img = imgIcon[i];
            current.message = message[i];
            current.date = date[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_inbox, container, false);

        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        recyclerview = (RecyclerView) root.findViewById(R.id.inbox_recyclerview);
        recyclerview.setHasFixedSize(true);
        adapter = new InboxAdapter(getData(), getActivity());
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));


        return root;
    }

}
