package org.acme.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.model.Vet;

@ApplicationScoped 
public class VetsService {

    public List<Vet> getAll() {
        return Vet.listAll();
    }

}