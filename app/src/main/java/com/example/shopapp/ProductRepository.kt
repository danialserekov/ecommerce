package com.example.shopapp.repository

import com.example.shopapp.database.ProductDao
import com.example.shopapp.database.ProductEntity

class ProductRepository(private val productDao: ProductDao) {

    suspend fun insertProduct(product: ProductEntity) {
        productDao.insertProduct(product)
    }

    suspend fun getAllProducts(): List<ProductEntity> {
        return productDao.getAllProducts()
    }
}
