package com.luche.mybillscase.model.domain

import java.io.Serializable
import java.math.BigDecimal

data class Entry(
    val id: Int,
    val value: BigDecimal,
    val origin: String,
    val category: Int,
    val entryMonth: Int
) : Serializable
