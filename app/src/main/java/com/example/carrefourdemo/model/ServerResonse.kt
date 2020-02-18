package com.example.carrefourdemo.model

data class ServerResonse<T>(
    val success: Boolean,
    val data: T?,
    val exception: Exception?,
    val time: Long
)