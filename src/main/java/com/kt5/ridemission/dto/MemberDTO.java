package com.kt5.ridemission.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private String nickName;
	private String password;
	private String local;
	private String phoneNumber;
	private long coin;
	
	
	private LocalDateTime regdate;
	private LocalDateTime moddate;
}
