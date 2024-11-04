package com.capstone.fx.controllers;

import com.capstone.fx.components.*;
import com.capstone.fx.controllers.*;
import com.mongodb.gridfs.*;
import com.peirs.datamodel.dicom.*;
import ij.*;
import ij.io.*;
import javafx.application.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.concurrent.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.util.*;

import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ViewerController extends BaseController
{
    private final ExecutorService theService;
    private final ObservableList<ImageAttachment> theImages;
    @FXML ImageView theImage;
    @FXML ListView<ImageAttachment> theImagesList;
    @FXML private ProgressBar theProgress;

    public ViewerController()
    {
        theService = Executors.newSingleThreadExecutor();
        theImages = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize()
    {
        theImagesList.setItems(theImages);
        theImagesList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        theImagesList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ImageAttachment>()
        {
            @Override public void changed(ObservableValue<? extends ImageAttachment> aObservableValue,
                                          ImageAttachment aAttachment,
                                          ImageAttachment aAttachment2)
            {
                showImage();
            }
        });
        theImagesList.setCellFactory(new Callback<ListView<ImageAttachment>, ListCell<ImageAttachment>>()
        {
            @Override public ListCell<ImageAttachment> call(ListView<ImageAttachment> aImageAttachmentListView)
            {
                return new ListCell<ImageAttachment>()
                {
                    @Override protected void updateItem(ImageAttachment aImageAttachment, boolean aEmpty)
                    {
                        super.updateItem(aImageAttachment, aEmpty);

                        if (aImageAttachment != null && !aEmpty)
                        {
                            ImageView myImageView = new ImageView(aImageAttachment.getImage());
                            myImageView.setFitHeight(50);
                            myImageView.setFitWidth(50);
                            setText(aImageAttachment.getFilename());
                            setTextFill(Color.web("white"));
                            setGraphic(myImageView);
                        }
                    }
                };
            }
        });
    }

    private void showImage()
    {
        ImageAttachment myItem = theImagesList.getSelectionModel().getSelectedItem();
        if (myItem != null && myItem.getImage() != null)
        {
            theImage.setImage(myItem.getImage());
        }
    }

    private Image createFile(GridFSDBFile aFile) throws IOException
    {
        Image myImage = null;
        String myFilename = aFile.getFilename();
        File myFile = File.createTempFile(myFilename, "i");
        aFile.writeTo(myFile);
        Opener myOpener = new Opener();
        final ImagePlus imp = myOpener.openImage(myFile.getAbsolutePath());
        if (imp != null)
        {
            BufferedImage myBufferedImage = imp.getBufferedImage();
            myImage = SwingFXUtil.toFXImage(myBufferedImage, new WritableImage(200, 200));

        }
        myFile.delete();
        return myImage;
    }

    public void showImages(final DicomStudy aStudy)
    {
        Task myTask = new Task()
        {
            @Override protected Object call() throws Exception
            {
                updateProgress(ProgressIndicator.INDETERMINATE_PROGRESS, 1);
                try
                {
                    getImageAttachments(aStudy);
                }
                catch (Exception anException)
                {
                    anException.printStackTrace();
                }
                finally
                {
                    updateProgress(1, 1);
                }

                return null;
            }
        };
        theProgress.progressProperty().bind(myTask.progressProperty());
        theService.execute(myTask);
    }

    private synchronized void getImageAttachments(DicomStudy aStudy) throws IOException
    {
        //TODO:
        List<GridFSDBFile> myUnconvertedImages = new ArrayList<>();//getStorageRepository().getUnconvertedImages(aStudy);
        for (GridFSDBFile myUnconvertedImage : myUnconvertedImages)
        {
            final ImageAttachment myAttachment = new ImageAttachment(createFile(myUnconvertedImage),
                    myUnconvertedImage.getFilename(),
                    myUnconvertedImage.getUploadDate());
            Platform.runLater(new Runnable()
            {
                @Override public void run()
                {
                    theImages.add(myAttachment);
                }
            });
        }
    }

    private static class ImageAttachment
    {
        private final Image theImage;
        private final String theFilename;
        private final Date theUploadDate;

        private ImageAttachment(Image aImage, String aFilename, Date aUploadDate)
        {
            theImage = aImage;
            theFilename = aFilename;
            theUploadDate = aUploadDate;
        }

        private Image getImage()
        {
            return theImage;
        }

        private String getFilename()
        {
            return theFilename;
        }

        private Date getUploadDate()
        {
            return theUploadDate;
        }
    }
}
