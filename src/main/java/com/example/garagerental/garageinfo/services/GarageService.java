package com.example.garagerental.garageinfo.services;

import com.example.garagerental.garageinfo.exceptions.NoGarageFoundByGivenID;
import com.example.garagerental.garageinfo.models.Garage;
import com.example.garagerental.garageinfo.repository.GarageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GarageService {

    @Autowired
    private GarageRepository garageRepository;

    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    public Long saveGarageInfo(Garage garage) {
         Garage id = garageRepository.save(garage);
        return id.getGarageID();
    }

    public Optional<Garage> getOneGarage(Long garageID) throws NoGarageFoundByGivenID {
        try {
            if(garageRepository.existsById(garageID)) {
                log.info("Garage with ID : {} exists" , garageID);
                return garageRepository.findById(garageID);
            }
            return Optional.empty();
        }catch (Exception e) {
            throw new NoGarageFoundByGivenID(garageID);
        }
    }

    public Optional<Garage> deleteGarageByID(Long id) throws NoGarageFoundByGivenID {
        try {
            if(garageRepository.existsById(id)) {
                log.info("Garage with ID : {} exists" , id);
                garageRepository.deleteById(id);
                return garageRepository.findById(id);
            }
            return Optional.empty();
        }catch (Exception e) {
            throw new NoGarageFoundByGivenID(id);
        }
    }



}
