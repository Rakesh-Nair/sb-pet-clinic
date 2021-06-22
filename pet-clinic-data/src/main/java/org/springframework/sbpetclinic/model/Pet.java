package org.springframework.sbpetclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pet extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@Column(name = "name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();

	@Builder
	public Pet(Long id, PetType petType, Owner owner, LocalDate birthDate, String name, Set<Visit> visits) {
		super(id);
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
		this.name = name;
		if (visits != null && visits.size() > 0)
			this.visits = visits;
	}
}
