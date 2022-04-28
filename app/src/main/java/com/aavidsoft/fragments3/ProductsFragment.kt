package com.aavidsoft.fragments3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aavidsoft.fragments3.databinding.ProductsFragmentBinding

class ProductsFragment : Fragment() {

    var products = ArrayList<Product>()
    lateinit var binding : ProductsFragmentBinding
    var productsAdapter = ProductsAdapter(products)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        addDummyProducts()

        binding = ProductsFragmentBinding.inflate(layoutInflater)

        binding.recyclerProducts.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerProducts.adapter = productsAdapter

        productsAdapter.onProductClickListener = MyOnProductClickListener()

        return binding.root
    }

    inner class MyOnProductClickListener : ProductsAdapter.OnProductClickListener {
        override fun onProductClick(product: Product, position: Int) {
            Toast.makeText(context, product.title, Toast.LENGTH_LONG).show()
        }
    }

    fun addDummyProducts() {
        products.add(Product(101, "Laptop", R.mipmap.ic_launcher))
        products.add(Product(102, "Projector", R.mipmap.ic_launcher))
        products.add(Product(103, "Air Conditioner", R.mipmap.ic_launcher))
        products.add(Product(104, "Refrigerator", R.mipmap.ic_launcher))
        products.add(Product(105, "Cooler", R.mipmap.ic_launcher))
    }
}