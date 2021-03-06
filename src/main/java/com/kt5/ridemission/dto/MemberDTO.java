package com.kt5.ridemission.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

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
	private String bikeName;	
	private String bikeDescription;
	private String bikeImageUrl;
	private MultipartFile image;
	private long coin;
	private LocalDateTime lastlogindate;
	
	private LocalDateTime regdate;
	private LocalDateTime moddate;
}
