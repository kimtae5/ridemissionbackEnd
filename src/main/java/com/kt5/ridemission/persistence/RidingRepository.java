package com.kt5.ridemission.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt5.ridemission.entity.Member;

public interface RidingRepository extends JpaRepository<Member, String>{
	
	

}
