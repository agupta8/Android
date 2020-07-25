package com.dance.h2ostudioz.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dance.h2ostudioz.R;

public class Enquiry extends AppCompatActivity {

    TextView title;
    EditText etName, etEmail, etNumber, etMsg;
    Button btSubmit;
    String name, number, msg, email, emailPattern;
    String sendNumber = "9755807881";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title = (TextView) findViewById(R.id.h2o_title);
        etName = (EditText) findViewById(R.id.name);
        etEmail = (EditText) findViewById(R.id.email);

        email = etEmail.getText().toString().trim();
        emailPattern = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        etNumber = (EditText) findViewById(R.id.number);
        etMsg = (EditText) findViewById(R.id.msg);
        btSubmit = (Button) findViewById(R.id.submit_button);
        btSubmit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etName.getText().toString().length() == 0) {
                    etName.setError("Name not entered");
                    etName.requestFocus();
                }
                if (!email.matches(emailPattern)) {
                    etEmail.setError("Invalid email address");
                    etEmail.requestFocus();
                }

                if (etNumber.getText().toString().length() == 0) {
                    etNumber.setError("Phone number not entered");
                    etNumber.requestFocus();
                }
                if (etMsg.getText().toString().length() == 0) {
                    etMsg.setError("Message not entered");
                    etMsg.requestFocus();
                } else {
                    Toast.makeText(Enquiry.this, "Thanks for submit your query",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
