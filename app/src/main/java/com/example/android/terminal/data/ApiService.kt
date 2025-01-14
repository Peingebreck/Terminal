package com.example.android.terminal.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("aggs/ticker/AAPL/range/{timeFrame}/2024-01-06/2025-01-06?adjusted=true&sort=desc&limit=50000&apiKey=UgVVL2nBfqhbIsZXToq5KgpKqJJg9grZ")
    suspend fun loadBars(
        @Path("timeFrame") timeFrame: String
    ): Result
}