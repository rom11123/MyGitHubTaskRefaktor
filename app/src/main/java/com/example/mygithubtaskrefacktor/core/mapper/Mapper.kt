package com.example.mygithubtaskrefacktor.core.mapper

interface Mapper<in SOURCE, out RESULT> {
    fun map(s: SOURCE): RESULT

    fun map(s: List<SOURCE>): List<RESULT> =
        s.map { map(it) }

    fun mapIfNotNull(s: SOURCE?): RESULT? =
        s?.run { map(this) }

    fun mapIfNotNull(s: List<SOURCE>?): List<RESULT>? =
        s?.run { map(this) }
}