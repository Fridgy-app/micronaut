package me.rasztabiga.fridgy.productcatalog.webui

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import jakarta.inject.Inject
import me.rasztabiga.fridgy.productcatalog.domain.Product
import me.rasztabiga.fridgy.productcatalog.domain.ProductService

@Controller("/product")
@Secured(SecurityRule.IS_AUTHENTICATED)
class ProductCatalogController {

    @Inject
    lateinit var productService: ProductService

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun getProducts(): List<Product> {
        return productService.getAll()
    }

    @Post("/")
    @Consumes(MediaType.APPLICATION_JSON)
    fun postProduct(@Body productDto: ProductDto) {
        productService.createNew(productDto.name)
    }
}
