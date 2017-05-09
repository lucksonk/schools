package za.co.enigma.domain.party.person;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import lombok.EqualsAndHashCode;
import za.co.enigma.domain.party.IdentificationType;
import za.co.enigma.domain.party.Party;
import za.co.enigma.domain.party.PartyRoleType;

@EqualsAndHashCode(callSuper=true)

@NamedQueries(
		{
			@NamedQuery(name=Person.FIND_BY_ID_NUMBER,query="SELECT p FROM Person p WHERE p.identificationNumber = :idNumber"),
			@NamedQuery(name=Person.FIND_ALL_WITH_IDS,query="SELECT p FROM Person p WHERE p.id IN :ids ")
		})

@Entity
@Table(name="PERSON")
public class Person extends Party implements Serializable {

	private static final long serialVersionUID = -872301141247224928L;

	public static final String FIND_BY_ID_NUMBER = "Person.findByIdNumber";
	public static final String FIND_ALL_WITH_IDS = "Person.findAllWithIds";

	private PersonGender personGender;
	private PersonTitle personTitle;
	private PartyRoleType partyRoleType;
	private LocalDate bornOn;
	private LocalDate diedOn;
	private String suffix;
	private String givenName;
	private String familyName;
	private String preferredName;
	private String nickname;
	private IdentificationType identificationType;
	private String identificationNumber;
	private Integer height;
	private Integer weight;
	private String mothersMaidenName;
	private MaritalStatusType maritalStatus;
	private Passport passport;
	
	@Enumerated(EnumType.STRING)
	@Column(name="PERSON_GENDER")
	public PersonGender getPersonGender() {
		return personGender;
	}

	public void setPersonGender(PersonGender personGender) {
		this.personGender = personGender;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="PERSON_TITLE")
	public PersonTitle getPersonTitle() {
		return personTitle;
	}

	public void setPersonTitle(PersonTitle personTitle) {
		this.personTitle = personTitle;
	}

	@Column(name="BORN_ON")
	public LocalDate getBornOn() {
		return bornOn;
	}

	public void setBornOn(LocalDate bornOn) {
		this.bornOn = bornOn;
	}

	@Column(name="DIED_ON")
	public LocalDate getDiedOn() {
		return diedOn;
	}

	public void setDiedOn(LocalDate diedOn) {
		this.diedOn = diedOn;
	}
	@Column(name="SUFFIX")
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Column(name="GIVEN_NAME")
	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	@Column(name="FAMILY_NAME")
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Column(name="PREFERRED_NAME")
	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="PARTY_ROLE_TYPE")
	public PartyRoleType getPartyRoleType() {
		return partyRoleType;
	}

	public void setPartyRoleType(PartyRoleType partyRoleType) {
		this.partyRoleType = partyRoleType;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="IDENTIFICATION_TYPE")
	public IdentificationType getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}

	@Column(name="IDENTIFICATION")
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

}