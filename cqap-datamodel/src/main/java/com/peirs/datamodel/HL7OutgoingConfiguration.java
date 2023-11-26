package com.peirs.datamodel;

public class HL7OutgoingConfiguration
{
    private String host;
    private int port;

    public HL7OutgoingConfiguration()
    {
        // empty
    }

    public HL7OutgoingConfiguration(String host,
                                    int port)
    {
        super();

        this.host = host;
        this.port = port;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String toString()
    {
        return "HL7OutgoingConfiguration(" +
                " host: " + getHost() +
                " port: " + getPort() + ")";
    }

}
