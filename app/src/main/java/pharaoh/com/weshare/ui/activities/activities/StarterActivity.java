package pharaoh.com.weshare.ui.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;

public class StarterActivity extends RootActivity {

    Button login, sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

        //new activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intro = new Intent(StarterActivity.this, LoginActivity.class);
                startActivity(intro);
                finish();
            }
        }, 2000);

    }
}
