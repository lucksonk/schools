package za.co.enigma.domain.party;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.PartyDomainArchetype;


@EqualsAndHashCode(callSuper=true)

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="PARTY",
uniqueConstraints= {
        @javax.persistence.UniqueConstraint(
                name="PARTY_02U", 
                columnNames={"ID", "UUID"})
        }
)
public abstract class Party extends PartyDomainArchetype  {
    
    private static final long serialVersionUID = -8574288458859355337L;

    private String cellphone;
    private String telephone;
    private String emailAddress;
    private String address;
    
	@Column(name="CELLPHONE")
	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	@Column(name="TELEPHONE")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(name="EMAIL_ADDRESS")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}