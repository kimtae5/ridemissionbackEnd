package com.kt5.ridemission;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.kt5.ridemission.model.MainMissionBoard;
import com.kt5.ridemission.model.Member;
import com.kt5.ridemission.model.Reply;
import com.kt5.ridemission.persistence.MainMissionBoardRepository;
import com.kt5.ridemission.persistence.MemberRepository;
import com.kt5.ridemission.persistence.ReplyRepository;

@SpringBootTest
public class RidingRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

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
		System.out.println(list.size() > 0 ? "데이터는 : " + list : "데이터가 존재하지 않습니다." );
	}
	
	

	@Autowired
	private MainMissionBoardRepository mainMissionBoardRepository;

	//@Test
	public void insertMainMissionBoard() {
		IntStream.rangeClosed(1, 5).forEach(i -> {
			MainMissionBoard mmb = MainMissionBoard.builder().missionTitle("title..." + i)
					.missionLocation("location" + i).missionPeople((long)i).missonStartDay(LocalDate.now())
					.missonEndDay(LocalDate.now().plusDays(i)).joinCoin((long)i*1000).missonLeader("leader..." + i)
					.missonState("state" + i).build();
			mainMissionBoardRepository.save(mmb);
		});
	}
	
	//게시판 정보 가져오기 - 수정이나 로그인에서 사용
	//@Test
	public void testGetBoard() {
		Optional<MainMissionBoard> optional = mainMissionBoardRepository.findById(6L);
		System.out.println(optional.isPresent() ? optional.get() : "존재하지않는 데이터입니다." );
	}
	
	//데이터 수정
	//@Test
	public void testUpdateBoard() {
		MainMissionBoard mmb = MainMissionBoard.builder().missionTitle("title...10")
				.missionLocation("location6").missionPeople(20L)
				.missonStartDay(LocalDate.now().minusDays(5)).missonEndDay(LocalDate.now()
						.plusDays(30)).joinCoin(6000L).missonLeader("leader...T")
				.missonState("good").mainno(1L).build();
		mainMissionBoardRepository.save(mmb);
	}
	
	//데이터 삭제
	//@Test
	public void testDeleteBoard() {
		MainMissionBoard mmb = MainMissionBoard.builder().mainno(2L).build();
		mainMissionBoardRepository.delete(mmb);
	}
	
	//미션지역으로 데이터 조회
	//@Test
	public void testFindBoardLocation() {
		String local = "location4";
		List<MainMissionBoard> list = mainMissionBoardRepository
				.findMainMissionBoardBymissionLocation(local);
		System.out.println(list.size() > 0 ? "데이터는 : " + list : "데이터가 존재하지 않습니다." );
	}
	
	@Autowired
	private ReplyRepository replyRepository;
	
	//@Test
	public void insertreply() {
		IntStream.rangeClosed(2, 10).forEach(i -> {
			Long mainno = (long) 1;
			
			MainMissionBoard mmb = MainMissionBoard.builder().mainno(mainno).build();
			
			Reply reply = Reply.builder().mainno(mmb).replycontent("replycontent..."+ i)
					.writer("writer..." + i).build();
			replyRepository.save(reply);
		});
	}

	//댓글 정보 가져오기 
	//@Test
	public void testGetReply() {
		Optional<Reply> optional = replyRepository.findById(2L);
		System.out.println(optional.isPresent() ? optional.get() : "존재하지않는 데이터입니다." );
	}
	
	//데이터 수정
	//@Test
	public void testUpdateReply() {
		Reply reply = Reply.builder().rno(6L).replycontent("냉무6").writer("태오6")
						.build();
		replyRepository.save(reply);
	}
	
	//데이터 삭제
	//@Test
	public void testDeleteReply() {
		Reply reply = Reply.builder().rno(1L).build();
		replyRepository.delete(reply);
	}
	
	//글쓴이로 데이터 조회
	//@Test
	public void testFindReplyWriter() {
		String writer = "writer...3";
		List<Reply> list = replyRepository.findReplyByWriter(writer);
		System.out.println(list.size() > 0 ? "데이터는 : " + list : "데이터가 존재하지 않습니다." );
	}
	
}
	

