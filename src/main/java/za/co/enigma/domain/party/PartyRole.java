package za.co.enigma.domain.party;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.RoleDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "PARTY_ROLE",
uniqueConstraints={
		@UniqueConstraint(name = "PARTY_ROLE_02U",
		        columnNames = { "ID", "UUID" })
	}
)
public abstract class PartyRole extends RoleDomainArchetype implements Serializable {

    private static final long serialVersionUID = 5689108970129618527L;
    
    
}