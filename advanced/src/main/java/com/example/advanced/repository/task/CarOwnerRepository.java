package com.example.advanced.repository.task;

import com.example.advanced.entity.Car;
import com.example.advanced.entity.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerRepository extends JpaRepository<CarOwner,Long> {
        
}
