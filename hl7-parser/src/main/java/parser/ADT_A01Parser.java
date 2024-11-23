package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.message.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;


import java.util.*;

public class ADT_A01Parser implements MessageParser<ADT_A01>
{
    private final MSHParser mshParser;
    private final OBXParser obxParser;
    private final AL1Parser al1Parser;
    private final GT1Parser gt1Parser;
    private DetailedOrderBuilder detailedOrderBuilder;
    private final DG1Parser dg1Parser;

    public ADT_A01Parser()
    {
        mshParser = new MSHParser();
        obxParser = new OBXParser();
        al1Parser = new AL1Parser();
        gt1Parser = new GT1Parser();
        dg1Parser = new DG1Parser();
    }

    @Override public void convert(ADT_A01 adt,
                                  DetailedOrderBuilder orderBuilder) throws HL7Exception
    {
        detailedOrderBuilder = orderBuilder;
        String[] names = adt.getNames();
        for (String name : names)
        {
            Structure structure = adt.get(name);
            switch (name)
            {
                case ("MSH"):
                {
                    MSH msh = (MSH) structure;
                    mshParser.convert(msh, detailedOrderBuilder);
                    break;
                }
                case ("SFT"):
                {
                    break;
                }
                case ("UAC"):
                {
                    break;
                }
                case ("EVN"):
                {
                    break;
                }
                case ("PID"):
                {
                    break;
                }
                case ("PD1"):
                {
                    break;
                }
                case ("ARV"):
                {
                    break;
                }
                case ("ROL"):
                {
                    break;
                }
                case ("NK1"):
                {
                    break;
                }
                case ("PV1"):
                {
                    System.out.println("PV1");
                    break;
                }
                case ("NK12"):
                {
                    break;
                }
                case ("PV2"):
                {
                    break;
                }
                case ("ARV2"):
                {
                    break;
                }
                case ("ROL2"):
                {
                    break;
                }
                case ("DB1"):
                {
                    break;
                }
                case ("OBX"):
                {
                    OBX obx = (OBX) structure;
                    obxParser.convert(obx, detailedOrderBuilder);

                    break;
                }
                case ("AL1"):
                {
                    List<AL1> allergies = adt.getAL1All();
                    al1Parser.convert(allergies, detailedOrderBuilder);

                    break;
                }
                case ("DG1"):
                {
                    List<DG1> dg1All = adt.getDG1All();
                    dg1Parser.convert(dg1All, detailedOrderBuilder);

                    break;
                }
                case ("DRG"):
                {
                    break;
                }
                case ("PROCEDURE"):
                {
                    ADT_A01_PROCEDURE procedure = adt.getPROCEDURE();
                    convert(procedure);

                    break;
                }
                case ("GT1"):
                {
                    List<GT1> gt1All = adt.getGT1All();
                    gt1Parser.convert(gt1All, detailedOrderBuilder);

                    break;
                }
                case ("DG12"):
                {
                    break;
                }
                case ("INSURANCE"):
                {
                    convert(adt.getINSURANCEAll());

                    break;
                }
                case ("ACC"):
                {
                    break;
                }
                case ("UB1"):
                {
                    break;
                }
                case ("UB2"):
                {
                    break;
                }
                case ("PDA"):
                {
                    break;
                }
            }
        }
    }

    private void convert(ADT_A01_PROCEDURE procedure) throws DataTypeException
    {
        PR1 pr1 = procedure.getPR1();
        convert(pr1);
    }

    private void convert(PR1 pr1) throws DataTypeException
    {
        String procedureDateTime = pr1.getPr15_ProcedureDateTime().getValue();
        String procedureCode = pr1.getProcedureCode().getCne1_Identifier().getValue();
        String procedureCodeScheme = pr1.getPr120_ProcedureActionCode().getValue();
        detailedOrderBuilder.setProcedureCode(procedureCode)
                .setProcedureCodeScheme(procedureCodeScheme)
                .setProcedureStartDate(procedureDateTime);
    }

    private void convert(List<ADT_A01_INSURANCE> insurances) throws HL7Exception
    {
        new IN1Parser().convert(insurances, detailedOrderBuilder);
    }
}
