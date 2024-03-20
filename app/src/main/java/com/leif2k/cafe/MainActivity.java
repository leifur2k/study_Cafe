package com.leif2k.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText1;
    EditText editText2;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonSend();
            }
        });

    }

    private void initViews() {
        button = findViewById(R.id.buttonEnter);
        editText1 = findViewById(R.id.editTextName);
        editText2 = findViewById(R.id.editTextPassword);
        textView1 = findViewById(R.id.tvWrong);
    }

    private void buttonSend() {

        String username = editText1.getText().toString().trim();
        String password = editText2.getText().toString().trim();

        if (username.length() > 2) if (password.equals("1234")) {
            launchNextScreen(username);
        } else {
            textView1.setText("Неправильный пароль!");
            textView1.setVisibility(View.VISIBLE);
        }
        else {
            textView1.setText("Введите корректный Логин!");
            textView1.setVisibility(View.VISIBLE);
        }

    }

    private void launchNextScreen(String usrnm) {
        Intent intent = OrderActivity.newIntent(this, usrnm);
        startActivity(intent);
    }

}


