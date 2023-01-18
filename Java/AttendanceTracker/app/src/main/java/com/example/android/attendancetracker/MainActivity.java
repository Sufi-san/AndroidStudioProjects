package com.example.android.attendancetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer t1,t2,t3,t4,tot1,tot2,tot3,tot4,percentage;
    String st1,st2,st3,st4,stot1,stot2,stot3,stot4;
    EditText Txt1,Txt2,Txt3,Txt4,Tot1,Tot2,Tot3,Tot4;
    TextView DisplayMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Txt1 = findViewById(R.id.textbox_1);
        Txt2 = findViewById(R.id.textbox_2);
        Txt3 = findViewById(R.id.textbox_3);
        Txt4 = findViewById(R.id.textbox_4);
        Tot1 = findViewById(R.id.totalbox_1);
        Tot2 = findViewById(R.id.totalbox_2);
        Tot3 = findViewById(R.id.totalbox_3);
        Tot4 = findViewById(R.id.totalbox_4);
        DisplayMessage = findViewById(R.id.display_message);
    }

    public void process(View view){
        st1 = Txt1.getText().toString();
        st2 = Txt2.getText().toString();
        st3 = Txt3.getText().toString();
        st4 = Txt4.getText().toString();
        stot1 = Tot1.getText().toString();
        stot2 = Tot2.getText().toString();
        stot3 = Tot3.getText().toString();
        stot4 = Tot4.getText().toString();

        if(st1.matches("")||st2.matches("")||st3.matches("")||st4.matches("")||
        stot1.matches("")||stot2.matches("")||stot3.matches("")||stot4.matches("")){
            Toast.makeText(this,"Please fill Blank fields",Toast.LENGTH_SHORT).show();
        }
        else {
            t1 = Integer.parseInt(st1);
            t2 = Integer.parseInt(st2);
            t3 = Integer.parseInt(st3);
            t4 = Integer.parseInt(st4);
            tot1 = Integer.parseInt(stot1);
            tot2 = Integer.parseInt(stot2);
            tot3 = Integer.parseInt(stot3);
            tot4 = Integer.parseInt(stot4);
            if(t1 > tot1 || t2 > tot2 || t3 > tot3 || t4 > tot4) {
                Toast.makeText(this, "Please Enter Appropriate Values", Toast.LENGTH_SHORT).show();
            } else {
                percentage = (t1 + t2 + t3 + t4) * 100 / (tot1 + tot2 + tot3 + tot4);
                DisplayMessage.setText("Your attendance is " + percentage + "%.");
            }
        }
    }
}