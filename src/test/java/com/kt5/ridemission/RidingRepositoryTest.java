package com.kt5.ridemission;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kt5.ridemission.persistence.RidingRepository;

@SpringBootTest
public class RidingRepositoryTest {
	@Autowired
	RidingRepository ridingRepository;

	@Test
	public void insertMember() {
		
	}
}
