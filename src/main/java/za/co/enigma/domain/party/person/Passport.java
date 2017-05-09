package za.co.enigma.domain.party.person;

import java.time.LocalDate;

public class Passport {

	private long passportId;
	private String passportNumber;
	private LocalDate issueDate;
	private LocalDate expirationDate;
	private Citizenship citizenship;
}
