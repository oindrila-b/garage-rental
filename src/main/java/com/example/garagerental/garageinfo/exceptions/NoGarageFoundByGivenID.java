package com.example.garagerental.garageinfo.exceptions;

public class NoGarageFoundByGivenID extends Exception {
    public NoGarageFoundByGivenID(Long id) {
        super("No Garage Found with ID " + id);
    }
}
