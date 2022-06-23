package com.kt5.ridemission;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kt5.ridemission.dto.MemberDTO;
import com.kt5.ridemission.service.MemberService;

@SpringBootTest
public class RidingServiceTest {
	@Autowired
	MemberService memberService;
	
	//회원 가입
	//@Test
	public void testInsertMember(){
	MemberDTO dto =
	MemberDTO.builder().nickName("kt").password("1").local("서울").phoneNumber("01091888426")
	.coin(12L).build();
	String register = memberService.registerMember(dto);
	System.out.println(register);
	}
	
	//로그인
	//@Test
	public void testLoginMember(){
		MemberDTO dto = MemberDTO.builder().nickName("kt1@kt.com").password("1").build();
		MemberDTO result = memberService.loginMember(dto);
		System.out.println("result1 " + result);
		dto = MemberDTO.builder().nickName("kt").password("1").build();
		result = memberService.loginMember(dto);
		System.out.println("result2 " + result);
		dto = MemberDTO.builder().nickName("kt1@kt.com").password("12").build();
		result = memberService.loginMember(dto);
		System.out.println("result3 " + result);
	}
	
	//회원 정보 가져오기
	//@Test
	public void testGetMember(){
	MemberDTO dto =	MemberDTO.builder().nickName("kt1@kt.com").build();
	MemberDTO result = memberService.getMember(dto);
	System.out.println("result 1" + result);
	dto = MemberDTO.builder().nickName("kt1@kt.com").build();
	result = memberService.loginMember(dto);
	System.out.println("result 2" + result);
	}
	
	//회원 정보 수정
	//@Test
	public void testUpdateMember(){
	MemberDTO dto =
	MemberDTO.builder().nickName("kt1@kt.com").password("2").local("부산")
	.phoneNumber("01099999999").coin(30000L).build();
	memberService.updateMember(dto);
	}
	
	//회원 정보 삭제
	//@Test
	public void testDeleteMember(){
	MemberDTO dto =	MemberDTO.builder().nickName("to2@kt5.com").build();
	memberService.deleteMember(dto);
	}
	
	

}
