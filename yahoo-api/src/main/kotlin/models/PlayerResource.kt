package models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "player")
data class PlayerResource(
    @XmlElement(name = "player_key")
    @JsonProperty("player_key")
    val playerKey: String,

    @XmlElement(name = "player_id")
    @JsonProperty("player_id")
    val playerId: String,

    @XmlElement(name = "name")
    val name: PlayerName,

    // bye_weeks
    @XmlElement(name = "bye_weeks")
    @JsonProperty("bye_weeks")
    val byeWeeks: List<Int>?,

    // display_position
    @XmlElement(name = "display_position")
    @JsonProperty("display_position")
    val displayPosition: String?,

    // is_undroppable
    @XmlElement(name = "is_undroppable")
    @JsonProperty("is_undroppable")
    val isUndroppable: Int?,

    // primary_position
    @XmlElement(name = "primary_position")
    @JsonProperty("primary_position")
    val primaryPosition: String?,

    // eligible_positions
    @XmlElement(name = "eligible_positions")
    @JsonProperty("eligible_positions")
    val eligiblePositions: List<String>?,

    @XmlElement(name = "transaction_data")
    @JsonProperty("transaction_data")
    val transactionData: TransactionData?,

    @XmlElement(name = "status")
    val status: String?,

    @XmlElement(name = "injury_note")
    @JsonProperty("injury_note")
    val injuryNote: String?,

    // player_points
    @XmlElement(name = "player_points")
    @JsonProperty("player_points")
    val playerPoints: PlayerPoints?,

    // selected_position
    @XmlElement(name = "selected_position")
    @JsonProperty("selected_position")
    val selectedPosition: SelectedPosition?

) {

    data class SelectedPosition(
        @XmlElement(name = "position")
        val position: String?,
    )
    data class PlayerName(
        @XmlElement(name = "full")
        val full: String,
    )
    data class PlayerPoints(
        @XmlElement(name = "total")
        val total: Double?,
    )

    data class TransactionData(
        @XmlElement(name = "type")
        val type: String,
        @XmlElement(name = "source_type")
        @JsonProperty("source_type")
        val sourceType: String,
        @XmlElement(name = "destination_type")
        @JsonProperty("destination_type")
        val destinationType: String,

// destination_team_key
        @XmlElement(name = "destination_team_key")
        @JsonProperty("destination_team_key")
        val destinationTeamKey: String?,

        // destination_team_name
        @XmlElement(name = "destination_team_name")
        @JsonProperty("destination_team_name")
        val destinationTeamName: String?,

    )
}
