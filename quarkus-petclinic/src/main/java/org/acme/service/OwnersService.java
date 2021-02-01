package org.acme.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.acme.model.Owner;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class OwnersService {

    public List<Owner> findByLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            return Owner.find("LOWER(lastName) LIKE LOWER(?1) ",
                Sort.by("firstName"), "%" + lastName + "%").list();
        } else {
            return Owner.listAll();
        }
    }

    public Owner findById(Long id) {
        return Owner.findById(id.longValue());
    }

}