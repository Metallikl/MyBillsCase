package com.luche.mybillscase.util

import com.luche.mybillscase.R

class EntryCategoryToIcon {
    fun getEntryCategoryIcon(category: Int) : Int {
        return when(category){
            1 -> R.drawable.ic_baseline_directions_car_24
            else -> R.drawable.ic_baseline_shopping_cart_24
        }
    }

}