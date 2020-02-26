package com.example.test_asesoftware.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_asesoftware.model.Product
import com.example.test_asesoftware.utils.*

class ViewModelProducts : ViewModel() {

    val products: MutableLiveData<ArrayList<Product>> = MutableLiveData()
    val loading: MutableLiveData<Int> = MutableLiveData()
    val button: MutableLiveData<Int> = MutableLiveData()
    private lateinit var productList: ArrayList<Product>

    fun getProducts(){
        loading.value = View.VISIBLE
        button.value = View.GONE
        productList = arrayListOf()
        for (i in 1..40){
            productList.add(createProductRandom(i))
        }
        products.value = productList
        loading.value = View.GONE
    }

    private fun createProductRandom(i: Int):Product{
        var product= String()
        var price= String()
        var description= String()

        when{
            i%2 ==0 && i<5->{
                product = LAVADORA
                price = LAVADORA_PRICE
                description = LAVADORA_DES
            }
            i%2 !=0 && i<5->{
                product = COCINA
                price = COCINA_PRICE
                description = COCINA_DES
            }

            i%2 ==0 && i<10 && i>5->{
                product = TV
                price = TV_PRICE
                description = TV_DES
            }

            i%2 !=0 && i<10 && i>5->{
                product = RADIO
                price = RADIO_PRICE
                description = RADIO_DES
            }

            i%2 ==0 && i<15 && i>10->{
                product = NEVERA
                price = NEVRA_PRICE
                description = NEVRA_PRICE
            }

            i%2 !=0 && i<15 && i>10->{
                product = LAVADORA
                price = LAVADORA_PRICE
                description = LAVADORA_DES
            }

            i%2 ==0 && i<20 && i>15->{
                product = NEVERA
                price = NEVRA_PRICE
                description = NEVRA_PRICE
            }

            i%2 !=0 && i<20 && i>15->{
                product = LAVADORA
                price = LAVADORA_PRICE
                description = LAVADORA_DES
            }

            i%2 ==0 && i<25 && i>20->{
                product = TV
                price = TV_PRICE
                description = TV_DES
            }

            i%2 !=0 && i<25 && i>20->{
                product = COCINA
                price = COCINA_PRICE
                description = COCINA_DES
            }

            else->{
                product = COCINA
                price = COCINA_PRICE
                description = COCINA_DES

            }
        }
        return Product(product, price,description,IMAGE_URL)
    }
}
