/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.cuba.web.sys;

import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.core.sys.AbstractUserSessionSource;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.SecurityContext;
import com.haulmont.cuba.security.app.UserSessionService;
import com.haulmont.cuba.security.global.UserSession;
//import com.haulmont.cuba.web.AppUI;

import javax.annotation.ManagedBean;

/**
 * @author krivopustov
 * @version $Id$
 */
@ManagedBean(UserSessionSource.NAME)
public class WebUserSessionSource extends AbstractUserSessionSource {
    private UserSessionService userSessionService;

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean checkCurrentUserSession() {
        /*if (AppUI.isBound())
            return AppUI.getInstance().getConnection().isConnected() && AppUI.getInstance().getConnection().getSession() != null;
        else {*/
            SecurityContext securityContext = AppContext.getSecurityContext();
            if (securityContext == null)
                return false;

            if (securityContext.getSession() != null)
                return true;
            else {
                try {
                    userSessionService.getUserSession(securityContext.getSessionId());
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
//        }
    }

    @Override
    public UserSession getUserSession() {
        /*if (AppUI.isBound())
            return AppUI.getInstance().getConnection().getSession();
        else {*/
            SecurityContext securityContext = AppContext.getSecurityContext();
            if (securityContext == null)
                throw new IllegalStateException("No security context bound to the current thread");

            if (securityContext.getSession() != null)
                return securityContext.getSession();
            else {
                return userSessionService.getUserSession(securityContext.getSessionId());
            }
//        }
    }
}