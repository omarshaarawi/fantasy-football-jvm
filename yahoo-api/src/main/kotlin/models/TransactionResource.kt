package models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "transaction")
data class TransactionResource(
    @XmlElement(name = "transaction_key")
    @JsonProperty("transaction_key")
    var transactionKey: String,

    // transaction_id
    @XmlElement(name = "transaction_id")
    @JsonProperty("transaction_id")
    var transactionId: String,

    // type
    @XmlElement(name = "type")
    var type: String,

    // timestamp
    @XmlElement(name = "timestamp")
    var timestamp: Long,

    // Players
    @XmlElement(name = "players")
    @XmlElementWrapper(name = "players")
    var players: List<PlayerResource>?,

    // transaction_data
    @XmlElement(name = "transaction_data")
    @JsonProperty("transaction_data")
    var transactionData: TransactionDataResource?
) {
    data class TransactionDataResource(
        @XmlElement(name = "type")
        var type: String,

        @XmlElement(name = "source_type")
        @JsonProperty("source_type")
        var sourceType: String,

        @XmlElement(name = "destination_type")
        @JsonProperty("destination_type")
        var destinationType: String,

        @XmlElement(name = "destination_team_name")
        @JsonProperty("destination_team_name")
        var destinationTeamName: String

    )
}
