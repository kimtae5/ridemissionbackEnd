package com.kt5.ridemission;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kt5.ridemission.model.Bike;
import com.kt5.ridemission.model.Member;
import com.kt5.ridemission.persistence.RidingRepository;

@SpringBootTest
public class RidingRepositoryTest {
	@Autowired
	private RidingRepository ridingRepository;

	//@Test
	public void r() {
		System.out.println(ridingRepository);
	}
	
	//@Test
	public void insertMember() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Member member = Member.builder().nickName("to" + i + "@kt5.com").password("1111")
					.local("사용자" + i).phoneNumber("010" + i).coin(i*1000).build();
			ridingRepository.save(member);
		});
	};
	
	@Test
		public void insertbike() {
			IntStream.rangeClosed(1, 100).forEach(i -> {
				Member member = Member.builder().nickName("to" + i + "@kt5.com").
				Bike bike = Bike.builder().nickName(member.getNickName()).bikeName("1111")
						.local("사용자" + i).phoneNumber("010" + i).coin(i*1000).build();
				ridingRepository.save(bike);
			});
		};
	
}
	

