package com.kt5.ridemission.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tbl_member")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity{
	@Id
	private String nickName;
	
	private String password;
	
	private String local;
	
	private String phoneNumber;

	private String bikeName;
	
	private String bikeDescription;
	
	private String bikeImageUrl;
	
	private long coin;
	
	private LocalDateTime lastlogindate;
}
