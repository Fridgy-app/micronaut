package me.rasztabiga.fridgy.productcatalog.domain

import com.sun.istack.NotNull
import javax.persistence.*

@Entity
@Table(name = "product_unit")
// https://guides.micronaut.io/latest/micronaut-jpa-hibernate-gradle-java.html
data class ProductUnit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long, // TODO move to BaseEntity or something like that - copy strapp

    @NotNull
    @Column(name = "name", nullable = false)
    val name: String
)
