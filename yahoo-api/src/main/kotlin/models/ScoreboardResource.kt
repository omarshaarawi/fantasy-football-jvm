package models

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "scoreboard")
data class ScoreboardResource(
    @XmlElement(name = "week")
    val week: Int,

    @XmlElement(name = "matchups")
    @XmlElementWrapper(name = "matchups")
    val matchups: List<MatchupResource>
)
