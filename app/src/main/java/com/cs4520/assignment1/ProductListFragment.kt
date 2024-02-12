package com.cs4520.assignment1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
This class extends Fragment, making it a component that can be added to an activity to encapsulate
 its own UI and behavior.
 */
class ProductListFragment : Fragment(R.layout.fragment_productlist) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Find recycler view by id
        val recyclerView: RecyclerView = view.findViewById(R.id.productRecyclerView)
        // Parse dataset
        val products = setUpProductModel(productsDataset) // Make sure productsDataset is accessible
        // Initialize layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // Initialize adapter with products
        val adapter = ProductAdapter(products)
        // Set the adapter to the RecyclerView
        recyclerView.adapter = adapter
    }

    private fun setUpProductModel(dataset: List<List<Any?>>): List<Product> {
        return dataset.map { item ->
            val name = item[0] as String
            val typeStr = item[1] as String
            val expiryDate = item[2] as? String // It's nullable
            val price =
                (item[3] as Int)

            val type = when (typeStr) {
                "Equipment" -> ProductType.Equipment
                "Food" -> ProductType.Food
                else -> throw IllegalArgumentException("Unknown product type: $typeStr")
            }
            val image = when (type) {
                ProductType.Equipment -> R.drawable.equipment
                ProductType.Food -> R.drawable.food
            }


            Product(name, expiryDate, price, type, image)
        }

    }

}
