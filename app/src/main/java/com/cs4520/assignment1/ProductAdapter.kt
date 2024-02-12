package com.cs4520.assignment1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView


/*
It's a custom adapter that extends the generic RecyclerView.Adapter class,
specifying ProductAdapter.ProductViewHolder as its ViewHolder type.
 */
class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    /*
    This method is called by the RecyclerView to create new ViewHolder instances.
     It inflates the product_recycler_view_row layout, which defines the appearance of each
      item in the list, and returns a new instance of ProductViewHolder with the inflated View.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_recycler_view_row, parent, false)
        return ProductViewHolder(view)
    }

    /*
    This method binds data from the productList to the views in the ViewHolder.
    For each product item at the specified position,
    it calls bind() on the corresponding ProductViewHolder.
     */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])

    }

    override fun getItemCount() = productList.size

    /*
    Represents a single item view and its metadata within the RecyclerView,
    allowing for item reuse and reducing the need for inflating new views.
     */
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*
        Binds data from a Product object to the views within the ViewHolder's layout.
        It sets the product name, price, expiry date (if available), background color,
        and image based on the product's attributes.
         */
        fun bind(product: Product) {
            val productName = itemView.findViewById<TextView>(R.id.productName)
            val productPrice = itemView.findViewById<TextView>(R.id.productPrice)
            val productExpiryDate = itemView.findViewById<TextView>(R.id.productExpiryDate)
            val productCardBackGroundColor = itemView.findViewById<CardView>(R.id.productCardView)
            val constraintLayout: ConstraintLayout =
                itemView.findViewById(R.id.constraintLayout) // Reference to inner ConstraintLayout

            productName?.text = product.name // Use ?. to safely call setText on a nullable receiver
            productPrice?.text =
                itemView.context.getString(R.string.product_price_format, product.price)

            if (product.expiryDate == null) {
                productExpiryDate.visibility = View.GONE

                ConstraintSet().apply {
                    clone(constraintLayout)
                    connect(
                        R.id.productPrice,
                        ConstraintSet.TOP,
                        R.id.productName,
                        ConstraintSet.BOTTOM,
                        8
                    )
                    applyTo(constraintLayout)
                }
            } else {
                productExpiryDate.visibility = View.VISIBLE
                productExpiryDate.text = product.expiryDate

                // Reset constraints
                ConstraintSet().apply {
                    clone(constraintLayout)
                    connect(
                        R.id.productExpiryDate,
                        ConstraintSet.TOP,
                        R.id.productName,
                        ConstraintSet.BOTTOM,
                        8
                    )
                    connect(
                        R.id.productPrice,
                        ConstraintSet.TOP,
                        R.id.productExpiryDate,
                        ConstraintSet.BOTTOM,
                        8
                    )
                    applyTo(constraintLayout)
                }
            }

            // Set the background color based on the product type
            productCardBackGroundColor.setCardBackgroundColor(
                Color.parseColor(product.type.backgroundColor)
            )

            // Set the image resource based on the product type
            val imageView = itemView.findViewById<ImageView>(R.id.productImage)
            imageView.setImageResource(product.type.imageResource)
        }
    }

}