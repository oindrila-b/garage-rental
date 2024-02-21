package com.example.garagerental.garage.repository;

import com.example.garagerental.garage.models.GarageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageRepository extends JpaRepository<GarageModel, String> {

}
