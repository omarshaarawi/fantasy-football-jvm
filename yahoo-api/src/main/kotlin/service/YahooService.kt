package service

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface YahooService {

    @GET("fantasy/v2/league/nfl.l.1251422;out=scoreboard,standings,teams,transactions")
    fun getAllLeagueResources(): Call<ResponseBody>

    // LEAGUE
    @GET("fantasy/v2/league/nfl.l.1251422")
    fun getLeague(): Call<ResponseBody>


    @GET("fantasy/v2/league/nfl.l.1251422/teams")
    fun getLeagueTeams(): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.1251422/scoreboard")
    fun getScoreboards(): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.1251422/standings")
    fun getStandings(): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.1251422/transactions")
    fun getTransactions(): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.1251422/teams/roster")
    fun getTeams(): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.1251422/players/stats;type=week;week={week}")
    fun getTeamPlayerStats(@Path("week") week: Int): Call<ResponseBody>

    // Team
    @GET("fantasy/v2/team/nfl.l.1251422.t.{team_id}/matchups")
    fun getTeamMatchup(@Path("team_id") id: Int): Call<ResponseBody>

    @GET("fantasy/v2/team/nfl.l.1251422.t.{team_id}/roster")
    fun getTeamRoster(@Path("team_id") id: Int): Call<ResponseBody>

    @GET("https://fantasysports.yahooapis.com/fantasy/v2/league/nfl.l.1251422/players;sort_type=week;position={pos};status={status}")
    fun getFilteredPlayers(@Path("pos") positions: Positions?, @Path("status") status: Status?): Call<ResponseBody>

    @GET("fantasy/v2/team/nfl.l.1251422.t.{team_id}/roster/players/stats")
    fun getTeamRosterStats(@Path("team_id") id: Int): Call<ResponseBody>
}
