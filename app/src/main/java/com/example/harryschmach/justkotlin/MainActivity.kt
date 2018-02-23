package com.example.harryschmach.justkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

/**
 * This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    var qtyCoffees = 1
    val price = 5
    val isWhippedCream = findViewById<View>(R.id.whipped_cream_check) as CheckBox
    val isChocolate = findViewById<View>(R.id.chocolate_check) as CheckBox
    val nameOfPerson = findViewById<View>(R.id.name_text_field) as EditText


    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View) {
        val whippedCream = isWhippedCream.isChecked
        val chocoTime = isChocolate.isChecked
        val totalCost = calculatePrice(qtyCoffees, price, whippedCream, chocoTime)

        val nameIntoOrder = nameOfPerson.text.toString()
        val priceMessage = createOrderSummary(totalCost, whippedCream, chocoTime, nameIntoOrder)


        displayMessage(priceMessage)
    }

    fun increaseQuant(view: View) {
        if (qtyCoffees < 100) {
            qtyCoffees += 1

            displayQuantity(qtyCoffees)
//            displayPrice(qtyCoffees * price)
        } else{
            displayQuantity(qtyCoffees)
//            displayPrice(qtyCoffees)
        }
    }

    fun decreaseQuant(view: View) {
        if (qtyCoffees > 1) {
            qtyCoffees -= 1

            displayQuantity(qtyCoffees)
//            displayPrice(qtyCoffees * price)
        } else{
            displayQuantity(qtyCoffees)
//            displayPrice(qtyCoffees)
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private fun displayQuantity(numberRename: Int) {
        val quantityTextView = findViewById<View>(R.id.quantity_text_view) as TextView
        val textToDisplay = numberRename.toString()
        quantityTextView.text = textToDisplay
    }

    /**
     * This method displays the given price on the screen.
     */
//    private fun displayPrice(number: Int) {
//        val priceTextView = findViewById<View>(R.id.price_text_view) as TextView
//        priceTextView.text = NumberFormat.getCurrencyInstance().format(number)
//    }

    /**
     * This method displays the given text on the screen.
     */
    private fun displayMessage(message: String) {
        val orderSummaryTextView = findViewById<View>(R.id.order_summary_text_view) as TextView
        orderSummaryTextView.text = message
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price of the things given how many there are and how much they cost
     * @param quantity is number of things being ordered
     * @param coffeeunitcost is cost of the thing
     */
    private fun calculatePrice(quantity: Int, coffeeunitcost: Int, wc: Boolean, choco: Boolean): Int {
        var chocoCost = 0
        var wcCost = 0
        if (wc){
            wcCost = 1
        }
        if (choco){
            chocoCost = 2
        }


        return quantity * (coffeeunitcost + wcCost + chocoCost)
    }

    private fun createOrderSummary(orderCost: Int,
                                   whippedCream: Boolean,
                                   chocoChecked:Boolean,
                                   nameUsed: String): String {

        return "Name: " + nameUsed + "\n" +
                "Added Whipped Cream? " + whippedCream.toString() + "\n" +
                "Added Chocolate? " + chocoChecked.toString() + "\n" +
                "Quantity: " + qtyCoffees.toString() + "\n" +
                "Total: $" + orderCost.toString() + "\n" +
                "Thank you!"
    }

    private fun calculatePrice1param(quantity: Int): Int {
        return quantity * 10

    }private fun calculatePrice0param(): Int {
        return 5*10
    }
}