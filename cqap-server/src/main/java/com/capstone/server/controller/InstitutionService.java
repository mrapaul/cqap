package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component("InstitutionService")
public class InstitutionService
{
    @Autowired private InstitutionRepository theRepository;

    public Institutions findAll()
    {
        return new Institutions(theRepository.findAll());
    }

    public Institution createOrUpdate(Institution aInstitution)
    {
        return theRepository.save(aInstitution);
    }

    public void delete(Institution aInstitution)
    {
        theRepository.delete(aInstitution);
    }
}
