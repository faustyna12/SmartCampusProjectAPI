/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusproject.exception;

/**
 * w2081508
 * @author faustyna
 */
public class LinkedResourceNotFoundException extends RuntimeException{
    public LinkedResourceNotFoundException() {
        super("The referenced room does not exist."); // default error message
    }
    
}
