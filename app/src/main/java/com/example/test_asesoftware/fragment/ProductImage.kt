package com.example.test_asesoftware.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager

import com.example.test_asesoftware.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_product_detail.*

class ProductImage : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = ProductImage()
        const val IMG_URL = "img"
    }

    private var imageURL: String? = String()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_img, container, false)
    }


    fun createFragment(img:String, fragment:Fragment, supportFragmentManager: FragmentManager, containerView: Int) : Int? {
        createBundle(bundleOf(
            IMG_URL to img
        ))

        return supportFragmentManager.beginTransaction()
            .replace(containerView, fragment)
            .addToBackStack(null)
            .commitAllowingStateLoss()

    }

    private fun createBundle(bundle: Bundle) {
        imageURL = bundle.getString(IMG_URL)
    }

    private fun initView(){
        Picasso.get().load(imageURL)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground).into(productImage)


    }
}
