package com.lakeland.hl7.datamodel;



public interface HL7Visitable
{
    void accept(HL7Visitor aVisitor);
}