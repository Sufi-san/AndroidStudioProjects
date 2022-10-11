package com.example.android.atmsoftware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BalanceEnquiry extends AppCompatActivity {
    public int BalanceAmt = 0,BalanceAmt1,BalanceAmt2;
    String Amt1,Amt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_enquiry);

        SharedPreferences shrBal = getSharedPreferences("Bal",MODE_PRIVATE);
        SharedPreferences.Editor editor = shrBal.edit();
        editor.putInt("intBal",BalanceAmt);
        editor.apply();

    }


    public void returnMain(View view){
        Intent intent = new Intent(this,AtmActivity.class);
        startActivity(intent);
    }



    public void showBalance(View view){

        int BalAmt;
        SharedPreferences getShared = getSharedPreferences("Bal",MODE_PRIVATE);
        BalAmt = getShared.getInt("intBal",0);

        BalanceAmt = BalAmt + BalanceAmt1 - BalanceAmt2;

        SharedPreferences shrBal = getSharedPreferences("Bal",MODE_PRIVATE);
        SharedPreferences.Editor editor = shrBal.edit();
        editor.putInt("intBal",BalanceAmt);
        editor.apply();

        TextView text = (TextView) findViewById(R.id.balance_text);
        text.setTextColor(getResources().getColor(R.color.yellow));
        text.setText("₹ "+BalanceAmt+"/-");
    }

}