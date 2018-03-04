package pharaoh.com.weshare.ui.activities.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;

public class LoginActivity extends RootActivity {

    TextView uesr_login_title;
    LinearLayout main;
    boolean clicked = true;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setBackgroundDrawableResource(R.drawable.background);

        uesr_login_title = (TextView) findViewById(R.id.user_login_title);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/raleway-semibold.ttf");
        uesr_login_title.setTypeface(myCustomFont);

        Button login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

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

    public void ForgetPassword(View view) {
        startActivity(new Intent(getApplicationContext(), ResetPassword.class));
    }

    public void SignUp(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
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
}
