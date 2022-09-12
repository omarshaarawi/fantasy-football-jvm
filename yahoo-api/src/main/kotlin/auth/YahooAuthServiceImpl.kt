package auth

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import service.YahooConstants

class YahooAuthServiceImpl {
    private val client: OkHttpClient

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private val contentType = "application/json".toMediaType()

    private val json = Json {
        ignoreUnknownKeys = true; isLenient = true
    }

    @OptIn(ExperimentalSerializationApi::class)
    fun createAuthClient(): YahooAuthService {
        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(YahooConstants.GET_TOKEN_ENDPOINT)
            .build()
        return retrofit.create(YahooAuthService::class.java)
    }
}
