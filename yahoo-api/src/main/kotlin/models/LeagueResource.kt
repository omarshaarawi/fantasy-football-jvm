package models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "league")
data class LeagueResource(
    @XmlElement(name = "name")
    var name: String,

    @XmlElement(name = "current_week")
    @JsonProperty("current_week")
    val currentWeek: Int,

    @XmlElement(name = "start_week")
    @JsonProperty("start_week")
    val startWeek: Int,

    @XmlElement(name = "end_week")
    @JsonProperty("end_week")
    val endWeek: Int,

    @XmlElement(name = "start_date")
    @JsonProperty("start_date")
    val startDate: String,

    @XmlElement(name = "end_date")
    @JsonProperty("end_date")
    val endDate: String,

    @XmlElement(name = "season")
    @JsonProperty("season")
    val season: String,

    @XmlElement(name = "scoreboard")
    val scoreboard: ScoreboardResource?,

    @XmlElement(name = "standings")
    val standings: StandingsResource?,

    @XmlElement(name = "transactions")
    @XmlElementWrapper(name = "transactions")
    val transactions: List<TransactionResource>?
) {
    data class StandingsResource(
        @XmlElement(name = "teams")
        @XmlElementWrapper(name = "teams")
        val teams: List<TeamsResource>
    )
}
