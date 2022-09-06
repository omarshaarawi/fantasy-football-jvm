package config

import com.sksamuel.hoplite.ConfigAlias
import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addResourceSource

data class YahooConfig(
    @ConfigAlias("client_id")
    val clientId: String,
    @ConfigAlias("client_secret")
    val clientSecret: String,
    @ConfigAlias("refresh_token")
    val refreshToken: String,
    @ConfigAlias("league_id")
    val leagueId: String

) {
    data class Config(val yahoo: YahooConfig)
    companion object {
        fun load(): Config {
            return ConfigLoaderBuilder.default()
                .addResourceSource("/application.toml")
                .build()
                .loadConfigOrThrow()
        }
    }
}
