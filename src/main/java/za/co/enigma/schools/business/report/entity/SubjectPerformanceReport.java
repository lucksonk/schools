package za.co.enigma.schools.business.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.ThingDomainArchetype;
import za.co.enigma.domain.party.person.Person;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="SUBJECT_PERFORMANCE_REPORT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="SUBJECT_PERFORMANCE_REPORT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = SubjectPerformanceReport.findAll, query = "SELECT s FROM SubjectPerformanceReport s")
public class SubjectPerformanceReport extends ThingDomainArchetype {

	private static final long serialVersionUID = 15776915372502945L;
	private static final String PREFIX = "za.co.enigma.schools.business.report.entity.";
    public static final String findAll = PREFIX + "all";

    private Double percentage;
    private int marks;
    private Person student;
    private String teacherRemarks;
    
    @Column(name = "PERCENTAGE")
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	@Column(name = "STUDENT_MARKS")
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	@Column(name = "STUDENT_PERSON_ID")
	public Person getStudent() {
		return student;
	}
	public void setStudent(Person student) {
		this.student = student;
	}
	@Column(name = "TEACHER_REMARKS")
	public String getTeacherRemarks() {
		return teacherRemarks;
	}
	public void setTeacherRemarks(String teacherRemarks) {
		this.teacherRemarks = teacherRemarks;
	}
    
}
