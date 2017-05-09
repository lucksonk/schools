package za.co.enigma.schools.business.events.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;
import za.co.enigma.domain.party.Party;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="EVENT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="EVENT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Event.findAll, query = "SELECT e FROM Event e")
public class Event extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -6432478351353787266L;
	private static final String PREFIX = "za.co.enigma.schools.business.events.entity.";
    public static final String findAll = PREFIX + "all";

    private String name;
    private Map<Location,EventTime> locationAndTime = new HashMap<>();
    private List<Party> subscribers = new ArrayList<>();
    private EventType eventType;
    
    @Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public Map<Location, EventTime> getLocationAndTime() {
		return locationAndTime;
	}
	public void setLocationAndTime(Map<Location, EventTime> locationAndTime) {
		this.locationAndTime = locationAndTime;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<Party> getSubscribers() {
		return subscribers;
	}
	public void setSubscribers(List<Party> subscribers) {
		this.subscribers = subscribers;
	}
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
}
