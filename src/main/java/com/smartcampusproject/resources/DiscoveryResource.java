/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

/**
 * w2081508
 * @author faustyna
 */
@Path("/") // root endpoint
@Produces(MediaType.APPLICATION_JSON)
public class DiscoveryResource {

    @GET
    public Response getInfo() {

        Map<String, Object> response = new HashMap<>(); // stores the response data

        response.put("version", "v1");
        response.put("contact", "admin@uni.com");

        Map<String, String> links = new HashMap<>(); // creates map for link
        links.put("rooms", "/api/v1/rooms");
        links.put("sensors", "/api/v1/sensors");

        response.put("resources", links);

        return Response.ok(response).build(); // returns response as JSON
    }
}
