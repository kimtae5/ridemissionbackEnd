package com.kt5.ridemission.service;

import org.mindrot.jbcrypt.BCrypt;

import com.kt5.ridemission.dto.MemberDTO;
import com.kt5.ridemission.model.Member;

public interface MemberService {
	//데이터 삽입
	public String registerMember(MemberDTO dto);
	public MemberDTO loginMember(MemberDTO memberDTO);
	public MemberDTO getMember(MemberDTO memberDTO);
	public String updateMember(MemberDTO dto);
	public String deleteMember(MemberDTO dto);
	
	//DTO 클래스의 객치를 Model 클래스의 객체로 변환
	public default Member dtoToEntity(MemberDTO dto) {
		String password = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		Member member = Member.builder()
				.nickName(dto.getNickName())
				.password(password)
				.local(dto.getLocal())
				.phoneNumber(dto.getPhoneNumber())
				.coin(dto.getCoin())
				.build();
		
		return member;
	}
	
	//Model 객체를 DTO 클래스로 변환
	public default MemberDTO entityToDto(Member member) {
		MemberDTO dto = MemberDTO.builder()
				.nickName(member.getNickName())
				.local(member.getLocal())
				.phoneNumber(member.getPhoneNumber())
				.coin(member.getCoin())
				.regdate(member.getRegdate())
				.moddate(member.getModdate())
				.build();
		
		return dto;
	}
}