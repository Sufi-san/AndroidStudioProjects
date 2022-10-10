
package com.example.android.justjava;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
int numberOfCoffees = 0, rate = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Code for checking WhippedCream Checkbox.
        CheckBox checkWhippedCream = (CheckBox) findViewById(R.id.check_whipped_cream);
        Boolean hasWhippedCream = checkWhippedCream.isChecked();

        //Code for checking Chocolate Checkbox.
        CheckBox checkChocolate = (CheckBox) findViewById(R.id.check_chocolate);
        Boolean hasChocolate = checkChocolate.isChecked();

        //For obtaining text entered by user in "name_text" EditText
        EditText nameText = (EditText) findViewById(R.id.name_text);
        String name = nameText.getText().toString();

        //Declaring variables,Assigning value to variables and calling functions.
        String price = calculatePrice(hasWhippedCream, hasChocolate);
        String val = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        if(numberOfCoffees == 0) {
            Toast.makeText(this,"Cannot order 0 coffees",Toast.LENGTH_SHORT).show();
            return;
        } else
        displayPriceMessage(val);
    }

    /**
     * This method increments numberOfCoffees by 1
     */
    public void increment(View view) {
        numberOfCoffees = numberOfCoffees + 1;
        if(numberOfCoffees > 100) {
            numberOfCoffees = numberOfCoffees - 1;
             Toast.makeText(this,"Quantity cannot exceed 100",Toast.LENGTH_SHORT).show();
            return;
        } else {
            displayQuantity(numberOfCoffees);
            displayPrice(numberOfCoffees * rate);
        }
    }

    /**
     * This method decrements numberOfCoffees by 1
     */
    public void decrement(View view) {
        numberOfCoffees = numberOfCoffees - 1;
        if (numberOfCoffees < 0){
            numberOfCoffees = numberOfCoffees + 1;
            Toast.makeText(this,"Quantity cannot be less than 0",Toast.LENGTH_SHORT).show();
        return;
        } else {
            displayQuantity(numberOfCoffees);
            displayPrice(numberOfCoffees * rate);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayPriceMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the initial price of cups of coffee.
     */
    private void displayPrice(int amt){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText("₹"+amt+" (without toppings)");
    }

    /**
     * This method displays a summary for the complete order of coffees.
     * @param price total cost of the order
     * @param hasWhippedCream truth value for the checkBox.
     *  @param hasChocolate truth value for the checkBox.
     * @return
     */
    private String createOrderSummary(String name,String price,Boolean hasWhippedCream,Boolean hasChocolate)
    {
       String summary = "Name: "+name+"\nAdd Whipped Cream? "+hasWhippedCream;
       summary += "\nAdd Chocolate? "+hasChocolate;
       summary += "\nQuantity: "+numberOfCoffees+"\nTotal: ₹"+price+"\nThank You!";
       return summary;
    }

    /**
     * This method calculates the total price for the order
     * @param whippedCream truth value for whippedCream checkbox
     * @param Chocolate truth value for chocolate checkbox
     * @return total price for the order is returned
     */
    private String calculatePrice(Boolean whippedCream, Boolean Chocolate){
        int price;
        String message = " (toppings included)";
        if(whippedCream && Chocolate) {
            price = (numberOfCoffees) * (rate + 10 + 15);
            message = price + message;
        }
        else if(whippedCream && !Chocolate){
            price = (numberOfCoffees) * (rate + 10);
            message = price + message;
        }
        else if(!whippedCream && Chocolate){
            price = (numberOfCoffees) * (rate + 15);
            message = price + message;
        }
        else{
            price = numberOfCoffees * rate;
            message = price + " (no toppings)";
        }
        return message;
    }

/**
 * NumberFormat.getCurrencyInstance().format(number)
 */
}