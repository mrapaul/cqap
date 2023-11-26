package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class CPTMnemonicBuilder
{
    @NotNull private String modality;
    @Nullable private String number;
    @NotNull private String mnemonic;
    @Nullable private String cPTCode;
    @Nullable private String institution;

    public CPTMnemonicBuilder(@NotNull String modality,
                              @NotNull String mnemonic)
    {
        super();

        this.modality = modality;
        this.mnemonic = mnemonic;
    }


    @NotNull
    public CPTMnemonicBuilder setModality(@NotNull String modality)
    {
        this.modality = modality;

        return self();
    }

    @NotNull
    public CPTMnemonicBuilder setNumber(@Nullable String number)
    {
        this.number = number;

        return self();
    }

    @NotNull
    public CPTMnemonicBuilder setMnemonic(@NotNull String mnemonic)
    {
        this.mnemonic = mnemonic;

        return self();
    }

    @NotNull
    public CPTMnemonicBuilder setCPTCode(@Nullable String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }

    @NotNull
    public CPTMnemonicBuilder setInstitution(@Nullable String institution)
    {
        this.institution = institution;

        return self();
    }

    @NotNull
    protected String getModality()
    {
        return modality;
    }

    @Nullable
    protected String getNumber()
    {
        return number;
    }

    @NotNull
    protected String getMnemonic()
    {
        return mnemonic;
    }

    @Nullable
    protected String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    protected String getInstitution()
    {
        return institution;
    }

    @NotNull
    public CPTMnemonic build()
    {
        return new CPTMnemonic(getModality(),
                               getNumber(),
                               getMnemonic(),
                               getCPTCode(),
                               getInstitution());
    }


    @NotNull
    protected CPTMnemonicBuilder self()
    {
        return this;
    }
}