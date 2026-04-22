/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.mappers;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;
import java.util.*;
import com.smartcampusproject.exception.SensorUnavailableException;
/**
 * w2081508
 * @author faustyna
 */
@Provider
public class SensorUnavailableExceptionMapper implements ExceptionMapper<SensorUnavailableException> {
    @Override
    public Response toResponse(SensorUnavailableException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", "Sensor unavailable");
        error.put("message", ex.getMessage());  // default error message

        return Response.status(403)
                .entity(error)
                .build();
    }
}
