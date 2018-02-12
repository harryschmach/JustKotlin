package com.example.harryschmach.justkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import java.text.NumberFormat
import java.util.logging.Logger.global

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
        val cost = qtyCoffees*price
        val priceMessage = "Total: $" + (cost).toString() + "\nThanks!"


        displayMessage(priceMessage)
    }

    fun increaseQuant(view: View) {
        qtyCoffees += 1

        display(qtyCoffees)
//        displayPrice(qtyCoffees * price)
    }
    fun decreaseQuant(view: View) {
        if (qtyCoffees > 0) {
            qtyCoffees -= 1

            display(qtyCoffees)
//            displayPrice(qtyCoffees * price)
        } else{
            display(qtyCoffees)
//            displayPrice(qtyCoffees)
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private fun display(number: Int) {
        val quantityTextView = findViewById<View>(R.id.quantity_text_view) as TextView
        val textToDisplay = number.toString()
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
}