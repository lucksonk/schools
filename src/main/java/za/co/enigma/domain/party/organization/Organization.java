package za.co.enigma.domain.party.organization;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.party.Party;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="ORGANIZATION")
public class Organization extends Party implements Serializable {

	private static final long serialVersionUID = -1190096609066336170L;


	private String shortName;
	private String tradingAs;
	private LocalDate registeredOn;
	private LocalDate deRegistedOn;
	private String name;
	private OrganizationType organizationType;
	private OrganizationStatus organizationStatus ;

	@NotNull(message = "\" The Short Name field cannot be null. \"")
	@Column(name ="SHORT_NAME")
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	@NotNull(message = "\" The Trading As field cannot be null. \"")
	@Column(name ="TRADING_AS")
	public String getTradingAs() {
		return tradingAs;
	}

	public void setTradingAs(String tradingAs) {
		this.tradingAs = tradingAs;
	}
	
	@NotNull(message = "\" The Registered On field cannot be null. \"")
	@Column(name ="REGISTERED_ON")
	public LocalDate getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(LocalDate registeredOn) {
		this.registeredOn = registeredOn;
	}
	
	@Column(name ="DE_REGISTERED_ON")
	public LocalDate getDeRegistedOn() {
		return deRegistedOn;
	}

	public void setDeRegistedOn(LocalDate deRegistedOn) {
		this.deRegistedOn = deRegistedOn;
	}
	
	@NotNull(message = "\" The Name field cannot be null. \"")
	@Column(name ="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ORGANIZATION_TYPE")
	public OrganizationType getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ORGANIZATION_STATUS")
	public OrganizationStatus getOrganizationStatus() {
		return organizationStatus;
	}

	public void setOrganizationStatus(OrganizationStatus organizationStatus) {
		this.organizationStatus = organizationStatus;
	}

}
