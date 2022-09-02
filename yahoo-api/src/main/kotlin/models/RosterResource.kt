package models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper

data class RosterResource(
    // coverage_type
    @XmlElement(name = "coverage_type")
    @JsonProperty("coverage_type")
    val coverageType: String,

    // week
    @XmlElement(name = "week")
    val week: Int,

    // is_editable
    @XmlElement(name = "is_editable")
    val isEditable: Int,

    // players
    @XmlElement(name = "players")
    @XmlElementWrapper(name = "players")
    val players: List<PlayerResource>
)
