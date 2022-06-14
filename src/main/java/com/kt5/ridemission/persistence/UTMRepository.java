package com.kt5.ridemission.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt5.ridemission.model.UserToMission;

public interface UTMRepository extends JpaRepository<UserToMission, Long>{

}
