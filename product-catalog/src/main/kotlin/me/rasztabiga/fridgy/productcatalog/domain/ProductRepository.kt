package me.rasztabiga.fridgy.productcatalog.domain

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ProductRepository : CrudRepository<Product, Long> {
}
