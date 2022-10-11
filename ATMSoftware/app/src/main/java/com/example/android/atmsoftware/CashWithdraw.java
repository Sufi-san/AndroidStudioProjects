package com.example.android.atmsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CashWithdraw extends AppCompatActivity {
    public int withAmt = 0;
    EditText withEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_withdraw);

        withEdit = (EditText) findViewById(R.id.withdrawal_input);
    }

    public void instructWithdraw(View view){

        String withString = withEdit.getText().toString();
        withAmt = Integer.parseInt(withString);


        if(withAmt%100 == 0 && withAmt <= 10000) {
            Toast.makeText(this, "Successfully Withdrawn ₹ " + withAmt, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AtmActivity.class);
            startActivity(intent);
        }
        else if(withAmt%100 != 0){
            Toast.makeText(this,"Must be a multiple of 100",Toast.LENGTH_SHORT).show();
        }
        else if(withAmt > 10000){
            Toast.makeText(this,"Must not exceed ₹10000",Toast.LENGTH_SHORT).show();
        }
    }

    public void returnMain(View view){
        Intent intent = new Intent(this,AtmActivity.class);
        startActivity(intent);
    }
}