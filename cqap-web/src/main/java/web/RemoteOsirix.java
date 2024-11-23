package web;

import com.peirs.datamodel.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;


import java.net.*;
import java.util.*;

public class RemoteOsirix
{
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 11111;
    private static final String SERVER = "DCM4CHEE";
    private final OsirixConfiguration configuration;
    private final XmlRpcClient client;

    public RemoteOsirix(OsirixConfiguration configuration) throws MalformedURLException
    {
        this.configuration = configuration;
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(getURL()));
        client = new XmlRpcClient();
        client.setConfig(config);
    }

    private static String getOsiriXHost(OsirixConfiguration osirixConfiguration)
    {
        return (osirixConfiguration != null && osirixConfiguration.getHost() != null) ?
                osirixConfiguration.getHost() :
                HOST;
    }

    private static int getOsiriXPort(OsirixConfiguration osirixConfiguration)
    {
        return (osirixConfiguration != null && osirixConfiguration.getPort() != 0) ?
                osirixConfiguration.getPort() :
                PORT;
    }

    private String getURL()
    {
        return "http://" + getOsiriXHost(configuration) + ":" + getOsiriXPort(configuration);
    }

    
    public String downloadImages(String accessionNumber) throws XmlRpcException
    {
        ArrayList<Object> params = new ArrayList<>();
        Hashtable<String, Object> methodData = new Hashtable<>();
        methodData.put("accessionNumber", accessionNumber);
        methodData.put("server", getOsiriXServer());
        params.add(methodData);
        Map result = (Map) client.execute("CMove", params);
        return (String) result.get("error");
    }

    
    public String openImageWithStudyInstanceUID(String studyInstanceUID) throws XmlRpcException
    {
        ArrayList<Object> params = new ArrayList<>();
        Hashtable<String, Object> methodData = new Hashtable<>();
        methodData.put("studyInstanceUID", studyInstanceUID);
        params.add(methodData);
        Map result = (Map) client.execute("DisplayStudy", params);
        return (String) result.get("error");
    }

    
    public String openImageWithAccession(String accessionNumber) throws XmlRpcException
    {
        ArrayList<Object> params = new ArrayList<>();
        Hashtable<String, Object> methodData = new Hashtable<>();
        methodData.put("accessionNumber", accessionNumber);
        params.add(methodData);
        Map result = (Map) client.execute("DisplayStudy", params);
        return (String) result.get("error");
    }

    
    public String openImageWithPatientID(String patientID) throws XmlRpcException
    {
        ArrayList<Object> params = new ArrayList<>();
        Hashtable<String, Object> methodData = new Hashtable<>();
        methodData.put("PatientID", patientID);
        params.add(methodData);
        Map result = (Map) client.execute("DisplayStudy", params);
        return (String) result.get("error");
    }

    
    public String closeWindows() throws XmlRpcException
    {
        Map result = (Map) client.execute("CloseAllWindows", new ArrayList());
        return (String) result.get("error");
    }

    private String getOsiriXServer()
    {
        return (configuration.getServer() != null) ? configuration.getServer() : SERVER;
    }
}