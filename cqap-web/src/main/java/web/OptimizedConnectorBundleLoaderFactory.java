package web;

import com.google.gwt.core.ext.typeinfo.*;
import com.vaadin.client.ui.button.*;
import com.vaadin.client.ui.csslayout.*;
import com.vaadin.client.ui.label.*;
import com.vaadin.client.ui.orderedlayout.*;
import com.vaadin.client.ui.panel.*;
import com.vaadin.client.ui.passwordfield.*;
import com.vaadin.client.ui.textfield.*;
import com.vaadin.client.ui.ui.*;
import com.vaadin.client.ui.window.*;
import com.vaadin.server.widgetsetutils.*;
import com.vaadin.shared.ui.*;

import java.util.*;

public final class OptimizedConnectorBundleLoaderFactory extends
        ConnectorBundleLoaderFactory
{
    private final Set<String> eagerConnectors = new HashSet<String>();
    {
        eagerConnectors.add(PasswordFieldConnector.class.getName());
        eagerConnectors.add(VerticalLayoutConnector.class.getName());
        eagerConnectors.add(HorizontalLayoutConnector.class.getName());
        eagerConnectors.add(ButtonConnector.class.getName());
        eagerConnectors.add(UIConnector.class.getName());
        eagerConnectors.add(CssLayoutConnector.class.getName());
        eagerConnectors.add(TextFieldConnector.class.getName());
        eagerConnectors.add(PanelConnector.class.getName());
        eagerConnectors.add(LabelConnector.class.getName());
        eagerConnectors.add(WindowConnector.class.getName());
    }

    @Override
    protected Connect.LoadStyle getLoadStyle(final JClassType connectorType) {
        if (eagerConnectors.contains(connectorType.getQualifiedBinaryName())) {
            return Connect.LoadStyle.EAGER;
        } else {
            // Loads all other connectors immediately after the initial view has
            // been rendered
            return Connect.LoadStyle.DEFERRED;
        }
    }
}
