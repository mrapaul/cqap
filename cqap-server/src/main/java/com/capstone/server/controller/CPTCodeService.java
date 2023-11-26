package com.capstone.server.controller;

import com.google.common.collect.*;
import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.hl7.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

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

    public CPTCodePrimaryGroups primarySecondarySpecialities()
    {
        CPTCodes cptCodes = findAll();
        Multimap<String, String> primaryToSecondaryMapping = HashMultimap.create();
        Multimap<String, String> secondaryToCodeMapping = HashMultimap.create();
        for (CPTCode cptCode : cptCodes.getCodes())
        {
            String subspecialtyPrimary = cptCode.getSubspecialtyPrimary();
            String subspecialtySecondary = cptCode.getSubspecialtySecondary();
            primaryToSecondaryMapping.put(subspecialtyPrimary, subspecialtySecondary);
            secondaryToCodeMapping.put(subspecialtySecondary, String.valueOf(cptCode.getCPTCode()));
        }

        List<CPTCodePrimaryGroup> primaryGroups = Lists.newArrayList();
        for (String primaryCode : primaryToSecondaryMapping.keySet())
        {
            List<CPTCodeSecondaryGroup> secondaryGroups = Lists.newArrayList();
            Collection<String> secondaryCodes = primaryToSecondaryMapping.get(primaryCode);
            for (String secondaryCode : secondaryCodes)
            {
                secondaryGroups.add(new CPTCodeSecondaryGroup(secondaryCode,
                        secondaryToCodeMapping.get(secondaryCode)));
            }
            primaryGroups.add(new CPTCodePrimaryGroup(primaryCode, secondaryGroups));
        }
        return new CPTCodePrimaryGroups(primaryGroups);
    }
}
