package service

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface YahooService {
    @GET("fantasy/v2/league/nfl.l.1251422")
    fun getLeague(): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.1251422/scoreboard")
    fun getScoreboards(): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.1251422/standings")
    fun getStandings(): Call<ResponseBody>

    @GET("fantasy/v2/league/nfl.l.1251422/transactions")
    fun getTransactions(): Call<ResponseBody>

    @GET("fantasy/v2/team/nfl.l.1251422.t.{team_id}/matchups")
    fun getTeamMatchup(@Path("team_id") id: Int): Call<ResponseBody>

    @GET("fantasy/v2/team/nfl.l.1251422.t.{team_id}/roster")
    fun getTeamRoster(@Path("team_id") id: Int): Call<ResponseBody>
}
