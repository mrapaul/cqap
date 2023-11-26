package com.cqap.util;

import ch.lambdaj.*;
import ch.lambdaj.collection.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.hl7.*;

import java.util.*;

public class InstitutionFinder
{
    public static Institution findInstitution(Collection<String> aInstitutions,
                                              Collection<HL7> aHL7s,
                                              Collection<Institution> aAvailableInstitutions)
    {

        Map<String, Institution> myMappedInstitutions =
                LambdaCollections.with(aAvailableInstitutions).map(Lambda.on(Institution.class).getAlias());
        Institution myInstitution = findInstitution(aHL7s, myMappedInstitutions);
        if (myInstitution == null)
        {
            myInstitution = findInstitution(myMappedInstitutions, aInstitutions);
        }
        return myInstitution;
    }

    private static Institution findInstitution(Collection<HL7> aHL7Messages, Map<String, Institution> aInstitutions)
    {
        for (HL7 myHL7Message : aHL7Messages)
        {
            String myInstitutionId = myHL7Message.getInstitutionId();
            if (myInstitutionId != null && !myInstitutionId.isEmpty())
            {
                if (aInstitutions.containsKey(myInstitutionId))
                {
                    return aInstitutions.get(myInstitutionId);
                }
            }
        }

        return null;
    }

    private static Institution findInstitution(Map<String, Institution> aAvailableInstitutions,
                                               Collection<String> aInstitutions)
    {
        for (String myInstitution : aInstitutions)
        {
            if (myInstitution != null && !myInstitution.isEmpty())
            {
                if (aAvailableInstitutions.containsKey(myInstitution))
                {
                    return aAvailableInstitutions.get(myInstitution);
                }
            }
        }

        return null;
    }
}
