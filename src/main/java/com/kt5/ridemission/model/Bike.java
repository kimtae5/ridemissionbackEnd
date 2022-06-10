package com.kt5.ridemission.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString


public class Bike extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Member nickName;
	
	private String bikeName;
	

}
