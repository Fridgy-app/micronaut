package me.rasztabiga.fridgy.productcatalog.domain

import javax.persistence.*

@Entity
@Table(name = "product", uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
// https://guides.micronaut.io/latest/micronaut-jpa-hibernate-gradle-java.html
data class Product : BaseAggregateRoot(
    @Column(name = "name", nullable = false, unique = true)
    val name: String,

    @Column(name = "ean_code", nullable = true)
    val eanCode: String?
)
