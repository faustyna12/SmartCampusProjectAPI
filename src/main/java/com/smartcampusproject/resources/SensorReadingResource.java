/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.resources;
import com.smartcampusproject.data.DataStore;
import com.smartcampusproject.model.Sensor;
import com.smartcampusproject.model.SensorReading;
import com.smartcampusproject.exception.SensorUnavailableException;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

/**
 * w2081508
 * @author faustyna
 */
public class SensorReadingResource {
    private String sensorId;
     public SensorReadingResource(String sensorId) { // contructor
        this.sensorId = sensorId;
    }
    // gets all readings from a sensor
     
    @GET
    public List<SensorReading> getReadings() {

        List<SensorReading> readings = DataStore.readings.get(sensorId);

        if (readings == null) {
            return new ArrayList<>();
        }
        return readings;
    }
    // adds a new sensor reading
    
    @POST
    public Response addReading(SensorReading reading) {

        Sensor sensor = DataStore.sensors.get(sensorId);

        if (sensor == null) {
            throw new NotFoundException("Sensor not found");
        }

        if ("MAINTENANCE".equalsIgnoreCase(sensor.getStatus())) {
            throw new SensorUnavailableException();
        }
    
        DataStore.readings
                .computeIfAbsent(sensorId, k -> new ArrayList<>())
                .add(reading);

        sensor.setCurrentValue(reading.getValue());

        return Response.status(201).entity(reading).build();
    }
}
