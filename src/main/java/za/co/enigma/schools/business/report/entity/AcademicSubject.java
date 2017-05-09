package za.co.enigma.schools.business.report.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.DescriptionDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="ACADEMIC_SUBJECT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ACADEMIC_SUBJECT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = AcademicSubject.findAll, query = "SELECT a FROM AcademicSubject a")
public class AcademicSubject extends DescriptionDomainArchetype {

	private static final long serialVersionUID = -7223511238608400967L;
	private static final String PREFIX = "za.co.enigma.schools.business.report.entity.subject.";
    public static final String findAll = PREFIX + "all";
}
