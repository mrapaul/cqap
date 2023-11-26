package com.capstone.server.controller;
//
//import ch.lambdaj.function.convert.*;
//import com.cqap.merge.*;
//import com.merge.HL7.*;
//import com.peirs.datamodel.hl7.*;
//import org.slf4j.*;
//
//import java.util.*;
////
//public class MergeHL7MessageToHL7Converter implements Converter<MergeHL7Message, HL7>
//{
//    private static final Logger LOGGER = LoggerFactory.getLogger(MergeHL7MessageToHL7Converter.class);
//    private final MergeHL7Parser theMergeHL7Parser;
//
//    public MergeHL7MessageToHL7Converter()
//    {
//        Properties myProperties = new Properties();
//        myProperties.setProperty("LICENSE_KEY",
//                "pdWeyxIPKwAAMTwGAF4snTyqjW5DQOQa6+XqaKFV7uMnkk1ABmYith4PlXNsRXekpynZzr4fDpfBMfA5BAYjzTjK9oalagX6UMvDHqdlSeuosZjDMpHMSre2Ek8k68dEOLkg3P9zZwzwfD39a17MzsrG3kBPxID82StoVnQU95UsvcXvbVwptrA398wPDY1XtfE=");
//        HL7Toolkit.setProperties(myProperties);
//        theMergeHL7Parser = new MergeHL7Parser();
//    }
//
//    @Override public HL7 convert(MergeHL7Message aMergeHL7Message)
//    {
//        try
//        {
//            return theMergeHL7Parser.parse(aMergeHL7Message.getMessage());
//        }
//        catch (Exception e)
//        {
//            LOGGER.error("Error parsing HL7", e);
//        }
//
//        return null;
//    }
//}
