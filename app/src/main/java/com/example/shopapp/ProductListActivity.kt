package com.example.shopapp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ProductListActivity : AppCompatActivity() {

    private lateinit var productListView: ListView
    private val productList = listOf("Laptop", "Smartphone", "Headphones", "Smartwatch", "Tablet")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        Log.d("Lifecycle", "onCreate called")

        productListView = findViewById(R.id.productListView)
        setupProductList()
    }

    private fun setupProductList() {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            productList
        )
        productListView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart called")
    }
}
