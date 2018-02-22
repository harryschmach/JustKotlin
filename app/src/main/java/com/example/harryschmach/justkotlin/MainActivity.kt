package com.example.harryschmach.justkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import java.text.NumberFormat

/**
 * This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    var qtyCoffees = 0
    val price = 5

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View) {
        val totalCost = calculatePrice(qtyCoffees, price)
        val priceMessage = createOrderSummary(totalCost)


        displayMessage(priceMessage)
    }

    fun increaseQuant(view: View) {
        qtyCoffees += 1

        displayQuantity(qtyCoffees)
//        displayPrice(qtyCoffees * price)
    }
    fun decreaseQuant(view: View) {
        if (qtyCoffees > 0) {
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
    private fun displayPrice(number: Int) {
        val priceTextView = findViewById<View>(R.id.price_text_view) as TextView
        priceTextView.text = NumberFormat.getCurrencyInstance().format(number)
    }

    /**
     * This method displays the given text on the screen.
     */
    private fun displayMessage(message: String) {
        val priceTextView = findViewById<View>(R.id.price_text_view) as TextView
        priceTextView.text = message
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price of the things given how many there are and how much they cost
     * @param quantity is number of things being ordered
     * @param unitcost is cost of the thing
     */
    private fun calculatePrice(quantity: Int, unitcost: Int): Int {
        return quantity * unitcost
    }

    private fun createOrderSummary(orderCost: Int): String {
        return "Name: " + "Kaptain Kunal\n" +
                "Quantity: " + qtyCoffees.toString() + "\n" +
                "Total: " + orderCost.toString() + "\n" +
                "Thank you!"
    }

    private fun calculatePrice1param(quantity: Int): Int {
        return quantity * 10

    }private fun calculatePrice0param(): Int {
        return 5*10
    }
}