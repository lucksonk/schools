package za.co.enigma.domain.archetypes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.EqualsAndHashCode;
import za.co.enigma.common.util.LocalDateTimeAdapter;
/**
 * 
 * @author luckson
 * The Moment-Interval class archetype that models something that one needs to work with 
 * and track for business and legal reasons, 
 * something that occurs at a moment in time or over an interval of time.
 * Moment-Interval classes are pink (pastel red). 
 * They represent happenings that take place that our software is interested in, 
 * interactions and business transactions between people, places and things
 */

@EqualsAndHashCode(callSuper=true)

@MappedSuperclass
public abstract class MomentIntervalDomainArchetype extends BaseEntity {

    private static final long serialVersionUID = -709323524159747392L;
    
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime effectiveFrom;
    
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime effectiveTo;

    @Column(name = "EFFECTIVE_FROM", nullable = false)
    @NotNull(message = "\"The Effective From field cannot be null.\"")
	public LocalDateTime getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(LocalDateTime effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

    @Column(name = "EFFECTIVE_TO", nullable = false)
    @NotNull(message = "\"The Effective From field cannot be null.\"")
	public LocalDateTime getEffectiveTo() {
		return effectiveTo;
	}

	public void setEffectiveTo(LocalDateTime effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
    
    
}
