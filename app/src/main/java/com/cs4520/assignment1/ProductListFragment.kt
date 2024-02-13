package com.cs4520.assignment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
This class extends Fragment, making it a component that can be added to an activity to encapsulate
 its own UI and behavior.
 */
class ProductListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_productlist, container, false)
    }

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
            val price = item[3] as Int
            val typeStr = item[1] as String
            val expiryDate = item[2] as? String // It's nullable and only for food products

            when (typeStr) {
                "Equipment" -> Product.Equipment(name, price, expiryDate)
                "Food" -> Product.Food(name, price, expiryDate)
                else -> throw IllegalArgumentException("Unknown product type: $typeStr")
            }
        }

    }

}
