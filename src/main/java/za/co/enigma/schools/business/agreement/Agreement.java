package za.co.enigma.schools.business.agreement;

import java.time.LocalDate;

import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

/**
 * 
 * @author luckson
 *
 *	An agreement is a set of terms and conditions that govern the relationship
 *  between two parties—for example, a customer and a supplier. A key difference
 *  between an order and an agreement is that an order is a one-time commitment
 *  to buy products while an agreement specifies how the two parties will conduct
 *  business over time.
 *  
 *  The agreement represents a contractual commitment and is associated with their party relationship.
 */
public class Agreement extends MomentIntervalDomainArchetype {
	
	private long agreementId;
	private LocalDate agreementDate;
	private AgreementType description;

}
