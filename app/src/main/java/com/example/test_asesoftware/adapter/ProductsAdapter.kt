package com.example.test_asesoftware.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test_asesoftware.R
import com.example.test_asesoftware.activity.ProductsActivity
import com.example.test_asesoftware.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product.view.*

class ProductsAdapter(private val productsActivity: ProductsActivity) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    private var products: ArrayList<Product> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.count.text = (position+1).toString()
        holder.productName.text = products[position].product
        holder.productPrice.text = productsActivity.getString(R.string.price,products[position].price)
        Picasso.get().load(products[position].imagen)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground).into(holder.productImage)
        holder.productImage.setOnClickListener {

        }
        holder.productContainer.setOnClickListener {
            productsActivity.createFragment(products[position])
        }

    }

    fun createProducts(products: ArrayList<Product>){
        products.let {
            this.products.addAll(products)
        }
        notifyDataSetChanged()
    }

    class ViewHolder internal constructor(itemView: View):RecyclerView.ViewHolder(itemView) {
        internal val productName: TextView = itemView.productName
        internal val productPrice: TextView = itemView.productPrice
        internal val productImage: ImageView = itemView.productImage
        internal val count: TextView = itemView.count
        internal val productContainer: LinearLayout = itemView.productContainer

    }
}