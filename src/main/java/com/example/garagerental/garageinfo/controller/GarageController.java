package com.example.garagerental.garageinfo.controller;


import com.example.garagerental.garageinfo.exceptions.NoGarageFoundByGivenID;
import com.example.garagerental.garageinfo.exceptions.NoGaragesEntriesFoundException;
import com.example.garagerental.garageinfo.models.Garage;
import com.example.garagerental.garageinfo.services.GarageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/api/v1/garages")
@Slf4j
//@CrossOrigin(value = "https://localhost:3000")
public class GarageController {

    @Autowired
    private GarageService garageService;

    @GetMapping()
    public ResponseEntity<List<Garage>> getAllGarage() throws NoGaragesEntriesFoundException {
        log.info("Here");
        try {
            return new ResponseEntity<>(garageService.getAllGarages(), HttpStatus.OK);
        } catch (Exception e) {
            throw new NoGaragesEntriesFoundException();
        }
    }

    @PostMapping(path = "/add-garage")
    public Long addNewGarage(@RequestBody Garage garage) {
        return garageService.saveGarageInfo(garage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Garage> getOneGarage(@PathVariable Long id) throws NoGarageFoundByGivenID {
        log.info("Received garage id : {} ", id );
        Optional<Garage> garage = garageService.getOneGarage(id);
        if(garage.isPresent()) {
            return new ResponseEntity<>( garage.get(), HttpStatus.OK);
        }else {
            throw  new NoGarageFoundByGivenID(id);
        }
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Optional<Garage>> deleteGarageByID(@PathVariable("id") Long id) throws NoGarageFoundByGivenID{
        log.info("Received garage id : {} ", id );
         return  new ResponseEntity<>(garageService.deleteGarageByID(id), HttpStatus.OK );

    }


}
