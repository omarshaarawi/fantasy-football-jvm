package models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "teams")
data class TeamsResource(

    @XmlElement(name = "team_key")
    @JsonProperty("team_key")
    var teamKey: String,

    @XmlElement(name = "team_id")
    @JsonProperty("team_id")
    var teamId: Int,

    @XmlElement(name = "name")
    val name: String,

    @XmlElement(name = "waiver_priority")
    @JsonProperty("waiver_priority")
    val waiverPriority: Int,

    @XmlElement(name = "number_of_moves")
    @JsonProperty("number_of_moves")
    val numberOfMoves: Int,

    @XmlElement(name = "number_of_trades")
    @JsonProperty("number_of_trades")
    val numberOfTrades: Int,

    @XmlElement(name = "draft_grade")
    @JsonProperty("draft_grade")
    val draftGrade: String,

    @XmlElement(name = "win_probability")
    @JsonProperty("win_probability")
    val winProbability: Double,

    @XmlElement(name = "team_points")
    @JsonProperty("team_points")
    val teamPoints: TeamPointsResource?,

    @XmlElement(name = "team_projected_points")
    @JsonProperty("team_projected_points")
    val teamProjectedPoints: TeamPointsResource?,

    // team_standings
    @XmlElement(name = "team_standings")
    @JsonProperty("team_standings")
    val teamStandings: TeamStandingsResource?,

    @XmlElement(name = "roster")
    var roster: RosterResource?
) {

    @XmlRootElement(name = "team_points")
    data class TeamPointsResource(
        @XmlElement(name = "total")
        var total: Double,

        @XmlElement(name = "coverage_type")
        @JsonProperty("coverage_type")
        var coverageType: String

    )

    @XmlRootElement(name = "team_standings")
    data class TeamStandingsResource(

        @XmlElement(name = "rank")
        var rank: Int,

        @XmlElement(name = "outcome_totals")
        @JsonProperty("outcome_totals")
        var outcomeTotals: OutcomeTotalsResource,

    ) {
        data class OutcomeTotalsResource(
            @XmlElement(name = "wins")
            var wins: Int,

            @XmlElement(name = "losses")
            var losses: Int,

            @XmlElement(name = "ties")
            var ties: Int,

            @XmlElement(name = "percentage")
            var percentage: Double,
        )
    }
}
