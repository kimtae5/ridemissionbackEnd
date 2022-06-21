package com.kt5.ridemission.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.kt5.ridemission.dto.MemberDTO;
import com.kt5.ridemission.model.Member;
import com.kt5.ridemission.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

	@Override
	public String registerMember(MemberDTO dto) {
		Member member = dtoToEntity(dto);
		//닉네임 중복 체크
		Optional<Member> optional = memberRepository.findById(dto.getNickName());
		if(optional.isPresent()) {
			return "이미 존재하는 닉네임 입니다.";
		}
		//phoneNumber 중복 체크
		List<Member> list = memberRepository.findMemberByphoneNumber(dto.getPhoneNumber());
		if(list.size() > 0) {
			return "이미 존재하는 휴대폰번호 입니다.";
		}
		
		memberRepository.save(member);
		return member.getNickName();
	}

	@Override
	public MemberDTO loginMember(MemberDTO memberDTO) {
	//닉네임을 가지고 데이터를 찾아옵니다.
		Optional <Member> optional = memberRepository.findById(memberDTO.getNickName());
		//존재하는 닉네임
		if(optional.isPresent()) {
			//비밀번호 확인
			Member member = optional.get();
			if(BCrypt.checkpw(memberDTO.getPassword(), member.getPassword())) {
				//로그인에 성공했을 때 로그인 한 시간을 업데이트
				//ZonedDateTime nowUTC = ZonedDateTime.now(ZoneId.of("UTC"));
				//LocalDateTime now = nowUTC.withZoneSameInstant(
				//		ZoneId.of("Asia/Seoul")).toLocalDateTime();
				Member updateMember = Member.builder()
						.nickName(member.getNickName())
						.password(member.getPassword())
						.local(member.getLocal())
						.phoneNumber(member.getPhoneNumber())
						//.lastlogindate(now)// (추후 업그레이드예정)
						.build();
				memberRepository.save(updateMember);
				
				return entityToDto(member);
			}else {
				return null;
			}
		}
		//존재하지 않는 이메일
		else {
			return null;
		}
	
	}

	@Override
	public MemberDTO getMember(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
