package me.rasztabiga.fridgy.common.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
abstract class VersionedIdentifiable<ID> : Identifiable<ID> {

    @Version
    @JsonIgnore
    var version: Long? = null

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
