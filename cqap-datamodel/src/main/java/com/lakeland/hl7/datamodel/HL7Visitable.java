package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;

public interface HL7Visitable
{
    void accept(@NotNull HL7Visitor aVisitor);
}