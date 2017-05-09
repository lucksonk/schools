package za.co.enigma.schools.business.report.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.ThingDomainArchetype;
import za.co.enigma.domain.party.person.Person;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="ACADEMIC_PERFORMANCE_REPORT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ACADEMIC_PERFORMANCE_REPORT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = AcademicPerformanceReport.findAll, query = "SELECT a FROM AcademicPerformanceReport a")
public class AcademicPerformanceReport extends ThingDomainArchetype {

	private static final long serialVersionUID = 9212191859680458440L;
	private static final String PREFIX = "za.co.enigma.schools.business.report.entity.performance.";
    public static final String findAll = PREFIX + "all";
    
	private Person student;
	private String term;
	private Map<AcademicSubject, SubjectPerformanceReport> performance = new HashMap<>();
	private String principalComment;
	private long averagePerformance;
	
	@Column(name = "STUDENT_PERSON_ID")
	public Person getStudent() {
		return student;
	}
	public void setStudent(Person student) {
		this.student = student;
	}
	
	@Column(name = "SCHOOL_TERM")
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public Map<AcademicSubject, SubjectPerformanceReport> getPerformance() {
		return performance;
	}
	public void setPerformance(Map<AcademicSubject, SubjectPerformanceReport> performance) {
		this.performance = performance;
	}
	
	@Column(name = "PRINCIPAL_COMMENT")
	public String getPrincipalComment() {
		return principalComment;
	}
	public void setPrincipalComment(String principalComment) {
		this.principalComment = principalComment;
	}
	
	@Column(name = "ACADEMIC_AVERAGE_PERFORMANCE")
	public long getAveragePerformance() {
		return averagePerformance;
	}
	public void setAveragePerformance(long averagePerformance) {
		this.averagePerformance = averagePerformance;
	}
	
}
