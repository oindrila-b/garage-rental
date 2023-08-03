package com.example.garagerental.garageinfo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OWNER_ID")
    private Long ownerId;
    private String garageOwnerName;
    private String garageOwnerPhoneNumber;
    private String garageOwnerEmail;
    private String garageOwnerAddress;

}
