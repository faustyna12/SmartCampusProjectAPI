/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.filter;
import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * w2081508
 * @author faustyna
 */
@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter { // logs all requests and responses
    private static final Logger logger= Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String method = requestContext.getMethod(); // gets request type
        String uri = requestContext.getUriInfo().getRequestUri().toString(); // gets request URL
        logger.info("Incoming Request: " + method + " " + uri);
    }

  
    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {

        int status = responseContext.getStatus(); // gets response status

        logger.info("Outgoing Response Status: " + status);
    }
    
}
