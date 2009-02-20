/*
 * Copyright (c) 2008 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.

 * Author: Dmitry Abramov
 * Created: 19.12.2008 17:20:39
 * $Id$
 */
package com.haulmont.cuba.web.gui.components;

import com.haulmont.cuba.gui.components.Component;

public class HBoxLayout extends AbstractContainer implements com.haulmont.cuba.gui.components.OrderedLayout {
    @Override
    public String getTag() {
        return "horizontallayout";
    }

    public void expand(Component component, String height, String width) {
        throw new UnsupportedOperationException();
    }
}