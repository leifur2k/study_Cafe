package com.leif2k.cafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView tvUsername;
    TextView tvDrink;
    TextView tvType;
    TextView tvAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();
        setParams();

    }

    private void initViews() {
        tvUsername = findViewById(R.id.tvUsername);
        tvDrink = findViewById(R.id.tvDrink);
        tvType = findViewById(R.id.tvType);
        tvAdd = findViewById(R.id.tvAdd);
    }

    private void setParams() {
        Intent intent = getIntent();

        String getUsername = intent.getStringExtra("username");
        String strUsername = getString(R.string.three_username, getUsername);
        tvUsername.setText(strUsername);

        String getDrink = intent.getStringExtra("drink");
        String strDrink = getString(R.string.three_drink, getDrink);
        tvDrink.setText(strDrink);

        String getType = intent.getStringExtra("type");
        String strType = getString(R.string.three_type, getType);
        tvType.setText(strType);

        String getAdd = intent.getStringExtra("add");
        String strAdd = getString(R.string.three_add, getAdd);
        tvAdd.setText(strAdd);
    }


    public static Intent newIntent(Context context, String username, String drink, String add, String drinkType) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("drink", drink);
        intent.putExtra("add", add);
        intent.putExtra("type", drinkType);
        return intent;
    }

}