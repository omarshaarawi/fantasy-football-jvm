package config

import com.sksamuel.hoplite.ConfigAlias

data class YahooSecrets(
    @ConfigAlias("client_id")
    val clientId: String,
    @ConfigAlias("client_secret")
    val clientSecret: String,
    @ConfigAlias("refresh_token")
    val refreshToken: String
)
