package models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "team")
data class TeamResource(

    @XmlElement(name = "team_key")
    @JsonProperty("team_key")
    var teamKey: String,

    @XmlElement(name = "name")
    var name: String,

    @XmlElement(name = "matchups")
    @XmlElementWrapper(name = "matchups")
    val matchups: List<MatchupResource>?,

    // roster
    @XmlElement(name = "roster")
    var roster: RosterResource?
)
