package service

import FantasyContentResource
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import models.LeagueResource
import models.MatchupResource
import models.RosterResource
import models.ScoreboardResource
import models.TransactionResource
import mu.KLogger
import mu.KotlinLogging
import okhttp3.Headers
import okhttp3.ResponseBody
import retrofit2.Response

class YahooClient {

    private val log: KLogger = KotlinLogging.logger {}

    private val yahooApi by lazy { YahooServiceImpl.createYahooService() }
    private val mapper: ObjectMapper = XmlMapper
        .builder()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .addModules(kotlinModule()).build()

    fun getLeague(): LeagueResource? {
        val request = yahooApi.getLeague()
        return throwIfError(request.execute()).league
    }

    fun getScoreboard(): ScoreboardResource? {
        val request = yahooApi.getScoreboards()
        return throwIfError(request.execute()).league?.scoreboard
    }

    fun getTransactions(): List<TransactionResource>? {
        val request = yahooApi.getTransactions()
        return throwIfError(request.execute()).league?.transactions
    }

    fun getStandings(): LeagueResource.StandingsResource? {
        val request = yahooApi.getStandings()
        return throwIfError(request.execute()).league?.standings
    }

    fun getTeamMatchup(teamKey: Int): List<MatchupResource>? {
        val request = yahooApi.getTeamMatchup(teamKey)
        return throwIfError(request.execute()).league?.scoreboard?.matchups
    }

    fun getTeamRoster(teamKey: Int): RosterResource? {
        val request = yahooApi.getTeamRoster(teamKey)
        return throwIfError(request.execute()).team?.roster
    }

    private fun throwIfError(response: Response<ResponseBody>): FantasyContentResource {
        if (!response.isSuccessful) {
            log.error { "Error: ${response.errorBody()?.string()}" }
            throw RequestException(response.message(), response.code(), response.errorBody()!!, response.headers())
        }
        return leagueFrom(response.body()?.string())
    }

    private fun leagueFrom(xml: String?): FantasyContentResource {
        return mapper.readValue(xml, FantasyContentResource::class.java)
    }

    class RequestException(message: String, code: Int, errorBody: ResponseBody, headers: Headers) : Exception(message)
}
