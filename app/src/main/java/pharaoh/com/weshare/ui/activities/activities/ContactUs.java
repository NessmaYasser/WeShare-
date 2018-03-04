package pharaoh.com.weshare.ui.activities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;

public class ContactUs extends RootActivity {

    LinearLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_RTL) {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_right_black_24dp);
        } else {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        }
        setSupportActionBar(toolbar);

        main = (LinearLayout) findViewById(R.id.main);
        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });
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
