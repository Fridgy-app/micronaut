package me.rasztabiga.fridgy.productcatalog.webui

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Controller("/product")
@Secured(SecurityRule.IS_AUTHENTICATED)
class ProductCatalogController {

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        return "Hello World"
    }
}
