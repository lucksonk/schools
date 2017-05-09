package za.co.enigma.schools.business.credential.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import za.co.enigma.domain.archetypes.PartyDomainArchetype;
import za.co.enigma.domain.party.person.Person;


@Entity
@Table(name = "USER",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(
				name="USER_01U", columnNames={"ID", "UUID"}),
		@javax.persistence.UniqueConstraint(
				name="USER_02U", columnNames={"ID", "PERSON_ID"}),
		@javax.persistence.UniqueConstraint(
				name="USER_03U", columnNames={"ID", "USERNAME"})
})
public class User extends PartyDomainArchetype implements  Serializable {

   	private static final long serialVersionUID = -7989733268496968968L;

    private String username;
    private String password;
    private boolean locked;
    private Person person;
    
	@NotNull(message="\"The Captured username field cannot be null.\"")
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	@NotNull(message="\"The Captured password field cannot be null.\"")
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "LOCKED")
    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
	@NotNull(message="\"The Captured person id field cannot be null.\"")
    @OneToOne
    @JoinColumn(name="PERSON_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
