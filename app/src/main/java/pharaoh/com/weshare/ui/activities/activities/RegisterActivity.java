package pharaoh.com.weshare.ui.activities.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;
import pharaoh.com.weshare.models.URL;
import retrofit2.http.Url;

public class RegisterActivity extends RootActivity {
    TextView signup_title;
    LinearLayout main;
    boolean clicked = true;
    TextView gender;
    TextView dateOfBirth;

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getWindow().setBackgroundDrawableResource(R.drawable.background);

        signup_title = (TextView) findViewById(R.id.signup_title);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/raleway-semibold.ttf");
        signup_title.setTypeface(myCustomFont);

        main= (LinearLayout) findViewById(R.id.main2);
        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });

        gender = (TextView) findViewById(R.id.Gender);

        dateView = (TextView) findViewById(R.id.date_of_birth);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void PasswordVisability (View view){
        final ImageView visability = (ImageView) findViewById(R.id.password_visability);
        final PasswordEditText password = (PasswordEditText) findViewById(R.id.password);

        visability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicked){
                    visability.setImageResource(R.drawable.ic_visibility_black_24dp);
                    password.setTransformationMethod(null);
                    clicked=false;
                }
                else{
                    visability.setImageResource(R.drawable.ic_visibility_off_black_24dp);
                    password.setTransformationMethod(new PasswordTransformationMethod());
                    clicked=true;
                }

            }
        });


    }

    public void pickGender(View view)
    {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(RegisterActivity.this);
        builderSingle.setTitle("Gender");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(RegisterActivity.this
                , android.R.layout.select_dialog_singlechoice);

        arrayAdapter.add("Male");
        arrayAdapter.add("Female");

        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                gender.setText(strName);
            }
        });

        builderSingle.show();

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void register(View view) {


        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST, URL.baseUrl+"/user", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

              //  handleResponse(response);
              //  submit.setEnabled(true);
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterActivity.this, "Error" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put("bio", "asdasd");
                params.put("city", "qwqw");
                params.put("email", "qdsadasd");

                params.put("name", "");
                params.put("name", "");
                params.put("name", "");
                params.put("name", "");
                params.put("name", "");
                params.put("name", "");





              /**  params.put("name", "");
                params.put("phone", phoneString);
                params.put("total", String.valueOf(temp));
                params.put("place_id", String.valueOf(places.get(spinner.getSelectedItemPosition()).getId()));
                params.put("products", json);**/

                return params;
            }

        };

        queue.add(request);

    }

    public void backToLogin (View view){
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    public void Confirmation (View view){
        Intent i = new Intent(getApplicationContext(), SignUpConfirmation.class);
        startActivity(i);
    }
}
