package service

import auth.BearerTokenClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object YahooServiceImpl {

    private val client: OkHttpClient
    private val authAuthenticator = BearerTokenClient()

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        client = OkHttpClient.Builder()
            .authenticator(authAuthenticator)
            .addInterceptor(logging)
            .build()
    }

    fun createYahooService(): YahooService {
        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl(YahooConstants.FANTASY_BASE_URL)
            .build()
        return retrofit.create(YahooService::class.java)
    }
}
