package com.peirs.datamodel;

import java.util.ArrayList;
import java.util.Collection;

public class PACSs {

    private Collection<PACS> aPacss;

    public PACSs() {
        aPacss = new ArrayList<>();
    }

    public PACSs(Collection<PACS> aPacss) {
        this.aPacss = aPacss;
    }
}
