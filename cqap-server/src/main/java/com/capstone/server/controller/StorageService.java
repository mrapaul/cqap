package com.capstone.server.controller;

import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component("StorageService")
public class StorageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageService.class);

    @Autowired
    private GridFsTemplate gridFsTemplate;

    public void storeImage(DicomImage aImage, File aFile) {
        try (InputStream stream = new FileInputStream(aFile)) {
            Document metadata = new Document("studyInstanceUID", aImage.getStudyInstanceUID());
            gridFsTemplate.store(stream, aFile.getName(), metadata);
        } catch (IOException e) {
            LOGGER.error("Error creating file", e);
        }
    }

    public List<Attachment> getImages(DicomStudy aStudy) {
        List<Attachment> myImages = new ArrayList<>();
        Query query = new Query(Criteria.where("metadata.studyInstanceUID").is(aStudy.getStudyInstanceUID()));
        GridFSFindIterable files = gridFsTemplate.find(query);
        for (GridFSFile file : files) {
            myImages.add(convertToAttachment(file));
        }
        return myImages;
    }

    public void storeAttachment(String aTicketId, String aFileName, byte[] aBytes) {
        Document metadata = new Document("ticketId", new ObjectId(aTicketId));
        try (InputStream stream = new ByteArrayInputStream(aBytes)) {
            gridFsTemplate.store(stream, aFileName, metadata);
        } catch (IOException e) {
            LOGGER.error("Error storing file", e);
        }
    }

    public void storePatientReport(String aStudyId, String aFileName, byte[] aBytes) {
        Document metadata = new Document("studyId", new ObjectId(aStudyId));
        try (InputStream stream = new ByteArrayInputStream(aBytes)) {
            gridFsTemplate.store(stream, aFileName, metadata);
        } catch (IOException e) {
            LOGGER.error("Error storing file", e);
        }
    }

    public List<Attachment> getAttachmentNames(String aTicketId, String aStudyId) {
        List<Attachment> myAttachments = new ArrayList<>();
        Query ticketIdQuery = new Query(Criteria.where("metadata.ticketId").is(new ObjectId(aTicketId)));
        GridFSFindIterable ticketFiles = gridFsTemplate.find(ticketIdQuery);
        for (GridFSFile file : ticketFiles) {
            myAttachments.add(convertToAttachment(file));
        }
        Query studyIdQuery = new Query(Criteria.where("metadata.studyId").is(new ObjectId(aStudyId)));
        GridFSFindIterable studyFiles = gridFsTemplate.find(studyIdQuery);
        for (GridFSFile file : studyFiles) {
            myAttachments.add(convertToAttachment(file));
        }
        return myAttachments;
    }

    public List<Attachment> getAttachments(String aTicketId) {
        List<Attachment> myAttachments = new ArrayList<>();
        Query query = new Query(Criteria.where("metadata.ticketId").is(new ObjectId(aTicketId)));
        GridFSFindIterable files = gridFsTemplate.find(query);
        for (GridFSFile file : files) {
            myAttachments.add(convertToAttachment(file));
        }
        return myAttachments;
    }

    private Attachment convertToAttachment(GridFSFile file) {
        Document metadata = file.getMetadata();
        Object ticketId = metadata != null ? metadata.get("ticketId") : null;
        Object studyId = metadata != null ? metadata.get("studyId") : null;
        return new Attachment(file.getObjectId().toString(),
                ticketId != null ? ticketId.toString() : null,
                studyId != null ? studyId.toString() : null,
                file.getFilename(),
                file.getUploadDate());
    }

    public File getAttachment(String aId) {
        Query query = new Query(Criteria.where("_id").is(new ObjectId(aId)));
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
        if (gridFSFile != null) {
            try {
                String filename = gridFSFile.getFilename();
                File file = File.createTempFile(filename.substring(0, filename.indexOf(".")),
                        filename.substring(filename.indexOf(".")));
                try (OutputStream os = new FileOutputStream(file); InputStream is = gridFsTemplate.getResource(gridFSFile).getInputStream()) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                }
                return file;
            } catch (IOException e) {
                LOGGER.error("Error reading file", e);
            }
        }
        return null;
    }

    public void deleteAttachment(String aId) {
        Query query = new Query(Criteria.where("_id").is(new ObjectId(aId)));
        gridFsTemplate.delete(query);
    }
}
