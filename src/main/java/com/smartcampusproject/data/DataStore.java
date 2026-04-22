/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.data;
import com.smartcampusproject.model.Room;
import com.smartcampusproject.model.Sensor;
import com.smartcampusproject.model.SensorReading;
import java.util.*;

/**
 *
 * w2081508
 * @author faustyna
 */
public class DataStore {
    public static Map<String, Room> rooms = new HashMap<>(); //stores all rooms
    public static Map<String, Sensor> sensors = new HashMap<>(); //stores all sensors
    public static Map<String, List<SensorReading>> readings = new HashMap<>(); // stores all sensor readings
}
