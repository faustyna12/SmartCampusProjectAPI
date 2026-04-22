/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.mappers;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;
import java.util.*;

/**
 * w2081508
 * @author faustyna
 */
@Provider       
public class UniversalExceptionHandlerMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", "Internal Server Error");
        error.put("status", "500"); // default error message
        

        return Response.status(500)
                .entity(error)
                .build();
    }
}
