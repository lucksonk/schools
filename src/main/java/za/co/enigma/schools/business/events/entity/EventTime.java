package za.co.enigma.schools.business.events.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

@Entity
@Table(name="EVENT_TIME",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="EVENT_TIME_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = EventTime.findAll, query = "SELECT et FROM EventTime et")
public class EventTime extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -7846021246670825654L;
	private static final String PREFIX = "za.co.enigma.schools.business.events.entity.event.time.";
    public static final String findAll = PREFIX + "all";
}
