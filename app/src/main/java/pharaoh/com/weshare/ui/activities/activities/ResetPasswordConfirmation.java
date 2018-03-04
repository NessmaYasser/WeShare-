package pharaoh.com.weshare.ui.activities.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;

public class ResetPasswordConfirmation extends RootActivity {

    TextView confirmation_title;
    LinearLayout main;
    EditText edittxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_confirmation);

        getWindow().setBackgroundDrawableResource(R.drawable.background);

        confirmation_title = (TextView) findViewById(R.id.confirmation_title);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/raleway-semibold.ttf");
        confirmation_title.setTypeface(myCustomFont);

       /** main= (LinearLayout) findViewById(R.id.main4);
        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });**/

        edittxt = (EditText) findViewById(R.id.confirm_code);
        edittxt.setTransformationMethod(new NumericKeyBoardTransformationMethod());

    }

    public void backToLogin (View view){
        startActivity(new Intent(getApplicationContext(), ResetPassword.class));
    }

    protected static class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source;
        }
    }
}
