package com.example.test_asesoftware.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test_asesoftware.R
import com.example.test_asesoftware.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product.view.*

class ProductsAdapter: RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    private lateinit var products: ArrayList<Product>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productName.text = products[position].product
        holder.productPrice.text = products[position].price
        //Picasso.get().load(products[position].imagen).into(holder.productImage)
        holder.productImage.setOnClickListener {

        }

    }

    fun createProducts(products: ArrayList<Product>){
        products.let {
            this.products = arrayListOf()
            this.products.addAll(products)
        }
        notifyDataSetChanged()
    }

    class ViewHolder internal constructor(itemView: View):RecyclerView.ViewHolder(itemView) {
        internal val productName: TextView = itemView.productName
        internal val productPrice: TextView = itemView.productPrice
        internal val productImage: ImageView = itemView.productImage

    }
}