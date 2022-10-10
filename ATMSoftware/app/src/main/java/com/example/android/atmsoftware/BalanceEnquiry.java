package com.example.android.atmsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BalanceEnquiry extends AppCompatActivity {
    public int BalanceAmt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_enquiry);
        displayBalance();

    }

    public void returnMain(View view){
        Intent intent = new Intent(this,AtmActivity.class);
        startActivity(intent);
    }

    public void displayBalance(){
        TextView text = (TextView) findViewById(R.id.balance_text);
        text.setText("₹ "+BalanceAmt+"/-");
    }
}