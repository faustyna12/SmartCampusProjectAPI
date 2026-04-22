/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.resources;

import com.smartcampusproject.data.DataStore;
import com.smartcampusproject.model.Sensor;
import com.smartcampusproject.model.Room;
import com.smartcampusproject.exception.LinkedResourceNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;
import java.util.stream.Collectors;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

/**
 * w2081508
 * @author faustyna
 */
public class SensorResource {

    @GET
    public Collection<Sensor> getSensors(@QueryParam("type") String type) {

        if (type == null) {
            return DataStore.sensors.values();
        }

        return DataStore.sensors.values().stream()
                .filter(s -> s.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
    // creates a new sensor

    @POST
    public Response createSensor(Sensor sensor) {

        if (sensor == null || sensor.getId() == null || sensor.getRoomId() == null) {
            throw new BadRequestException("Invalid sensor data");
        }

        if (DataStore.sensors.containsKey(sensor.getId())) {
            throw new BadRequestException("Sensor already exists");
        }

        Room room = DataStore.rooms.get(sensor.getRoomId());

        if (room == null) {
            throw new LinkedResourceNotFoundException();
        }

        DataStore.sensors.put(sensor.getId(), sensor);
        room.getSensorIds().add(sensor.getId());

        return Response.status(201).entity(sensor).build();
    }
    // sensor readings
    
    @Path("/{id}/readings")
    public SensorReadingResource getReadingResource(@PathParam("id") String id) {
        return new SensorReadingResource(id);
    }
}
