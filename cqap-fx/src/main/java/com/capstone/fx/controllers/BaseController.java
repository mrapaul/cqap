package com.capstone.fx.controllers;

import com.capstone.fx.*;
import com.capstone.fx.model.*;
import com.cqap.client.*;
import com.peirs.datamodel.*;
import javafx.fxml.*;
import javafx.scene.layout.*;

public abstract class BaseController extends StackPane
{
    protected Main theMain;
    protected User theUser;
    private EntityCache theEntityCache;
    private ClientRestService theClientService;

    public void setMainApp(Main aMain)
    {
        theMain = aMain;
    }

    public void setUser(User aUser)
    {
        theUser = aUser;
    }

    @FXML
    public void onHome()
    {
        theMain.showDashboard();
    }

    public void setEntityCache(EntityCache aEntityCache)
    {
        theEntityCache = aEntityCache;
    }

    public EntityCache getEntityCache()
    {
        return theEntityCache;
    }

    public void setClientService(ClientRestService aClientService)
    {
        theClientService = aClientService;
    }

    public ClientRestService getClientService()
    {
        return theClientService;
    }
}
