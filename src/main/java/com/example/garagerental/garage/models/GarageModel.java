package com.example.garagerental.garage.models;

import com.example.garagerental.garage.enums.SlotType;
import com.example.garagerental.owner.models.Owner;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GarageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long garageID;
    private String address;
    private Owner owner;
    private String pinCode;
    private SlotType slotType;
    private Integer numberOfSlots;

}
