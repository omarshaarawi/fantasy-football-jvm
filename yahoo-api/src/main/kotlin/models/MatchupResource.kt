package models

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "matchup")
data class MatchupResource(
    @XmlElement(name = "week")
    val week: Int,

    @XmlElement(name = "teams")
    @XmlElementWrapper(name = "teams")
    val teams: List<TeamsResource>,
)
