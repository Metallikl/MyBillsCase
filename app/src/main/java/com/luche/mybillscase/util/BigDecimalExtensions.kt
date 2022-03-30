package com.luche.mybillscase.util

import java.math.BigDecimal
import java.text.NumberFormat

fun BigDecimal.toBrazilMoneyFormat() : String {
    return NumberFormat.getCurrencyInstance().format(this.toDouble()).toString()
}