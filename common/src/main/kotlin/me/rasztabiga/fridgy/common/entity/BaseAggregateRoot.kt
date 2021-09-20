package me.rasztabiga.fridgy.common.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.persistence.*

@MappedSuperclass
@Introspected
abstract class BaseAggregateRoot : BaseEntity() {

    @Enumerated(EnumType.STRING)
    @Column(name = "AGGREGATE_STATUS")
    @JsonIgnore
    var aggregateStatus: AggregateStatus = AggregateStatus.ACTIVE

    @Column(name = "LAST_CHANGE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    var lastChangeDate: Date? = null

    @Column(name = "LAST_CHANGE_AUTHOR_ID")
    @JsonIgnore
    var lastChangeAuthorId: Long? = null

    fun markAsRemoved() {
        aggregateStatus = AggregateStatus.ARCHIVE
    }

    fun markAsActive() {
        aggregateStatus = AggregateStatus.ACTIVE
    }

    @JsonIgnore
    fun isActive(): Boolean {
        return aggregateStatus === AggregateStatus.ACTIVE
    }

    @JsonIgnore
    fun isRemoved(): Boolean {
        return aggregateStatus === AggregateStatus.ARCHIVE
    }

    fun updateLastChange(lastChangeAuthorId: Long?) {
        this.lastChangeAuthorId = lastChangeAuthorId
        lastChangeDate = Date()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseAggregateRoot) return false
        if (!super.equals(other)) return false

        if (aggregateStatus != other.aggregateStatus) return false
        if (lastChangeDate != other.lastChangeDate) return false
        if (lastChangeAuthorId != other.lastChangeAuthorId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + aggregateStatus.hashCode()
        result = 31 * result + (lastChangeDate?.hashCode() ?: 0)
        result = 31 * result + (lastChangeAuthorId?.hashCode() ?: 0)
        return result
    }
}
