/*
 * Copyright (c) 2008 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.

 * Author: Dmitry Abramov
 * Created: 19.12.2008 17:24:51
 * $Id$
 */
package com.haulmont.cuba.gui.xml.layout.loaders;

import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.OrderedLayout;
import com.haulmont.cuba.gui.xml.layout.ComponentLoader;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.gui.xml.layout.LayoutLoaderConfig;
import org.dom4j.Element;

import java.util.Collection;

public class VBoxLoader extends ContainerLoader implements ComponentLoader {
    public VBoxLoader(Context context, LayoutLoaderConfig config, ComponentsFactory factory) {
        super(context, config, factory);
    }

    public Component loadComponent(ComponentsFactory factory, Element element) throws InstantiationException, IllegalAccessException {
        final OrderedLayout component = factory.createComponent("vbox");

        assignXmlDescriptor(component, element);
        loadId(component, element);
        loadAlign(component, element);
        loadPack(component, element);

        final Collection<Component> components = loadSubComponents(component, element);
        if (components.size() == 1) component.expand(components.iterator().next(), null, null); 

        loadHeight(component, element);
        loadWidth(component, element);
        
        return component;
    }
}
