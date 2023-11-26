package com.peirs.datamodel;

public class PACS {
    private String host;
    private int port;
    private String aeTitle;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAeTitle() {
        return aeTitle;
    }

    public void setAeTitle(String aeTitle) {
        this.aeTitle = aeTitle;
    }

    public PACS() {
    }

    public PACS(String host, int port, String aeTitle) {
        this.host = host;
        this.port = port;
        this.aeTitle = aeTitle;
    }
}
