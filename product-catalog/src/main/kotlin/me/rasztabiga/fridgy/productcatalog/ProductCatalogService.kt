package me.rasztabiga.fridgy.productcatalog

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "Product Catalog Service",
        version = "0.0.1"
    )
)
object Api {
}

object ProductCatalogService {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(ProductCatalogService.javaClass)
    }
}

