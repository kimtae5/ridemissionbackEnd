package com.kt5.ridemission;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kt5.ridemission.entity.Member;
import com.kt5.ridemission.persistence.RidingRepository;

@SpringBootTest
public class RidingRepositoryTest {
	@Autowired
	RidingRepository ridingRepository;

	@Test
	public void insertMember() {
		IntStream.rangeClosed(1, 300).forEach(i -> {
			//데이터 생성
			Member member = Member.builder()
					.nickname("nickname..." + i)
					.password("password..." + i)
					.local("local..." + i)
					.phoneNumber("phoneNumber..." + i)
					.coin(i)
					.build();
			//데이터 삽입
			ridingRepository.save(member);
		});
	}
}
