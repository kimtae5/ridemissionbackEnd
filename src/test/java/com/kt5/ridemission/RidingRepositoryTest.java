package com.kt5.ridemission;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.kt5.ridemission.model.Bike;
import com.kt5.ridemission.model.MainMissionBoard;
import com.kt5.ridemission.model.Member;
import com.kt5.ridemission.model.Reply;
import com.kt5.ridemission.persistence.BikeRepository;
import com.kt5.ridemission.persistence.MainMissionBoardRepository;
import com.kt5.ridemission.persistence.MemberRepository;
import com.kt5.ridemission.persistence.ReplyRepository;

@SpringBootTest
public class RidingRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MainMissionBoardRepository mainMissionBoardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	//Member에 데이터 삽입
	//@Test
	public void insertMember() {
		IntStream.rangeClosed(1, 1).forEach(i -> {
			String password = BCrypt.hashpw("i", BCrypt.gensalt());
			Member member = Member.builder().nickName("to" + i + "@kt5.com").password(password)
					.local("지역..." + i).phoneNumber("010" + i).coin(i*1000).build();
			memberRepository.save(member);
		});
	};
	
	//회원 정보 가져오기 - 수정이나 로그인에서 사용
	//@Test
	public void testGetMember() {
		Optional<Member> optional = memberRepository.findById("to@kt5.com");
		System.out.println(optional.isPresent() ? optional.get() : "존재하지않는 데이터입니다." );
	}
	
	//데이터 수정
	//@Test
	public void testUpdateMember() {
		String password = BCrypt.hashpw("2", BCrypt.gensalt());
		Member member = Member.builder().nickName("to1@kt5.com").password(password).local("서울")
				.phoneNumber("01091888426").coin(3000).build();
		memberRepository.save(member);
	}
	
	//데이터 삭제
	//@Test
	public void testDeleteMember() {
		Member member = Member.builder().nickName("kt2@kt.com").build();
		memberRepository.delete(member);
	}
	
	//지역으로 데이터 조회
	//@Test
	public void testFindName() {
		String local = "서울";
		List<Member> list = memberRepository.findMemberBylocal(local);
		System.out.println(list);
		System.out.println(list.size() > 0 ? "데이터가 존재합니다." : "데이터가 존재하지 않습니다." );
	}
	
	@Autowired
	private BikeRepository bikeRepository;
	
	//@Test
	@Transactional
	@Commit
	public void insertBike() {
		IntStream.rangeClosed(1, 5).forEach(i -> {
			String nickName = "to" + i + "@kt5.com";
			
			Member member = Member.builder().nickName(nickName).build();
			
			Bike bike = Bike.builder().nickName(member).bikeName("bikename..."+ i)
					.bikeDescription("bikeDescription..." + i).bikeImageUrl("bikeImageUrl..."+ i).build();
			bikeRepository.save(bike);
		});
	}
	
	//@Test
	public void testGetBike() {
		Optional<Bike> optional = bikeRepository.findById(7L);
		System.out.println(optional.isPresent() ? optional.get() : "존재하지않는 데이터입니다." );
	}
	
	//데이터 수정
	//@Test
	public void testUpdateBike() {
		Bike bike = Bike.builder().bno(2L).bikeName("harley1").bikeImageUrl("harley1.jpg")
				.bikeDescription("떨림좋음1").build();
		bikeRepository.save(bike);
	}
	
	//데이터 삭제
	//@Test
	public void testDeleteBike() {
		Bike bike = Bike.builder().bno(6L).build();
		bikeRepository.delete(bike);
	}
	
	//지역으로 데이터 조회
	//@Test
	public void testFindBike() {
		String name = "harley13";
		List<Bike> list = bikeRepository.findBikeBybikeName(name);
		System.out.println(list);
		System.out.println(list.size() > 0 ? "데이터가 존재합니다." : "데이터가 존재하지 않습니다." );
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
	
	//@Test
	@Transactional
	@Commit
	public void insertreply() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Long mainno = (long) i;
			
			MainMissionBoard mmb = MainMissionBoard.builder().mainno(mainno).build();
			
			Reply reply = Reply.builder().mainno(mmb).replycontent("replycontent..."+ i)
					.writer("writer..." + i).build();
			replyRepository.save(reply);
		});
	}

	
	
}
	

