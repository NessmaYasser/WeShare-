package pharaoh.com.weshare.ui.activities.activities;


import android.app.AlertDialog;
import android.app.Application;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import pharaoh.com.weshare.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment {

    View root;
    ImageView editButton;
    View myPosts;
    View myFollowers;
    View myFollowing;
    LinearLayout contactUs;
    LinearLayout followUs;
    LinearLayout logOut;
    LinearLayout Settings;

    public UserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_userprofile, container, false);

        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
      /** actionBarTitle = (TextView) root.findViewById(R.id.toolbar_title);
        actionBarTitle.setText("My Profile");**/


      editButton = (ImageView) root.findViewById(R.id.edit_icon);
      editButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent i = new Intent(getActivity(), EditProfile.class);
              startActivity(i);
          }
      });

      myPosts = (View) root.findViewById(R.id.my_posts);
      myPosts.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent i = new Intent(getActivity(), MyPosts.class);
              startActivity(i);
          }
      });

        myFollowers = (View) root.findViewById(R.id.following);
        myFollowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MyFollowing.class);
                startActivity(i);
            }
        });

        myFollowing = (View) root.findViewById(R.id.my_followers);
        myFollowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MyFollowers.class);
                startActivity(i);
            }
        });

        contactUs = (LinearLayout) root.findViewById(R.id.contact_us);
        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ContactUs.class);
                startActivity(i);
            }
        });

        followUs = (LinearLayout) root.findViewById(R.id.follow_us2);
        followUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), FollowUs.class);
                startActivity(i);
            }
        });

        logOut = (LinearLayout) root.findViewById(R.id.log_out);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Are you sure you want to logout").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                getActivity().finishAffinity();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog alter = builder.create();
                alter.show();
            }
        });

        Settings = (LinearLayout) root.findViewById(R.id.settings);
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Settings.class);
                startActivity(i);
            }
        });

        return root;
    }



}
