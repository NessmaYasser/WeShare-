package pharaoh.com.weshare.ui.activities.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;

public class SignUpConfirmation extends RootActivity {

    TextView confirmation_title;
    EditText edittxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_confirmation);

        getWindow().setBackgroundDrawableResource(R.drawable.background);

        confirmation_title = (TextView) findViewById(R.id.confirmation_title);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/raleway-semibold.ttf");
        confirmation_title.setTypeface(myCustomFont);

        edittxt = (EditText) findViewById(R.id.confirm_code);
        edittxt.setTransformationMethod(new ResetPasswordConfirmation.NumericKeyBoardTransformationMethod());
    }

    public void backToSignUp (View view){
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }
}
