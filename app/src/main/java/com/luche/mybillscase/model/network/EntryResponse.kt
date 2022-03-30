package com.luche.mybillscase.model.network

import com.luche.mybillscase.model.domain.Entry
import com.luche.mybillscase.util.toBrazilMoneyFormat
import java.math.BigDecimal

data class EntryResponse(
    val id: Int,
    val valor: BigDecimal,
    val origem: String,
    val categoria: Int,
    val mes_lancamento: Int,
)


fun EntryResponse.toDomainEntry() = Entry(
    id = id,
    value = valor,
    origin = origem,
    category = categoria,
    entryMonth = mes_lancamento
)