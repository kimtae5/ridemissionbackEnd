package com.kt5.ridemission;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.kt5.ridemission.model.Bike;
import com.kt5.ridemission.model.BikeImage;
import com.kt5.ridemission.model.Member;
import com.kt5.ridemission.persistence.BikeImageRepository;
import com.kt5.ridemission.persistence.BikeRepository;
import com.kt5.ridemission.persistence.RidingRepository;

@SpringBootTest
public class RidingRepositoryTest {
	@Autowired
	private RidingRepository ridingRepository;
	
	@Autowired
	private BikeRepository bikeRepository;

	@Autowired
	private BikeImageRepository bikeImageRepository;
	
	//@Test
	public void insertMember() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Member member = Member.builder().nickName("to" + i + "@kt5.com").password("1111" + i)
					.local("사용자" + i).phoneNumber("010" + i).coin(i*1000).build();
			ridingRepository.save(member);
		});
	};
	
	//@Test
	@Transactional
	@Commit
	public void insertBike() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			String nickName = "to" + i + "@kt5.com";
			
			Member member = Member.builder().nickName(nickName).build();
			
			Bike bike = Bike.builder().nickName(member).bikeName("bikename..."+ i)
					.build();
			bikeRepository.save(bike);
		});
	}
	
	@Test
	@Transactional
	@Commit
	public void insertBikeImage() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			String nickName = "to" + i + "@kt5.com";
			
			Member member = Member.builder().nickName(nickName).build();
			
			BikeImage bikeImage = BikeImage.builder().nickName(member).bikeImage("bikeImage..."+ i)
					.build();
			bikeImageRepository.save(bikeImage);
		});
	}
	
	
}
	

