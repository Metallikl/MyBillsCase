package com.luche.mybillscase.remote

import com.luche.mybillscase.model.network.EntryResponse
import retrofit2.http.GET

interface EntryApi {
    @GET("lancamentos")
   suspend fun getEntries() : List<EntryResponse>
}