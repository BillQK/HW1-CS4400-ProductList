package com.cs4520.assignment1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
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
            .inflate(R.layout.item_product_view, parent, false)
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

        private val productName: TextView = itemView.findViewById(R.id.productName)
        private val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        private val productExpiryDate: TextView? = itemView.findViewById(R.id.productExpiryDate)
        private val productCardBackGroundColor: CardView =
            itemView.findViewById(R.id.productCardView)
        private val productImage: ImageView = itemView.findViewById(R.id.productImage)

        fun bind(product: Product) {
            productName.text = product.name
            productPrice.text =
                itemView.context.getString(R.string.product_price_format, product.price)

            // Handling for optional expiry date in Food products
            when (product) {
                is Product.Equipment -> {
                    productExpiryDate?.apply {
                        visibility = View.GONE
                    }
                }

                is Product.Food -> {
                    productExpiryDate?.apply {
                        visibility = View.VISIBLE
                        text = product.expiryDate
                    }
                }
            }

            // Set background color and image
            productCardBackGroundColor.setCardBackgroundColor(Color.parseColor(product.backgroundColor))
            productImage.setImageResource(product.imageResource)
        }
    }


}