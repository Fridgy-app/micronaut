package me.rasztabiga.fridgy.productcatalog.domain

import me.rasztabiga.fridgy.common.entity.BaseAggregateRoot
import org.hibernate.Hibernate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(name = "product", uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
data class Product(
    @Column(name = "name", nullable = false, unique = true)
    val name: String,

    @Column(name = "ean_code", nullable = true)
    val eanCode: String?
) : BaseAggregateRoot() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Product

        return id == other.id
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , eanCode = $eanCode )"
    }
}

