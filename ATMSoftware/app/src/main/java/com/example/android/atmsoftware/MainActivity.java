package com.example.android.atmsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int MainPIN = 1234, EnterPIN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void action1(View view){
        EditText enterPinEdit = (EditText) findViewById(R.id.enter_pin);
        String enterPinString =  enterPinEdit.getText().toString();
        if(enterPinString.matches("")){
            Toast.makeText(this,"Please Enter PIN",Toast.LENGTH_SHORT).show();
        } else {
            EnterPIN = Integer.parseInt(enterPinString);
            if (EnterPIN == MainPIN) {
                Intent i = new Intent(this, AtmActivity.class);
                startActivity(i);
            } else {
                TextView message = (TextView) findViewById(R.id.display_text);
                message.setTextColor(getResources().getColor(R.color.red));
                message.setText("Invalid PIN");
            }
        }
    }
}