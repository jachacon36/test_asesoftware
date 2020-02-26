package com.example.test_asesoftware.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_asesoftware.R
import com.example.test_asesoftware.adapter.ProductsAdapter
import com.example.test_asesoftware.fragment.ProductDetail
import com.example.test_asesoftware.model.Product
import com.example.test_asesoftware.viewModel.ViewModelProducts
import kotlinx.android.synthetic.main.activity_main.*

class ProductsActivity : AppCompatActivity() {

    private lateinit var viewModelProducts: ViewModelProducts
    private val productsAdapter = ProductsAdapter(this)
    private val productDetail by lazy { ProductDetail.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        createObservers()
        createRecyclerView()
        createListeners()
    }

    private fun initViewModel(){
        viewModelProducts = ViewModelProvider(this).get(ViewModelProducts::class.java)
    }

    private fun createObservers(){
        viewModelProducts.products.observe(this, Observer {
            productsAdapter.createProducts(it)
        })

        viewModelProducts.loading.observe(this, Observer {
            loading(it)
        })

        viewModelProducts.button.observe(this, Observer {
            button(it)
        })
    }

    private fun getProducts(){
        viewModelProducts.getProducts()

    }

    private fun createRecyclerView(){
        productsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        productsRecyclerView.adapter = productsAdapter
    }

    private fun createListeners(){
        loadProducts.setOnClickListener {
            getProducts()
        }
    }

    private fun loading(visibility: Int){
        loading.visibility = visibility
    }

    private fun button(visibility: Int){
        loadProducts.visibility = visibility
    }

    fun createFragment(product: Product) {
        productDetail.createFragment(product.product,product.price,
            product.description,product.imagen,productDetail,supportFragmentManager,
            R.id.productContainer )
    }



}
