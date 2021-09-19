package me.rasztabiga.fridgy.common.entity

import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
abstract class VersionedIdentifiable<ID> : Identifiable<ID> {

    @Version
    protected val version: Long = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is VersionedIdentifiable<*>) return false

        if (version != other.version) return false

        return true
    }

    override fun hashCode(): Int {
        return version.hashCode()
    }
}
