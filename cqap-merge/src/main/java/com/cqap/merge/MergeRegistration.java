package com.cqap.merge;

import com.merge.HL7.*;

import java.util.*;

public class MergeRegistration
{
    private static final int PORT_NUMBER = 10888;

    static Properties registerToolkit()
    {
        Properties myProperties = new Properties();

        myProperties.setProperty("LICENSE_KEY",
                "pdWeyxIPKwAAMTwGAF4snTyqjW5DQOQa6+XqaKFV7uMnkk1ABmYith4PlXNsRXekpynZzr4fDpfBMfA5BAYjzTjK9oalagX6UMvDHqdlSeuosZjDMpHMSre2Ek8k68dEOLkg3P9zZwzwfD39a17MzsrG3kBPxID82StoVnQU95UsvcXvbVwptrA398wPDY1XtfE=");
        myProperties.setProperty("PORT", String.valueOf(PORT_NUMBER));
        myProperties.setProperty("HOSTNAME", "0.0.0.0");

        HL7Toolkit.setProperties(myProperties);
        return myProperties;
    }
}
