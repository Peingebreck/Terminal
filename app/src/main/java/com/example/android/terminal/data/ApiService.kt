package com.example.android.terminal.data

import retrofit2.http.GET

interface ApiService {

    @GET("aggs/ticker/AAPL/range/1/hour/2024-01-06/2025-01-06?adjusted=true&sort=asc&limit=50000&apiKey=UgVVL2nBfqhbIsZXToq5KgpKqJJg9grZ")
    suspend fun loadBars(): Result
}