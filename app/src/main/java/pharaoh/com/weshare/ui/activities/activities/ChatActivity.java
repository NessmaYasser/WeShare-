package pharaoh.com.weshare.ui.activities.activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import pharaoh.com.weshare.R;
import pharaoh.com.weshare.RootActivity;
import pharaoh.com.weshare.models.Message;
import pharaoh.com.weshare.ui.activities.activities.adapters.ConversationAdapter;

public class ChatActivity extends RootActivity {

    private TextView actionBarTitle;
    EditText messageInput;
    ImageButton attach,send;

    private ListView chat;
    private ConversationAdapter adapter;
    private ArrayList<Message> messages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_RTL) {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_right_black_24dp);
        } else {
            toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        }
        actionBarTitle = (TextView) findViewById(R.id.toolbar_title);
        actionBarTitle.setText("Ahmed");


        messages=new ArrayList<>();
        messages.add(new Message("Hello Simple Message !","sender","reciver","12.00"));
        Message message= new Message("Hello Simple Message from other user !","sender","reciver","12.01");
        message.fromSender=false;
        messages.add(message);
        chat=(ListView) findViewById(R.id.chatList);
        adapter= new ConversationAdapter(ChatActivity.this,messages);
        chat.setAdapter(adapter);


        attach=(ImageButton) findViewById(R.id.attachmentButton);
        send=(ImageButton) findViewById(R.id.messageSendButton);

        messageInput=(EditText) findViewById(R.id.messageInput);
        messageInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0)
                {
                    send.setColorFilter(ContextCompat.getColor(ChatActivity.this,R.color.white));
                    send.setBackground(ContextCompat.getDrawable(ChatActivity.this,R.drawable.mask_active));
                }
                else
                {
                    send.setColorFilter(ContextCompat.getColor(ChatActivity.this,R.color.gray_message_input));
                    send.setBackground(ContextCompat.getDrawable(ChatActivity.this,R.drawable.mask));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ImageButton send_attatch = (ImageButton) findViewById(R.id.attachmentButton);
        send_attatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent, 1);
            }
        });

        ImageButton send_message = (ImageButton) findViewById(R.id.messageSendButton);
        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message =messageInput.getText().toString();
                if(message.isEmpty())
                {
                    Toast.makeText(ChatActivity.this, "Enter A Message first ..", Toast.LENGTH_SHORT).show();
                    return;
                }
                messageInput.setText("");
                send.setColorFilter(ContextCompat.getColor(ChatActivity.this,R.color.gray_message_input));
                send.setBackground(ContextCompat.getDrawable(ChatActivity.this,R.drawable.mask));


                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                String currentDateTimeString = sdf.format(d);


                Message message1=new Message(message,"dd","ddd",currentDateTimeString);
                messages.add(message1);
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
