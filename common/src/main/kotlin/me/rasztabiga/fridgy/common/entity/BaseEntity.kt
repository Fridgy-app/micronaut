package me.rasztabiga.fridgy.common.entity

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity : VersionedIdentifiable<Long>() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected val id: Long = 0

    override fun getId(): Long {
        return id
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseEntity) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
