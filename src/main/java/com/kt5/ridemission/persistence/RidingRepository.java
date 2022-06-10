package com.kt5.ridemission.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.kt5.ridemission.model.Member;

public interface RidingRepository extends JpaRepository<Member, String>{
	
	

}
