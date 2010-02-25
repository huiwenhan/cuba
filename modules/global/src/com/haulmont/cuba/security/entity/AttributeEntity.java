/*
 * Copyright (c) 2008 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.

 * Author: Maksim Tulupov
 * Created: 15.02.2010 11:53:35
 *
 * $Id$
 */
package com.haulmont.cuba.security.entity;

public interface AttributeEntity {

    public AttributeType getAttributeType();
    public void setAttributeType(AttributeType attrType);

    public String getMetaClassName();
    public void setMetaClassName(String name);

    public String getDisplayName();
    public void setDisplayName(String value);

    public String getName();
    public void setName(String name);

    public Boolean getMandatory();
    public void setMandatory(Boolean mandatory);

    public String getDefaultValue();
    public void setDefaultValue(String value);

    public String getWhereCondition();
    public void setWhereCondition(String condition);
    
}
