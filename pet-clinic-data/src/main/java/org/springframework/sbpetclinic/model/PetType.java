package org.springframework.sbpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "types")
@Setter
@Getter
@NoArgsConstructor
public class PetType extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Override
	public String toString() {
		return name;
	}

	@Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}
}
