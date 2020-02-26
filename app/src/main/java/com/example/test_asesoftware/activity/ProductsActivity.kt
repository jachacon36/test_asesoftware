package com.example.test_asesoftware.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.test_asesoftware.R
import com.example.test_asesoftware.viewModel.ViewModelProducts

class ProductsActivity : AppCompatActivity() {

    private lateinit var viewModelProducts: ViewModelProducts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }

    private fun initViewModel(){
        viewModelProducts = ViewModelProvider(this).get(ViewModelProducts::class.java)
    }

    private fun createObservers(){
        viewModelProducts.products.observe(this, Observer {

        })
    }

}
