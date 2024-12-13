package com.example.shopapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ProductListFragment : Fragment() {

    private val productList = listOf("Laptop", "Smartphone", "Headphones", "Smartwatch", "Tablet")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView: ListView = view.findViewById(R.id.productListView)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            productList
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val product = productList[position]

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ProductDetailFragment.newInstance(product))
                .addToBackStack(null)
                .commit()
        }
    }
}
