package com.example.advanced.entity.task;

import com.example.advanced.embeddable.Address;
import com.example.advanced.entity.Period;
import com.example.advanced.type.CarBrand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_CAR")
@Getter @Setter @ToString
public class CarOwner extends Period {

    @Id
    @GeneratedValue
    private Long carOwnerId;
    private String carOwnerName;
    private int carOwnerAge;
    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy= "carOwner")
    private List<CarRegistration> carRegistrations;

    public void create(String carOwnerName, int carOwnerAge, Address address) {
        this.carOwnerName = carOwnerName;
        this.carOwnerAge = carOwnerAge;
        this.address = address;
    }
}
