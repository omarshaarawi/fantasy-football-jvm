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
    var players: List<PlayerResource>?

)
