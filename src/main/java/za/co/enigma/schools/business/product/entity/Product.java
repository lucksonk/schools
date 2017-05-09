package za.co.enigma.schools.business.product.entity;

import java.time.LocalDate;

import za.co.enigma.domain.archetypes.ThingDomainArchetype;


public class Product extends ThingDomainArchetype {

	private static final long serialVersionUID = -8907826487592835266L;
	
	private String name;
	private String description;
	private LocalDate introductionDate;
	private LocalDate salesDiscontinuationDate;
	private LocalDate supportDiscontinuationDate;
	private String comment;
	private ProductType productType;
	

}
