package com.example.advanced.entity.task;


import com.example.advanced.embeddable.Address;
import com.example.advanced.repository.task.CarOwnerRepository;
import com.example.advanced.repository.task.CarRegistrationRepository;
import com.example.advanced.repository.task.CarRepository;
import com.example.advanced.type.CarBrand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CarTest {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    @Autowired
    private CarRegistrationRepository carRegistrationRepository;

    @Test
    public void saveTest(){

        Car car = new Car();
        CarOwner carOwner = new CarOwner();
        Address address = new Address();

        car.create(CarBrand.MCLAREN, "맥라렌", "빨강", 500_000_000L, LocalDateTime.of(2022,10,24,0,0));
        address.create("13607", "경기도", "성남시 분당구");
        carOwner.create("홍준성", 31, address);

/*        carRepository.save(car);
        carOwnerRepository.save(carOwner);*/
    }
}
