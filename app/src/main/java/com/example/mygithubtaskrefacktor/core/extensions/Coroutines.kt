package com.example.mygithubtaskrefacktor.core.extensions

import kotlinx.coroutines.Job

fun Job?.isActive() = this != null && this.isActive