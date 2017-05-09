package za.co.enigma.schools.business.events.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import za.co.enigma.domain.archetypes.PlaceDomainArchetype;

@Entity
@Table(name="EVENT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="EVENT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Location.findAll, query = "SELECT l FROM Location l")
public class Location extends PlaceDomainArchetype {

	private static final long serialVersionUID = 2868066812539038648L;
	private static final String PREFIX = "za.co.enigma.schools.business.events.entity.location.";
    public static final String findAll = PREFIX + "all";

}
