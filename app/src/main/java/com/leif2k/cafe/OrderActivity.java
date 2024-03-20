package com.leif2k.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private static final String USERNAME = "username";

    private TextView tvHello;
    private TextView tvAdd;

    private RadioGroup rgDrinks;
    private RadioButton rbTea;
    private RadioButton rbCoffee;

    private CheckBox cbSugar;
    private CheckBox cbMilk;
    private CheckBox cbLemon;

    private Spinner spinnerTea;
    private Spinner spinnerCoffee;

    private Button button;

    private String drink;
    private String username;
    private String drinkType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        initViews();
        setHello();

        rgDrinks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == rbTea.getId())
                    onUserChoseTea();
                else if (id == rbCoffee.getId())
                    onUserChoseCoffee();
            }
        });
        rbTea.setChecked(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSend();
            }
        });

    }

    private void onUserChoseTea() {
        drink = getString(R.string.tea);
        tvAdd.setText(getString(R.string.add, drink));
        cbLemon.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);

    }

    private void onUserChoseCoffee() {
        drink = getString(R.string.coffee);
        tvAdd.setText(getString(R.string.add, drink));
        cbLemon.setVisibility(View.INVISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);
        spinnerCoffee.setVisibility(View.VISIBLE);
    }

    private void setHello() {
        username = getIntent().getStringExtra(USERNAME);
        String sHello = getString(R.string.hello, username);
        tvHello.setText(sHello);
    }

    public static Intent newIntent(Context context, String username) {
        Intent intent = new Intent(context, OrderActivity.class);
        intent.putExtra(USERNAME, username);
        return intent;
    }

    private void buttonSend() {
        ArrayList<String> adds = new ArrayList<>();

        if (cbSugar.isChecked())
            adds.add(cbSugar.getText().toString());

        if (cbMilk.isChecked())
            adds.add(cbMilk.getText().toString());

        if (rbTea.isChecked() && cbLemon.isChecked())
            adds.add(cbLemon.getText().toString());

        if (rbTea.isChecked())
            drinkType = spinnerTea.getSelectedItem().toString();
        else if (rbCoffee.isChecked())
            drinkType = spinnerCoffee.getSelectedItem().toString();

        Intent intent = DetailActivity.newIntent(this, username, drink, adds.toString(), drinkType);
        startActivity(intent);
    }

    private void initViews() {
        tvHello = findViewById(R.id.tvHello);
        tvAdd = findViewById(R.id.tvAdd);
        rgDrinks = findViewById(R.id.rgDrinks);
        rbTea = findViewById(R.id.rbTea);
        rbCoffee = findViewById(R.id.rbCoffee);
        cbSugar = findViewById(R.id.cbSugar);
        cbMilk = findViewById(R.id.cbMilk);
        cbLemon = findViewById(R.id.cbLemon);
        spinnerTea = findViewById(R.id.sTea);
        spinnerCoffee = findViewById(R.id.sCoffee);
        button = findViewById(R.id.b_order);
    }

}


