package pharaoh.com.weshare.ui.activities.activities;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;

public class AddPost extends RootActivity {

    TextView actionBarTitle;
    FrameLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_RTL) {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_right_black_24dp);
        } else {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        }
        setSupportActionBar(toolbar);
        actionBarTitle = (TextView) findViewById(R.id.toolbar_title);
        actionBarTitle.setText("Add Post");

        main= (FrameLayout) findViewById(R.id.main);
        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(AddPost.this,
                R.array.spinner_items11, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(AddPost.this,
                R.array.spinner_items22, R.layout.spinner_item_text_custom);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter2);

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
