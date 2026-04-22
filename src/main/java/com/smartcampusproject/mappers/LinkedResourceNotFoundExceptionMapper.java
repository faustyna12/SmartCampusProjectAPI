/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.mappers;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;
import java.util.*;
import com.smartcampusproject.exception.LinkedResourceNotFoundException;

/**
 * w2081508
 * @author faustyna
 */
@Provider
public class LinkedResourceNotFoundExceptionMapper implements ExceptionMapper<LinkedResourceNotFoundException> {
     @Override
    public Response toResponse(LinkedResourceNotFoundException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", "Invalid reference");
        error.put("message", ex.getMessage()); // default error message

        return Response.status(422) 
                .entity(error)
                .build();
    }
    
}
