package com.example.garagerental.garageinfo.repository;

import com.example.garagerental.garageinfo.models.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GarageRepository extends JpaRepository<Garage, Long > {


}
