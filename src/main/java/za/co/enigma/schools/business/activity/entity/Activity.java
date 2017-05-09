package za.co.enigma.schools.business.activity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="ACTIVITY",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ACTIVITY_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Activity.findAll, query = "SELECT a FROM Activity a")
public class Activity extends MomentIntervalDomainArchetype {
	
	private static final long serialVersionUID = 8199520773461809904L;
	private static final String PREFIX = "za.co.enigma.schools.business.activity.entity.";
    public static final String findAll = PREFIX + "all";
    
    private String name;

    @Column(name = "NAME", nullable = false)
    @NotNull(message = "\"The name From field cannot be null.\"")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
