package com.capstone.server.controller;

import com.peirs.datamodel.hl7.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component("CPTCodeService")
public class CPTCodeService
{
    @Autowired private CPTCodeRepository theRepository;

    public CPTCodes findAll()
    {
        return new CPTCodes(theRepository.findAll());
    }

    public CPTCode findOne(String aCPTCode)
    {
        return theRepository.findByCPTCode(aCPTCode);
    }

    public CPTCode createOrUpdate(CPTCode aCPTCode)
    {
        return theRepository.save(aCPTCode);
    }
}
