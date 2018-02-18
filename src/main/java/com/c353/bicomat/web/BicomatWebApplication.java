/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.web;

import com.giffing.wicket.spring.boot.context.extensions.ApplicationInitExtension;
import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;
import org.apache.wicket.protocol.http.WebApplication;

@ApplicationInitExtension
public class BicomatWebApplication implements WicketApplicationInitConfiguration {

    private static final String DEFAULT_ENCODING = "utf-8";

    @Override
    public void init(WebApplication webApplication) {
        webApplication.getMarkupSettings().setDefaultMarkupEncoding(DEFAULT_ENCODING);
        webApplication.getRequestCycleSettings().setResponseRequestEncoding(DEFAULT_ENCODING);
        webApplication.getMarkupSettings().setStripWicketTags(true);
        webApplication.getMarkupSettings().setStripComments(true);
        webApplication.getMarkupSettings().setCompressWhitespace(true);
    }
}
