
package com.example.android.menu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        TextView item1 = (TextView) findViewById(R.id.menu_item_1);
        String message1 = (String) item1.getText();
        TextView item2 = (TextView) findViewById(R.id.menu_item_2);
        String message2 = (String) item2.getText();
        TextView item3 = (TextView) findViewById(R.id.menu_item_3);
        String message3 = (String) item3.getText();
        // Find first menu item TextView and print the text to the logs
         Log.i("MainActivity",message1);
        // Find second menu item TextView and print the text to the logs
        Log.i("MainActivity",message2);
        // Find third menu item TextView and print the text to the logs
        Log.i("MainActivity",message3);
    }
}
