package me.rasztabiga.fridgy.productcatalog.domain

import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ProductServiceImpl : ProductService {

    @Inject
    lateinit var productRepository: ProductRepository

    override fun getAll(): List<Product> {
        return productRepository.findAll().toList()
    }

    override fun createNew(name: String) {
        val product = Product(name = name, eanCode = null)

        productRepository.save(product)
    }
}
