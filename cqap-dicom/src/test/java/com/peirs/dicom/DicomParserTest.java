package com.peirs.dicom;

import com.peirs.datamodel.dicom.*;
import ij.*;
import ij.io.*;
import org.junit.*;

import javax.imageio.*;
import javax.imageio.ImageReader;
import javax.imageio.stream.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.util.*;

//@Ignore
public class DicomParserTest
{
    @Ignore @Test
    public void search() throws Exception
    {
//        DicomImageRepository myRepository = new DicomImageRepository();
//
//        List<DicomImage> myImages = myRepository.byPatientName("DIONNE", "WATTS");
//
//        for (DicomImage myImage : myImages)
//        {
//            System.out.println(myImage);
//        }
    }
//
//    @Ignore
//    @Test
//    public void insertHealthcareSegments() throws Exception
//    {
//        File myFile = new File(getClass().getClassLoader().getResource("test.txt").getPath());
//
//        byte[] myBytes = IOUtils.toByteArray(new FileInputStream(myFile));
//        String myString = new String(myBytes);
//        String[] mySplit = myString.split("\n");
//        ConfigurableApplicationContext
//                context = new AnnotationConfigApplicationContext("com.peirs");
//
//        HealthcareSegmentRepository myRepository = context.getBean(HealthcareSegmentRepository.class);
//        for (String s : mySplit)
//        {
//            HealthcareSegment mySegment = new HealthcareSegment();
//            mySegment.setName(s);
//            myRepository.insert(mySegment);
//        }
//    }

//    @Ignore
//    @Test
//    public void testName() throws Exception
//    {
//        ImageIO.scanForPlugins();
//        Iterator<ImageReader> myReaders = ImageIO.getImageReadersByFormatName("DICOM");
//        while (myReaders.hasNext())
//        {
//            ImageReader reader = myReaders.next();
//            if (reader == null)
//            {
//                System.out.println("Could not locate any Readers for the DICOM format image.");
//                return;
//            }
//
//            File sourceFile = new File(getClass().getClassLoader().getResource("images/IM000001").getPath());
//            ImageInputStream iis = ImageIO.createImageInputStream(sourceFile);
//            BufferedImage bi;
//            try
//            {
//                bi = ImageIO.read(iis);
//                ImageIcon myIcon = new ImageIcon(bi);
//                JLabel myLabel = new JLabel(myIcon);
//                JFrame myFrame = new JFrame();
//                myFrame.getContentPane().add(myLabel);
//                myFrame.setSize(200, 300);
//                myFrame.setVisible(true);
//                File outputFile = new File("outputFileName");
//                String format = "jpeg 2000";
//                ImageIO.write(bi, format, outputFile);
//            }
//            catch (Exception e)
//            {
//                System.out.println("ERROR: " + e);
//            }
//            finally
//            {
//                iis.close();
//            }
//        }
//    }

    @Ignore
    @Test
    public void imageJ() throws Exception
    {
        File file = new File(getClass().getClassLoader().getResource("images/IM-0001-0001.dcm").getPath());

        // open a file with ImageJ
        Opener myOpener = new Opener();
        final ImagePlus imp = myOpener.openImage(file.getAbsolutePath());
        // display it via ImageJ
        imp.show();

        Thread.sleep(10000);
    }

//    @Ignore
//    @Test
//    public void createZip() throws Exception
//    {
//        ConfigurableApplicationContext
//                context = new AnnotationConfigApplicationContext("com.peirs");
//
//        DicomImageRepository myRepository = context.getBean(DicomImageRepository.class);
//        List<DicomImage> myImages = myRepository.select();
//        Set<String> myUniqueStudyIds = Sets.newHashSet();
//        for (DicomImage myImage : myImages)
//        {
//            myUniqueStudyIds.add(myImage.getStudyInstanceUID());
//        }
//
//        StorageRepository myStorageRepository = context.getBean(StorageRepository.class);
//        for (String myUniqueStudyId : myUniqueStudyIds)
//        {
//            DicomStudy myStudy = new DicomStudy();
//            myStudy.setStudyInstanceUID(myUniqueStudyId);
//            List<GridFSDBFile> myUnconvertedImages = myStorageRepository.getUnconvertedImages(myStudy);
//            File myFile = new File(myUniqueStudyId + ".zip");
//            OutputStream zip_output = new FileOutputStream(myFile);
//            ArchiveOutputStream
//                    logical_zip =
//                    new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP,
//                            zip_output);
//
//            for (GridFSDBFile myUnconvertedImage : myUnconvertedImages)
//            {
//                /* Create Archieve entry - write header information*/
//                logical_zip.putArchiveEntry(new ZipArchiveEntry(myUnconvertedImage.getFilename()));
//                /* Copy input file */
//                IOUtils.copy(myUnconvertedImage.getInputStream(), logical_zip);
//                /* Close Archieve entry, write trailer information */
//                logical_zip.closeArchiveEntry();
//            }
//            /* Finish addition of entries to the file */
//            logical_zip.finish();
//                /* Close output stream, our files are zipped */
//            zip_output.close();
//        }
//    }

//        @Ignore
    @Test
    public void test()
    {
//        ConfigurableApplicationContext
//                context = new AnnotationConfigApplicationContext("com.peirs");
//
//        DicomImageRepository personRepository = context.getBean(DicomImageRepository.class);
//
//        // cleanup person collection before insertion
//        personRepository.dropCollection();
//
//        //create person collection
//        personRepository.createCollection();
//
//        for (int i = 1; i < 9; i++)
//        {
//            URL myResource = getClass().getClassLoader().getResource("images/IM00000" + i);
//
//            DicomParser myParser = new DicomParser();
//            DicomImage myStudy = myParser.parse(new File(myResource.getPath()));
//
//            personRepository.insert(myStudy);
//        }

        URL myResource = getClass().getClassLoader().getResource("images/739699.dcm");

        DicomParser myParser = new DicomParser();
        DicomImage myStudy = myParser.parse(new File(myResource.getPath()));
        System.out.println(myStudy);
    }

//    @Ignore
//    @Test
//    public void jpegToDicom() throws Exception
//    {
//        URL myResource = getClass().getClassLoader().getResource("images/Taylor^Robert.jpg");
//
//        File jpgSource = FileUtils.toFile(myResource);
//        File dcmDestination = new File("picture.dcm");
//
//        try
//        {
//            BufferedImage jpegImage = ImageIO.read(jpgSource);
//            if (jpegImage == null)
//            {
//                throw new Exception("Invalid file.");
//            }
//
//            int colorComponents = jpegImage.getColorModel().getNumColorComponents();
//            int bitsPerPixel = jpegImage.getColorModel().getPixelSize();
//            int bitsAllocated = (bitsPerPixel / colorComponents);
//            int samplesPerPixel = colorComponents;
//            DicomObject dicom = new BasicDicomObject();
//            dicom.putString(Tag.SpecificCharacterSet, VR.CS, "ISO_IR 100");
//            dicom.putString(Tag.PhotometricInterpretation,
//                    VR.CS,
//                    samplesPerPixel == 3 ? "YBR_FULL_422" : "MONOCHROME2");
//            dicom.putInt(Tag.SamplesPerPixel, VR.US, samplesPerPixel);
//            dicom.putInt(Tag.Rows, VR.US, jpegImage.getHeight());
//            dicom.putInt(Tag.Columns, VR.US, jpegImage.getWidth());
//            dicom.putInt(Tag.BitsAllocated, VR.US, bitsAllocated);
//            dicom.putInt(Tag.BitsStored, VR.US, bitsAllocated);
//            dicom.putInt(Tag.HighBit, VR.US, bitsAllocated - 1);
//            dicom.putInt(Tag.PixelRepresentation, VR.US, 0);
//            dicom.putDate(Tag.InstanceCreationDate, VR.DA, new Date());
//            dicom.putDate(Tag.InstanceCreationTime, VR.TM, new Date());
//            dicom.putString(Tag.StudyInstanceUID, VR.UI, UIDUtils.createUID());
//            dicom.putString(Tag.SeriesInstanceUID, VR.UI, UIDUtils.createUID());
//            dicom.putString(Tag.SOPInstanceUID, VR.UI, UIDUtils.createUID());
//            dicom.initFileMetaInformation(UID.JPEGBaseline1);
//            FileOutputStream fos = new FileOutputStream(dcmDestination);
//            BufferedOutputStream bos = new BufferedOutputStream(fos);
//            DicomOutputStream dos = new DicomOutputStream(bos);
//            dos.writeDicomFile(dicom);
//            dos.writeHeader(Tag.PixelData, VR.OB, -1);
//            dos.writeHeader(Tag.Item, null, 0);
//            int jpgLen = (int) jpgSource.length();
//            dos.writeHeader(Tag.Item, null, (jpgLen + 1) & ~1);
//            FileInputStream fis = new FileInputStream(jpgSource);
//            BufferedInputStream bis = new BufferedInputStream(fis);
//            DataInputStream dis = new DataInputStream(bis);
//
//            byte[] buffer = new byte[65536];
//            int b;
//            while ((b = dis.read(buffer)) > 0)
//            {
//                dos.write(buffer, 0, b);
//            }
//            /*
//   According to Gunter from dcm4che team we have to take care that
//   the pixel data fragment length containing the JPEG stream has
//   an even length. So if needed the line below pads JPEG stream with
//   odd length with 0 byte.
//   */
//            if ((jpgLen & 1) != 0)
//            {
//                dos.write(0);
//            }
//            dos.writeHeader(Tag.SequenceDelimitationItem, null, 0);
//            dos.close();
//        }
//        catch (Exception e)
//        {
//            System.out.println("ERROR: " + e.getMessage());
//        }
//    }
}
