package com.example.mygithubtaskrefacktor.core.extensions

import android.util.Log.e

inline fun <T> tryOrNull(from: String? = null, action: () -> T?): T? {
    return try {
        action.invoke()
    } catch (t: Throwable) {
        val s = if (from == null) "tryOrNull" else "tryOrNull from: $from"
        e(t) { s }.toString()
        null
    }
}

