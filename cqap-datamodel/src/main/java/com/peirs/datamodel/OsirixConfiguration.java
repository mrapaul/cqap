package com.peirs.datamodel;

public class OsirixConfiguration
{
    private String host;
    private int port;
    private String server;

    public OsirixConfiguration()
    {
        // empty
    }

    public OsirixConfiguration(String host,
                               int port,
                               String server)
    {
        super();

        this.host = host;
        this.port = port;
        this.server = server;
    }

    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    public String getServer()
    {
        return server;
    }
    public void setHost(String host)
    {
        this.host = host;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public void setServer(String server)
    {
        this.server = server;
    }

    public String toString()
    {
        return "OsirixConfiguration(" +
                " host: " + getHost() +
                " port: " + getPort() +
                " server: " + getServer() + ")";
    }
}
