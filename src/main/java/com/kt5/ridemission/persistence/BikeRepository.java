package com.kt5.ridemission.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt5.ridemission.model.Bike;
import com.kt5.ridemission.model.Member;

public interface BikeRepository extends JpaRepository<Bike, Long> {
	List<Bike> findBikeBybikeName(String bikeName);
}
