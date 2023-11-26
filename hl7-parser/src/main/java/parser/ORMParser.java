package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.message.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class ORMParser implements MessageParser<ORM_O01>
{
    @NotNull private final MSHParser mshParser;
    @NotNull private final OBXParser obxParser;
    @NotNull private DetailedOrderBuilder detailedOrderBuilder;

    public ORMParser()
    {
        mshParser = new MSHParser();
        obxParser = new OBXParser();
    }

    @Override public void convert(@NotNull ORM_O01 orm,
                                  @NotNull DetailedOrderBuilder orderBuilder) throws HL7Exception
    {
        detailedOrderBuilder = orderBuilder;
        String[] names = orm.getNames();
        for (String name : names)
        {
            Structure structure = orm.get(name);
            switch (name)
            {
                case ("MSH"):
                {
                    MSH msh = (MSH) structure;
                    mshParser.convert(msh, detailedOrderBuilder);
                    break;
                }
                case ("PATIENT"):
                {
                    ORM_O01_PATIENT patient = (ORM_O01_PATIENT) structure;
                    convert(patient);
                    break;
                }
                case ("ORDER"):
                {
                    ORM_O01_ORDER order = (ORM_O01_ORDER) structure;
                    convert(order);
                    break;
                }
                case ("OBR"):
                {
                    OBR obr = (OBR) structure;
                    convert(obr);
                    break;
                }
                case ("ORC"):
                {
                    ORC orc = (ORC) structure;
                    convert(orc);
                    break;
                }
                case ("NTE"):
                {
                    NTE nte = (NTE) structure;
                    FT[] commentType = nte.getNte3_Comment();
                    StringBuilder builder = new StringBuilder();
                    for (FT ft : commentType)
                    {
                        builder.append(ft.getValue()).append("\n");
                    }
                    detailedOrderBuilder.setReasonForExam(builder.toString());
                }
            }
        }

        String institution = orm.getMSH().getMsh4_SendingFacility().getHd1_NamespaceID().getValue();
        if (institution != null && institution.contains("Truman"))
        {
            convert(orm.getORDER().getORC());
        }
    }

    private void convert(ORM_O01_PATIENT patient) throws HL7Exception
    {
        String[] names = patient.getNames();
        for (String name : names)
        {
            Structure structure = patient.get(name);
            switch (name)
            {
                case ("PID"):
                {
                    PID pid = (PID) structure;
                    convert(pid);
                    break;
                }
                case ("PD1"):
                {
                    PD1 insurance = (PD1) structure;
                    convert(insurance);
                    break;
                }
                case ("NTE"):
                {
                    NTE nte = (NTE) structure;
                    convert(nte);
                    break;
                }
                case ("PATIENT_VISIT"):
                {
                    ORM_O01_PATIENT_VISIT visit = (ORM_O01_PATIENT_VISIT) structure;
                    convert(visit);
                    break;
                }
                case ("GT1"):
                {
                    convert(patient.getGT1());
                    break;
                }
                case ("AL1"):
                {
                    convert(patient.getAL1All());
                    break;
                }
            }
        }
    }

    private void convert(PD1 insurance) throws HL7Exception
    {
        new PD1Parser().convert(insurance, detailedOrderBuilder);
    }

    private void convert(NTE nte)
    {
        // empty
    }

    private void convert(ORM_O01_PATIENT_VISIT visit) throws HL7Exception
    {
        for (String name : visit.getNames())
        {
            Structure structure = visit.get(name);
            switch (name)
            {
                case ("PV1"):
                {
                    PV1 pv1 = (PV1) structure;
                    convert(pv1);
                    break;
                }
                case ("PV2"):
                {
                    PV2 pv2 = (PV2) structure;
                    convert(pv2);
                    break;
                }
            }
        }
    }

    private void convert(PV1 pv1) throws DataTypeException
    {
        new PV1Parser().convert(pv1, detailedOrderBuilder);
    }

    private void convert(PV2 pv2) throws HL7Exception
    {
        new PV2Parser().convert(pv2, detailedOrderBuilder);
    }

    private void convert(GT1 gt1) throws HL7Exception
    {
        new GT1Parser().convert(Arrays.asList(gt1), detailedOrderBuilder);
    }

    private void convert(PID pid) throws HL7Exception
    {
        new PIDParser().convert(pid, detailedOrderBuilder);
    }

    private void convert(List<AL1> al1)
    {
        new AL1Parser().convert(al1, detailedOrderBuilder);
    }

    private void convert(ORM_O01_ORDER order) throws HL7Exception
    {
        String[] names = order.getNames();
        for (String name : names)
        {
            Structure structure = order.get(name);
            switch (name)
            {
                case ("ORC"):
                {
                    ORC orc = (ORC) structure;
                    convert(orc);
                    break;
                }
                case ("ORDER_DETAIL"):
                {
                    ORM_O01_ORDER_DETAIL orderDetail = (ORM_O01_ORDER_DETAIL) structure;
                    convert(orderDetail);
                    break;
                }
                case ("FT1"):
                {
                    FT1 ft1 = (FT1) structure;
                    convert(ft1);
                    break;
                }
                case ("CTI"):
                {
                    CTI cti = (CTI) structure;
                    convert(cti);
                    break;
                }
                case ("BLG"):
                {
                    BLG blg = (BLG) structure;
                    convert(blg);
                    break;
                }
            }
        }
    }

    private void convert(BLG blg)
    {

    }

    private void convert(CTI cti)
    {

    }

    private void convert(FT1 ft1)
    {

    }

    private void convert(ORC orc) throws HL7Exception
    {
        new ORCParser().convert(orc, detailedOrderBuilder);
    }

    private void convert(ORM_O01_ORDER_DETAIL orderDetail) throws HL7Exception
    {
        String[] names = orderDetail.getNames();
        for (String name : names)
        {
            Structure structure = orderDetail.get(name);
            switch (name)
            {
                case ("OBR"):
                {
                    OBR obr = (OBR) structure;
                    convert(obr);

                    break;
                }
                case ("OBSERVATION"):
                {
                    ORM_O01_OBSERVATION observation = (ORM_O01_OBSERVATION) structure;
                    convert(observation);

                    break;
                }
                case ("RQ1"):
                {
                    RQ1 rq1 = (RQ1) structure;

                    break;
                }
                case ("RXO"):
                {
                    RXO rxo = (RXO) structure;

                    break;
                }
                case ("ODS"):
                {
                    ODS ods = (ODS) structure;

                    break;
                }
                case ("ODT"):
                {
                    ODT odt = (ODT) structure;

                    break;
                }
                case ("NTE"):
                {
                    NTE nte = (NTE) structure;

                    break;
                }
                case ("CTD"):
                {
                    CTD ctd = (CTD) structure;

                    break;
                }
                case ("DG1"):
                {
                    DG1 dg1 = (DG1) structure;

                    break;
                }
            }
        }
    }

    private void convert(ORM_O01_OBSERVATION observation) throws HL7Exception
    {
        for (String name : observation.getNames())
        {
            Structure structure = observation.get(name);
            switch (name)
            {
                case ("OBX"):
                {
                    OBX obx = (OBX) structure;
                    obxParser.convert(obx, detailedOrderBuilder);

                    break;
                }
                case ("NTE"):
                {
                    break;
                }
            }
        }
    }

    private void convert(OBR obr) throws HL7Exception
    {
        new OBRParser().convert(obr, detailedOrderBuilder);
    }
}
