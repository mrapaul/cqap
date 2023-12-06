package web;

import com.cqap.client.*;
import com.google.common.base.*;
import org.springframework.context.annotation.*;

public class ClientRestServiceSupplier implements Supplier<ClientRestService>
{
    private final AnnotationConfigApplicationContext applicationContext;

    public ClientRestServiceSupplier()
    {
        applicationContext = new AnnotationConfigApplicationContext(ClientServiceProvider.class);
    }

    @Override public ClientRestService get()
    {
        return applicationContext.getBean(ClientRestService.class);
    }

    public void dispose()
    {
        applicationContext.close();
    }
}
