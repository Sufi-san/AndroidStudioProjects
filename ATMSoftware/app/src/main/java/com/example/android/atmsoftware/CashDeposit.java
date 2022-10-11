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

public class CashDeposit extends AppCompatActivity {
    public int depAmt = 0;
    EditText depEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_deposit);

        depEdit = (EditText) findViewById(R.id.deposit_input);
    }

    public void instructDeposit(View view){
        String depString = depEdit.getText().toString();
        depAmt = Integer.parseInt(depString);


        if(depAmt%100 == 0 && depAmt <= 10000) {
            Toast.makeText(this, "Successfully Deposited ₹ " + depAmt, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AtmActivity.class);
            startActivity(intent);
        }
        else if(depAmt%100 != 0){
            Toast.makeText(this,"Must be a multiple of 100",Toast.LENGTH_SHORT).show();
        }
        else if(depAmt > 10000){
            Toast.makeText(this,"Must not exceed ₹10000",Toast.LENGTH_SHORT).show();
        }
    }

    public void returnMain(View view){

        Intent intent = new Intent(this,AtmActivity.class);
        startActivity(intent);
    }
}