package com.capstone.server.controller;

import com.mongodb.*;
import com.mongodb.gridfs.*;
import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import org.apache.commons.io.*;
import org.bson.types.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

@Component("StorageService")
public class StorageService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageService.class);
    @Autowired private MongoTemplate theMongoTemplate;
    private GridFS theGridFS;


    public void storeImage(DicomImage aImage, File aFile)
    {
        theGridFS = new GridFS(theMongoTemplate.getDb());
        try
        {
            GridFSInputFile myInputFile = theGridFS.createFile(aFile);
            myInputFile.setFilename(aFile.getAbsoluteFile().getName());
            DBObject myObject = new BasicDBObject();
            myObject.put("studyInstanceUID", aImage.getStudyInstanceUID());
            myInputFile.setMetaData(myObject);
            myInputFile.save();
        }
        catch (IOException e)
        {
            LOGGER.error("Error creating file", e);
        }
    }

    public List<Attachment> getImages(DicomStudy aStudy)
    {
        List<Attachment> myImages = new ArrayList<>();
        try
        {
            convert(myImages, getUnconvertedImages(aStudy));
        }
        catch (IOException e)
        {
            LOGGER.error("Error reading file", e);
        }
        return myImages;
    }

    public List<GridFSDBFile> getUnconvertedImages(DicomStudy aStudy)
    {
        theGridFS = new GridFS(theMongoTemplate.getDb());
        DBObject myObject = new BasicDBObject();
        myObject.put("metadata.studyInstanceUID", aStudy.getStudyInstanceUID());
        return theGridFS.find(myObject);
    }

    public void storeAttachment(String aTicketId, String aFileName, byte[] aBytes)
    {
        DBObject myObject = new BasicDBObject();
        myObject.put("ticketId", new ObjectId(aTicketId));
        storeFile(myObject, aFileName, aBytes);
    }

    public void storePatientReport(String aStudyId, String aFileName, byte[] aBytes)
    {
        DBObject myObject = new BasicDBObject();
        myObject.put("studyId", new ObjectId(aStudyId));
        storeFile(myObject, aFileName, aBytes);
    }

    private void storeFile(DBObject aMetadata, String aFileName, byte[] aBytes)
    {
        theGridFS = new GridFS(theMongoTemplate.getDb());
        GridFSInputFile myInputFile = theGridFS.createFile(aBytes);
        myInputFile.setFilename(aFileName);
        myInputFile.setMetaData(aMetadata);
        myInputFile.save();
    }

    public List<Attachment> getAttachmentNames(String aTicketId, String aStudyId)
    {
        List<Attachment> myAttachments = new ArrayList<>();
        theGridFS = new GridFS(theMongoTemplate.getDb());
        DBObject myObject = new BasicDBObject();
        myObject.put("metadata.ticketId", new ObjectId(aTicketId));
        findFiles(aTicketId, aStudyId, myAttachments, myObject);
        myObject = new BasicDBObject();
        myObject.put("metadata.studyId", new ObjectId(aStudyId));
        findFiles(aTicketId, aStudyId, myAttachments, myObject);
        return myAttachments;
    }

    private void findFiles(String aTicketId, String aStudyId, List<Attachment> aAttachments, DBObject aObject)
    {
        List<GridFSDBFile> myFiles = theGridFS.find(aObject);
        for (GridFSDBFile myFile : myFiles)
        {
            aAttachments.add(new Attachment(myFile.getId().toString(),
                    aTicketId,
                    aStudyId,
                    myFile.getFilename(),
                    myFile.getUploadDate()));
        }
    }


    public List<Attachment> getAttachments(String aTicketId)
    {
        List<Attachment> myAttachments = new ArrayList<>();
        theGridFS = new GridFS(theMongoTemplate.getDb());
        try
        {
            DBObject myObject = new BasicDBObject();
            myObject.put("metadata.ticketId", new ObjectId(aTicketId));
            convert(myAttachments, theGridFS.find(myObject));
        }
        catch (IOException e)
        {
            LOGGER.error("Error reading file", e);
        }
        return myAttachments;
    }

    private void convert(List<Attachment> aImages, List<GridFSDBFile> aFiles) throws IOException
    {
        for (GridFSDBFile myFile : aFiles)
        {
            aImages.add(createAttachment(myFile));
        }
    }

    private Attachment createAttachment(GridFSDBFile aFile) throws IOException
    {
        ByteArrayOutputStream myOutputStream = new ByteArrayOutputStream();
        aFile.writeTo(myOutputStream);
        Object myTicketId = aFile.getMetaData().get("ticketId");
        Object myStudyId = aFile.getMetaData().get("studyId");
        return new Attachment(aFile.getId().toString(),
                myTicketId != null ? myTicketId.toString() : null,
                myStudyId != null ? myStudyId.toString() : null,
                aFile.getFilename(),
                aFile.getUploadDate());
    }

    public File getAttachment(String aId)
    {
        theGridFS = new GridFS(theMongoTemplate.getDb());
        try
        {
            GridFSDBFile myGridFSDBFile = theGridFS.findOne(new ObjectId(aId));
            if (myGridFSDBFile != null)
            {
                ByteArrayOutputStream myOutputStream = new ByteArrayOutputStream();
                myGridFSDBFile.writeTo(myOutputStream);
                File myFile = new File(myGridFSDBFile.getFilename());
                FileUtils.writeByteArrayToFile(myFile, myOutputStream.toByteArray());
                return myFile;
            }
        }
        catch (IOException e)
        {
            LOGGER.error("Error reading file", e);
        }

        return null;
    }

    public void deleteAttachment(String aId)
    {
        theGridFS.remove(new ObjectId(aId));
    }
}
