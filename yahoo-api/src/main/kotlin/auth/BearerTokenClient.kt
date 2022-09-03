package auth

import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addResourceSource
import config.YahooSecrets
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class BearerTokenClient : Authenticator {
    private val config = ConfigLoaderBuilder.default()
        .addResourceSource("/application.toml")
        .build()
        .loadConfigOrThrow<YahooSecrets>()

    private val yahooAuthApi by lazy { YahooAuthServiceImpl().createAuthClient() }

    override fun authenticate(route: Route?, response: Response): Request? {

        val tokenResponse =
            yahooAuthApi.getToken(
                config.clientId,
                config.clientSecret,
                "refresh_token",
                "oob",
                config.refreshToken
            ).execute()
        return response.request().newBuilder()
            .header("Authorization", "Bearer ${tokenResponse.body()?.accessToken}")
            .build()
    }
}
