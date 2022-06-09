package com.kt5.ridemission.entity;

import javax.persistence.Column;
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
public class Member {
	@Id
	@Column(length=100, nullable=false)
	private String nickname;
	
	@Column(length=200, nullable=false)
	private String password;
	
	@Column(length=100, nullable=false)
	private String local;
	
	@Column(length=100, nullable=false)
	private String phoneNumber;

	@Column(length=200, nullable=true)
	private long coin;
}
