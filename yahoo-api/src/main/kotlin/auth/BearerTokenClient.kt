package auth

import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addResourceSource
import config.YahooConfig
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class BearerTokenClient : Authenticator {
    data class Config(val yahoo: YahooConfig)

    private val config = ConfigLoaderBuilder.default()
        .addResourceSource("/application.toml")
        .build()
        .loadConfigOrThrow<Config>()

    private val yahooAuthApi by lazy { YahooAuthServiceImpl().createAuthClient() }

    override fun authenticate(route: Route?, response: Response): Request? {

        val tokenResponse =
            yahooAuthApi.getToken(
                config.yahoo.clientId,
                config.yahoo.clientSecret,
                "refresh_token",
                "oob",
                config.yahoo.refreshToken
            ).execute()
        return response.request().newBuilder()
            .header("Authorization", "Bearer ${tokenResponse.body()?.accessToken}")
            .build()
    }
}
