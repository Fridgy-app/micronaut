package me.rasztabiga.fridgy.productcatalog.domain

interface ProductService {

    fun getAll(): List<Product>

    fun createNew(name: String)
}
