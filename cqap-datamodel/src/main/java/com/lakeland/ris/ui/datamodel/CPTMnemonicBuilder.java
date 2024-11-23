package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class CPTMnemonicBuilder
{
    private String modality;
     private String number;
    private String mnemonic;
     private String cPTCode;
     private String institution;

    public CPTMnemonicBuilder(String modality,
                              String mnemonic)
    {
        super();

        this.modality = modality;
        this.mnemonic = mnemonic;
    }



    public CPTMnemonicBuilder setModality(String modality)
    {
        this.modality = modality;

        return self();
    }


    public CPTMnemonicBuilder setNumber( String number)
    {
        this.number = number;

        return self();
    }


    public CPTMnemonicBuilder setMnemonic(String mnemonic)
    {
        this.mnemonic = mnemonic;

        return self();
    }


    public CPTMnemonicBuilder setCPTCode( String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }


    public CPTMnemonicBuilder setInstitution( String institution)
    {
        this.institution = institution;

        return self();
    }


    protected String getModality()
    {
        return modality;
    }

    
    protected String getNumber()
    {
        return number;
    }


    protected String getMnemonic()
    {
        return mnemonic;
    }

    
    protected String getCPTCode()
    {
        return cPTCode;
    }

    
    protected String getInstitution()
    {
        return institution;
    }


    public CPTMnemonic build()
    {
        return new CPTMnemonic(getModality(),
                               getNumber(),
                               getMnemonic(),
                               getCPTCode(),
                               getInstitution());
    }



    protected CPTMnemonicBuilder self()
    {
        return this;
    }
}