package com.cs4520.assignment1

/*
Data representation for a product
 */
sealed class Product(val name: String, val price: Int,val expiryDate: String?) {
    abstract val backgroundColor: String
    abstract val imageResource: Int

    class Food(name: String, price: Int, expiryDate: String?) : Product(name, price, expiryDate) {
        override val backgroundColor = "#FFD965" // Light Yellow
        override val imageResource = R.drawable.food
    }

    class Equipment(name: String, price: Int, expiryDate: String?) : Product(name, price, expiryDate) {
        override val backgroundColor = "#E06666" // Light Red
        override val imageResource = R.drawable.equipment
    }
}
