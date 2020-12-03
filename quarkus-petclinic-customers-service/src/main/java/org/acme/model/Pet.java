package org.acme.model;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity(name="pets")
@Cacheable
public class Pet extends PanacheEntityBase {
  
	@Id
    @SequenceGenerator(
            name = "petsSequence",
            sequenceName = "pets_id_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petsSequence")
	public Long id;
	
	public String name;
	
	@Column(name = "birth_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "type_id")
	public PetType type;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	@JsonIgnore
	public Owner owner;

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public Long getId(){
        return id;
    }

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}
  
	
}