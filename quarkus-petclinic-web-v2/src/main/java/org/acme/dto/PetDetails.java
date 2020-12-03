package org.acme.dto;

import java.time.LocalDate;

import org.acme.model.Pet;
import org.acme.model.PetType;

public class PetDetails {

    public long id;

    public String name;

    public String owner;

    public LocalDate birthDate;

    public PetType type;

    public PetDetails() {

    }
    
    public PetDetails(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.owner = pet.getOwner().getFirstName() + " " + pet.getOwner().getLastName();
        this.birthDate = pet.getBirthDate();
        this.type = pet.getType();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
