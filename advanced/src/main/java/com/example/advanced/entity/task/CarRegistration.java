package com.example.advanced.entity.task;

import com.example.advanced.entity.Period;
import lombok.*;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;

@Entity
@Table(name="TBL_CAR_REGISTRATION")
@Getter @Setter @ToString(exclude = {"car", "carOwner"})
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class CarRegistration extends Period {
    @Id @GeneratedValue
    private Long carRegistrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CAR_ID")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CAR_OWNER_ID")
    private CarOwner carOwner;

    public void changeCar(Car car){this.car = car;}
    public void changeCarOwner(CarOwner carOwner){this.carOwner = carOwner;}
}
