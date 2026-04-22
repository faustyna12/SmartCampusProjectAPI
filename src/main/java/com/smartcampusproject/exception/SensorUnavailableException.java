/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.exception;

/**
 * w2081508
 * @author faustyna
 */
public class SensorUnavailableException extends RuntimeException{
    public SensorUnavailableException() {
        super("Sensor is currently unavailable (MAINTENANCE mode)."); // default error message
    }
    
}
