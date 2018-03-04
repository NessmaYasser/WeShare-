package pharaoh.com.weshare.ui.activities.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import java.util.Locale;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;

public class ChangePassword extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_RTL) {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_right_black_24dp);
        } else {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        }
        setSupportActionBar(toolbar);
    }

    public void ChangPass (View view){
        Intent i = new Intent(getApplicationContext(), ResetPassword.class);
        startActivity(i);
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
