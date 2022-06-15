package com.kt5.ridemission;

import java.time.LocalDate;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.kt5.ridemission.model.Bike;
import com.kt5.ridemission.model.MainMissionBoard;
import com.kt5.ridemission.model.Member;
import com.kt5.ridemission.persistence.BikeRepository;
import com.kt5.ridemission.persistence.MainMissionBoardRepository;
import com.kt5.ridemission.persistence.MemberRepository;

@SpringBootTest
public class RidingRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BikeRepository bikeRepository;

	@Autowired
	private MainMissionBoardRepository mainMissionBoardRepository;
	
	//@Test
	public void insertMember() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Member member = Member.builder().nickName("to" + i + "@kt5.com").password("1111" + i)
					.local("사용자" + i).phoneNumber("010" + i).coin(i*1000).build();
			memberRepository.save(member);
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
					.bikeDescription("bikeDescription..." + i).bikeImageUrl("bikeImageUrl..."+ i).build();
			bikeRepository.save(bike);
		});
	}
	
	
	//@Test
	@Transactional
	@Commit
	public void insertMainMissionBoard() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			MainMissionBoard mmb = MainMissionBoard.builder().missionTitle("title..." + i)
					.missionLocation("location" + i).missionPeople((long)i).missonStartDay(LocalDate.now())
					.missonEndDay(LocalDate.now().plusDays(i)).joinCoin((long)i).missonLeader("leader..." + i)
					.missonState("state" + i).build();
			mainMissionBoardRepository.save(mmb);
		});
	}
	
}
	

