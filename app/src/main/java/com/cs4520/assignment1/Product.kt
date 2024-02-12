package com.cs4520.assignment1

/*
Data representation for a product
 */
data class Product(
    val name: String,
    val expiryDate: String?,
    val price: Int,
    val type: ProductType,
    val image: Int
)