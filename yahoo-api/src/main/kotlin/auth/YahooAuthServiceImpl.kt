package auth

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import service.YahooConstants

class YahooAuthServiceImpl {
    private val contentType = MediaType.get("application/json")

    private val json = Json {
        ignoreUnknownKeys = true; isLenient = true
    }
    @OptIn(ExperimentalSerializationApi::class)
    fun createAuthClient(): YahooAuthService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(YahooConstants.GET_TOKEN_ENDPOINT)
            .build()
        return retrofit.create(YahooAuthService::class.java)
    }
}
