package me.rasztabiga.fridgy.recipes

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "Recipes Service",
        version = "0.0.1"
    )
)
object Api {
}

object RecipesService {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(RecipesService.javaClass)
    }
}

