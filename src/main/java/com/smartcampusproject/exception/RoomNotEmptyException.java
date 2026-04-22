/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.exception;

/**
 * w2081508
 * @author faustyna
 */
public class RoomNotEmptyException extends RuntimeException {
    public RoomNotEmptyException() {
        super("Room cannot be deleted because it still has sensors assigned."); // default error message
    }
    
}
