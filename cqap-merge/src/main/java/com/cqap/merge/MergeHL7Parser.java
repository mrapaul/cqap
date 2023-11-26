package com.cqap.merge;

import com.merge.HL7.*;
import com.peirs.datamodel.hl7.*;

public class MergeHL7Parser
{
    public HL7 parse(String aMessage)
    {
        HL7Message myMessage = new HL7Message(aMessage);
        HL7Toolkit.HL7Version myVersion = myMessage.getMSH().getHL7Version();

        switch (myVersion)
        {
            case v231:
            {
                MergeV231Parser myParser = new MergeV231Parser();
                return myParser.parse(myMessage);
            }
        }
        return null;
    }
}
