package za.co.enigma.schools.business.attendance.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;
import za.co.enigma.domain.party.person.Person;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name="ATTENDANCE_REGISTER",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="ATTENDANCE_REGISTER_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = AttendanceRegister.findAll, query = "SELECT a FROM AttendanceRegister a")
public class AttendanceRegister extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = 8941034726204638174L;
	private static final String PREFIX = "za.co.enigma.schools.business.attendance.entity.";
    public static final String findAll = PREFIX + "all";
    
    private String grade;
    private String subject;
    private String className;
    private Person teacher;
    private Map<Person, AttendanceStatus> students = new HashMap<>();
    
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Person getTeacher() {
		return teacher;
	}
	public void setTeacher(Person teacher) {
		this.teacher = teacher;
	}
	
	/*@JoinTable(name= "ATTENDANCE_REGISTER_STUDENT_ATTENDANCE",
			joinColumns=@JoinColumn(name ="PERSON_ID"),
			inverseJoinColumns = @JoinColumn(name = "ATT"))*/
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public Map<Person, AttendanceStatus> getStudents() {
		return students;
	}
	public void setStudents(Map<Person, AttendanceStatus> students) {
		this.students = students;
	}
}
