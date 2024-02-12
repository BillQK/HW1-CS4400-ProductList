package com.cs4520.assignment1

/*
A sealed class for ProductTyp
 */
sealed class ProductType(val backgroundColor: String, val imageResource: Int) {
    object Equipment : ProductType("#E06666", R.drawable.equipment)
    object Food : ProductType("#FFD965", R.drawable.food)
}
