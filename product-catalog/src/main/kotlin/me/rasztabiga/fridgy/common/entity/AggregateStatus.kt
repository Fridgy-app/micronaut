package me.rasztabiga.fridgy.common.entity

import io.micronaut.core.annotation.Introspected


@Introspected
enum class AggregateStatus {
    ACTIVE, ARCHIVE
}
