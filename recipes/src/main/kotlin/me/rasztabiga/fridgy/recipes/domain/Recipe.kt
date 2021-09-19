package me.rasztabiga.fridgy.recipes.domain

import me.rasztabiga.fridgy.common.entity.BaseAggregateRoot
import org.hibernate.Hibernate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "RECIPE")
data class Recipe(
    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "instructions_body", nullable = false)
    val instructionsBody: String,
) : BaseAggregateRoot() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Recipe

        return id == other.id
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , instructionsBody = $instructionsBody )"
    }

}

