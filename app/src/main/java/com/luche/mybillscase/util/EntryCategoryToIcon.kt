package com.luche.mybillscase.util

import com.luche.mybillscase.R

class EntryCategoryToIcon {
    fun getEntryCategoryIcon(category: Int) : Int {
        return when(category){
            1 -> R.drawable.ic_baseline_bus_alert_24//transporte
            2 -> R.drawable.ic_baseline_credit_card_24//Compras online
            3 -> R.drawable.ic_baseline_favorite_24//Saude e beleza
            4 -> R.drawable.ic_baseline_directions_car_24//Serviços automotivos
            5 -> R.drawable.ic_baseline_fastfood_24//Restaurantes
            else  -> R.drawable.ic_baseline_shopping_cart_24 //SuperMercado
        }
    }

}