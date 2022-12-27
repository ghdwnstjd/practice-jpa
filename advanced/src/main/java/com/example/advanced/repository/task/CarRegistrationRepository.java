package com.example.advanced.repository.task;

import com.example.advanced.entity.Car;
import com.example.advanced.entity.task.CarRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRegistrationRepository extends JpaRepository<CarRegistration,Long> {

}
