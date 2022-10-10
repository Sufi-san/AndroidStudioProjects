package com.example.android.atmsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AtmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm);
    }

    public void actionExit(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void actionBalance(View view){
        Intent intent = new Intent(this,BalanceEnquiry.class);
        startActivity(intent);
    }

    public void actionDeposit(View view){
        Intent intent = new Intent(this,CashDeposit.class);
        startActivity(intent);
    }

    public void actionWithdraw(View view){
        Intent intent = new Intent(this,CashWithdraw.class);
        startActivity(intent);
    }
}