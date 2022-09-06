package auth

import config.YahooConfig
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class BearerTokenClient : Authenticator {

    private val yahooAuthApi by lazy { YahooAuthServiceImpl().createAuthClient() }
    private val yahooConfig = YahooConfig.load()
    override fun authenticate(route: Route?, response: Response): Request? {
        val tokenResponse =
            yahooAuthApi.getToken(
                yahooConfig.yahoo.clientId,
                yahooConfig.yahoo.clientSecret,
                "refresh_token",
                "oob",
                yahooConfig.yahoo.refreshToken
            ).execute()
        return response.request().newBuilder()
            .header("Authorization", "Bearer ${tokenResponse.body()?.accessToken}")
            .build()
    }
}
