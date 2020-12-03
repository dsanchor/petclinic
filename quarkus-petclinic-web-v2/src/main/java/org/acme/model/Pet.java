package org.acme.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.acme.dto.PetDetails;

public class Pet  {
  
	public Long id;
	
	public String name;
	
	public LocalDate birthDate;

	public PetType type;

	public Pet() {

	}

	public Pet(PetDetails petDetails) {

		id = petDetails.getId();
		name = petDetails.getName();
		birthDate = petDetails.getBirthDate();
		type = petDetails.getType();
	}
	
	public PetType getType() {
		return this.type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public Owner owner;

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@JsonIgnore
	public List<Visit> visits;
	
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

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
 
	
}