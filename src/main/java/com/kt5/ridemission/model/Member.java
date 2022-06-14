package com.kt5.ridemission.model;

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
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity{
	@Id
	private String nickName;
	
	private String password;
	
	private String local;
	
	private String phoneNumber;

	private long coin;
}
