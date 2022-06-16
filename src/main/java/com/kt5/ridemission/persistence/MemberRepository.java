package com.kt5.ridemission.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt5.ridemission.model.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	
	List<Member> findMemberBylocal(String local);

}
