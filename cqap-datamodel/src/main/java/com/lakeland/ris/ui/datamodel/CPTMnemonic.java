package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class CPTMnemonic
{
    @NotNull private String modality;
    @Nullable private String number;
    @NotNull private String mnemonic;
    @Nullable private String cPTCode;
    @Nullable private String institution;

    public CPTMnemonic()
    {
        // empty
    }

    @JsonCreator
    public CPTMnemonic(@NotNull String modality,
                       @Nullable String number,
                       @NotNull String mnemonic,
                       @Nullable String cPTCode,
                       @Nullable String institution)
    {
        super();

        this.modality = modality;
        this.number = number;
        this.mnemonic = mnemonic;
        this.cPTCode = cPTCode;
        this.institution = institution;
    }

    @NotNull
    public String getModality()
    {
        return modality;
    }

    @Nullable
    public String getNumber()
    {
        return number;
    }

    @NotNull
    public String getMnemonic()
    {
        return mnemonic;
    }

    @Nullable
    public String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    public String getInstitution()
    {
        return institution;
    }
    public void setModality(@NotNull String modality)
    {
        this.modality = modality;
    }

    public void setNumber(@Nullable String number)
    {
        this.number = number;
    }

    public void setMnemonic(@NotNull String mnemonic)
    {
        this.mnemonic = mnemonic;
    }

    public void setCPTCode(@Nullable String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setInstitution(@Nullable String institution)
    {
        this.institution = institution;
    }

    @NotNull
    public String toString()
    {
        return "CPTMnemonic(" +
            " modality: " + getModality() +
            " number: " + getNumber() +
            " mnemonic: " + getMnemonic() +
            " cPTCode: " + getCPTCode() +
            " institution: " + getInstitution() + ")";
    }

    @NotNull
    public CPTMnemonicBuilder toBuilder()
    {
        return new CPTMnemonicBuilder(getModality(),
                                      getMnemonic()).setNumber(getNumber())

                                                     .setCPTCode(getCPTCode())
                                                     .setInstitution(getInstitution());
    }
}