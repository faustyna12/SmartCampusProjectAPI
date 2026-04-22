/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.mappers;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;
import java.util.*;
import com.smartcampusproject.exception.RoomNotEmptyException;

/**
 * w2081508
 * @author faustyna
 */
@Provider
public class RoomNotEmptyExceptionMapper implements ExceptionMapper<RoomNotEmptyException> {
    @Override
    public Response toResponse(RoomNotEmptyException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", "Room is not empty");
        error.put("message", ex.getMessage());  // default error message

        return Response.status(409)
                .entity(error)
                .build();
    }
    
}
