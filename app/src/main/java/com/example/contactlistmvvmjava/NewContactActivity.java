package com.example.contactlistmvvmjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewContactActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.contactlistmvvmjava.REPLY";

    private EditText mEditContactView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        mEditContactView = findViewById(R.id.edit_contact);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditContactView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String contact = mEditContactView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, contact);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
