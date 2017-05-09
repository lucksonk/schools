package za.co.enigma.schools.business.attendance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.DescriptionDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="ATTENDANCE_STATUS",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ATTENDANCE_STATUS_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AttendanceStatus extends DescriptionDomainArchetype {

	private static final long serialVersionUID = 5724510568933380287L;
	
	private AttendanceStatusType type;

	@Enumerated(EnumType.STRING)
	@Column(name = "ATTENDANCE_STATUS_TYPE")
	public AttendanceStatusType getType() {
		return type;
	}

	public void setType(AttendanceStatusType type) {
		this.type = type;
	}
	
}
