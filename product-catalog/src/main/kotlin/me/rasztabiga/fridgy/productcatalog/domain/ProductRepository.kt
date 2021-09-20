package me.rasztabiga.fridgy.productcatalog.domain

import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.*
import io.micronaut.data.model.*
import io.micronaut.data.repository.CrudRepository

@Repository
interface ProductRepository : CrudRepository<Product, Long> {
}
