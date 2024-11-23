package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class CPTMnemonic
{
    private String modality;
     private String number;
    private String mnemonic;
     private String cPTCode;
     private String institution;

    public CPTMnemonic()
    {
        // empty
    }

    @JsonCreator
    public CPTMnemonic(String modality,
                        String number,
                       String mnemonic,
                        String cPTCode,
                        String institution)
    {
        super();

        this.modality = modality;
        this.number = number;
        this.mnemonic = mnemonic;
        this.cPTCode = cPTCode;
        this.institution = institution;
    }


    public String getModality()
    {
        return modality;
    }

    
    public String getNumber()
    {
        return number;
    }


    public String getMnemonic()
    {
        return mnemonic;
    }

    
    public String getCPTCode()
    {
        return cPTCode;
    }

    
    public String getInstitution()
    {
        return institution;
    }
    public void setModality(String modality)
    {
        this.modality = modality;
    }

    public void setNumber( String number)
    {
        this.number = number;
    }

    public void setMnemonic(String mnemonic)
    {
        this.mnemonic = mnemonic;
    }

    public void setCPTCode( String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setInstitution( String institution)
    {
        this.institution = institution;
    }


    public String toString()
    {
        return "CPTMnemonic(" +
            " modality: " + getModality() +
            " number: " + getNumber() +
            " mnemonic: " + getMnemonic() +
            " cPTCode: " + getCPTCode() +
            " institution: " + getInstitution() + ")";
    }


    public CPTMnemonicBuilder toBuilder()
    {
        return new CPTMnemonicBuilder(getModality(),
                                      getMnemonic()).setNumber(getNumber())

                                                     .setCPTCode(getCPTCode())
                                                     .setInstitution(getInstitution());
    }
}