package org.acme.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class Vet {

	public long id;
	
	@NotEmpty
	public String firstName;

	@NotEmpty
	public String lastName;

    public List<Specialty> specialties;
	
}
