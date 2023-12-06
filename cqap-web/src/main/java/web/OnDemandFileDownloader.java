package web;

import com.vaadin.server.*;

import java.io.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class OnDemandFileDownloader extends FileDownloader
{
    public interface OnDemandStreamResource extends StreamResource.StreamSource
    {
        String getFilename();
    }

    private static final long serialVersionUID = 1L;
    private final OnDemandStreamResource onDemandStreamResource;

    public OnDemandFileDownloader(OnDemandStreamResource onDemandStreamResource)
    {
        super(new StreamResource(onDemandStreamResource, ""));
        this.onDemandStreamResource = checkNotNull(onDemandStreamResource,
                "The given on-demand stream resource may never be null!");
    }

    @Override
    public boolean handleConnectorRequest(VaadinRequest request, VaadinResponse response, String path)
    throws IOException
    {
        getResource().setFilename(onDemandStreamResource.getFilename());
        return super.handleConnectorRequest(request, response, path);
    }

    private StreamResource getResource()
    {
        return (StreamResource) this.getResource("dl");
    }

}
