package com.example.android.atmsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AtmActivity extends AppCompatActivity {
    int Balance = 0;
    EditText depText, withText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm);

        depText = findViewById(R.id.dep_text);
        withText = findViewById(R.id.with_text);

        SharedPreferences getShared = getSharedPreferences("Bal", MODE_PRIVATE);
        Balance = getShared.getInt("intBal", 0);
        displayBalance();

    }

    public void actionDeposit(View view) {
        String depString = depText.getText().toString();
        if (depString.matches("")) {
            Toast.makeText(this, "Please Enter Amount", Toast.LENGTH_SHORT).show();
            return;
        } else {
            int depInt = Integer.parseInt(depString);
            if (depInt % 100 == 0 && depInt <= 10000) {
                Toast.makeText(this, "Successfully deposited ₹" + depInt, Toast.LENGTH_SHORT).show();
                Balance += depInt;
                displayBalance();
            } else if (depInt % 100 != 0) {
                Toast.makeText(this, "Must be a multiple of 100", Toast.LENGTH_SHORT).show();
            } else if (depInt > 10000) {
                Toast.makeText(this, "Must not exceed ₹10000", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void actionWithdraw(View view) {
        String withString = withText.getText().toString();

        if (withString.matches("")) {
            Toast.makeText(this, "Please Enter Amount", Toast.LENGTH_SHORT).show();
            return;
        } else {
            int withInt = Integer.parseInt(withString);
        if (withInt % 100 == 0 && withInt <= 10000) {
            if (withInt <= Balance) {
                Toast.makeText(this, "Successfully withdrawn ₹" + withInt, Toast.LENGTH_SHORT).show();
                Balance -= withInt;
                displayBalance();
            } else {
                Toast.makeText(this, "Insufficient Balance", Toast.LENGTH_SHORT).show();
            }
        } else if (withInt % 100 != 0) {
            Toast.makeText(this, "Must be a multiple of 100", Toast.LENGTH_SHORT).show();
        } else if (withInt > 10000) {
            Toast.makeText(this, "Must not exceed ₹10000", Toast.LENGTH_SHORT).show();
        }
    }
}

    public void actionExit(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void displayBalance(){
        TextView disBal = findViewById(R.id.actual_balance);
        disBal.setText("₹ "+Balance+"-/");
        SharedPreferences shrBal = getSharedPreferences("Bal", MODE_PRIVATE);
        SharedPreferences.Editor editor = shrBal.edit();
        editor.putInt("intBal", Balance);
        editor.apply();
    }
}