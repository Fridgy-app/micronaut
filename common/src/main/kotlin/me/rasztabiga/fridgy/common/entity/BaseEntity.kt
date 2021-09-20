package me.rasztabiga.fridgy.common.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.core.annotation.Introspected
import javax.persistence.*

@MappedSuperclass
@Introspected
abstract class BaseEntity {

    // TODO can we move id here?

    @Version
    @JsonIgnore
    val version: Long = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseEntity) return false

        if (version != other.version) return false

        return true
    }

    override fun hashCode(): Int {
        return version.hashCode()
    }
}
