package com.example.test_asesoftware.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_asesoftware.model.Product

class ViewModelProducts : ViewModel() {

    val products: MutableLiveData<ArrayList<Product>> = MutableLiveData()
    private lateinit var productList: ArrayList<Product>

    fun getProducts(){
        productList = arrayListOf()
        for (i in 1..40){
            productList.add(Product("","",""))
        }
        products.value = productList
    }
}