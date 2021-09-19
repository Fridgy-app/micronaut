package me.rasztabiga.fridgy.productcatalog.domain

import com.sun.istack.NotNull
import javax.persistence.*

@Entity
@Table(name = "PRODUCT_CATEGORY")
data class ProductCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long, // TODO move to BaseEntity or something like that - copy strapp

    @NotNull
    @Column(name = "NAME", nullable = false)
    val name: String
)
