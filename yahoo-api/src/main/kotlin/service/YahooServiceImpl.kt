package service

import auth.BearerTokenClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object YahooServiceImpl {

    private val authAuthenticator = BearerTokenClient()
    private val client: OkHttpClient = OkHttpClient.Builder()
        .authenticator(authAuthenticator)
        .build()

    fun createYahooService(): YahooService {
        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl(YahooConstants.FANTASY_BASE_URL)
            .build()
        return retrofit.create(YahooService::class.java)
    }
}
