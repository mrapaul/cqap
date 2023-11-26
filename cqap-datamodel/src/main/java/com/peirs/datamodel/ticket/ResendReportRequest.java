package com.peirs.datamodel.ticket;

import com.peirs.datamodel.User;

public class ResendReportRequest {
    private ProfessionalTicket ticket;
    private User user;
    private String addresses;
    private boolean erpReport;
    private boolean erpSiteCallReport;
    private boolean cmoReport;
    private boolean cmoSiteCallReport;
    private boolean techReport;

    // Getters and setters for all fields
    public ProfessionalTicket getTicket() {
        return ticket;
    }

    public void setTicket(ProfessionalTicket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public boolean isERPReport() {
        return erpReport;
    }

    public void setERPReport(boolean erpReport) {
        this.erpReport = erpReport;
    }

    public boolean isERPSiteCallReport() {
        return erpSiteCallReport;
    }

    public void setERPSiteCallReport(boolean erpSiteCallReport) {
        this.erpSiteCallReport = erpSiteCallReport;
    }

    public boolean isCMOReport() {
        return cmoReport;
    }

    public void setCMOReport(boolean cmoReport) {
        this.cmoReport = cmoReport;
    }

    public boolean isCMOSiteCallReport() {
        return cmoSiteCallReport;
    }

    public void setCMOSiteCallReport(boolean cmoSiteCallReport) {
        this.cmoSiteCallReport = cmoSiteCallReport;
    }

    public boolean isTechReport() {
        return techReport;
    }

    public void setTechReport(boolean techReport) {
        this.techReport = techReport;
    }
}

