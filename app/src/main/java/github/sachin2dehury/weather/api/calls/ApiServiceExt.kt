package github.sachin2dehury.weather.api.calls

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun createApiService(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://api.openweathermap.org")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    return retrofit.create(ApiService::class.java)
}