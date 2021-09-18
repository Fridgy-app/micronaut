package me.rasztabiga.fridgy.productcatalog

import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
            title = "product-catalog",
            version = "0.0.1"
    )
)
object Api {
}
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("me.rasztabiga.fridgy.productcatalog.*")
		.start()
}

