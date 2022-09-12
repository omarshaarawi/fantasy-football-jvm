package service

import config.YahooConfig
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface YahooService {

    @GET("fantasy/v2/league/nfl.l.{id};out=scoreboard,standings,teams,transactions")
    fun getAllLeagueResources(@Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.{id}")
    fun getLeague(@Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.{id}/teams")
    fun getLeagueTeams(@Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.{id}/scoreboard")
    fun getScoreboards(@Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.{id}/standings")
    fun getStandings(@Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.{id}/transactions")
    fun getTransactions(@Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.{id}/teams/roster")
    fun getTeams(@Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.{id}/players/stats;type=week;week={week}")
    fun getTeamPlayerStats(@Path("week") week: Int, @Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("fantasy/v2/team/nfl.l.{id}.t.{team_id}/matchups")
    fun getTeamMatchup(@Path("team_id") teamId: Int, @Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("fantasy/v2/team/nfl.l.{id}.t.{team_id}/roster")
    fun getTeamRoster(@Path("team_id") teamId: Int, @Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("https://fantasysports.yahooapis.com/fantasy/v2/league/nfl.l.{id}/players;sort_type=week;position={pos};status={status}")
    fun getFilteredPlayers(
        @Path("pos") positions: Positions?,
        @Path("status") status: Status?,
        @Path("id") id: String = leagueId
    ): Call<ResponseBody>

    @GET("fantasy/v2/team/nfl.l.{id}.t.{team_id}/roster/players/stats")
    fun getTeamRosterStats(@Path("team_id") teamId: Int, @Path("id") id: String = leagueId): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.{id}/players;status=A;position=O;sort=PTS;sort_type=week;start={start}/stats;type=week;week={week}")
    fun getAvailablePlayers(
        @Path("week") week: Int,
        @Path("start") start: Int,
        @Path("id") id: String = leagueId
    ): Call<ResponseBody>

    companion object {
        val leagueId = YahooConfig.load().yahoo.leagueId
    }
}
