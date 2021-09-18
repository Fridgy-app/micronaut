package me.rasztabiga.fridgy.productcatalog.domain

import com.sun.istack.NotNull
import javax.persistence.*

@Entity
@Table(name = "product") // TODO https://guides.micronaut.io/latest/micronaut-jpa-hibernate-gradle-java.html
data class Product(
    @Id
    @GeneratedValue
    val id: Long, // TODO move to BaseEntity or something like that - copy strapp

    @NotNull
    @Column(name = "name")
    val name: String,

    @Column(name = "ean_code")
    val eanCode: String
)
