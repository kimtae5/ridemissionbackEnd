package com.kt5.ridemission.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt5.ridemission.model.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
