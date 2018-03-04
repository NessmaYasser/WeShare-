package pharaoh.com.weshare.ui.activities.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;

public class ResetPassword extends RootActivity {

    TextView forget_password_title;
    LinearLayout main;
    boolean clicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        getWindow().setBackgroundDrawableResource(R.drawable.background);
        main = (LinearLayout) findViewById(R.id.main3);
        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });


        forget_password_title = (TextView) findViewById(R.id.forget_password_title);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/raleway-semibold.ttf");
        forget_password_title.setTypeface(myCustomFont);
    }

    public void SendCodeToReset(View view) {
        startActivity(new Intent(getApplicationContext(), ResetPasswordConfirmation.class));
    }

    public void PasswordVisability(View view) {
        final ImageView visability = (ImageView) findViewById(R.id.password_visability);
        final PasswordEditText password = (PasswordEditText) findViewById(R.id.password);

        visability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clicked) {
                    visability.setImageResource(R.drawable.ic_visibility_black_24dp);
                    password.setTransformationMethod(null);
                    clicked = false;
                } else {
                    visability.setImageResource(R.drawable.ic_visibility_off_black_24dp);
                    password.setTransformationMethod(new PasswordTransformationMethod());
                    clicked = true;
                }

            }
        });


    }

    public void backToLogin(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
