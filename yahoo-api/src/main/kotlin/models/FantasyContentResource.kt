import models.LeagueResource
import models.TeamResource
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "fantasy_content")
@XmlAccessorType(XmlAccessType.FIELD)
data class FantasyContentResource(
    @XmlElement(name = "league")
    val league: LeagueResource?,

    @XmlElement(name = "team")
    val team: TeamResource?

)
