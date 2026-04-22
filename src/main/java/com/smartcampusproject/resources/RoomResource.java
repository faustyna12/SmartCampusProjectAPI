/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.resources;

import com.smartcampusproject.data.DataStore;
import com.smartcampusproject.model.Room;
import com.smartcampusproject.exception.RoomNotEmptyException;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

/**
 * w2081508
 * @author faustyna
 */
public class RoomResource {
    
    @GET 
    public Collection<Room> getRooms() {
        return DataStore.rooms.values();
    }
    // creates a new room

    @POST
    public Response createRoom(Room room) {
        DataStore.rooms.put(room.getId(), room);
        return Response.status(201).entity(room).build();
    }
    // gets a room by id

    @GET
    @Path("/{id}")
    public Room getRoom(@PathParam("id") String id) {
        return DataStore.rooms.get(id);
    }
    // deletes a room by id

    @DELETE
    @Path("/{id}")
    public Response deleteRoom(@PathParam("id") String id) {

        Room room = DataStore.rooms.get(id);

        if (room == null) {
            throw new NotFoundException("Room not found");
        }

        if (room.getSensorIds() != null && !room.getSensorIds().isEmpty()) {
            throw new RoomNotEmptyException();
        }

        DataStore.rooms.remove(id);

        return Response.ok("Room deleted").build();
    }
}
