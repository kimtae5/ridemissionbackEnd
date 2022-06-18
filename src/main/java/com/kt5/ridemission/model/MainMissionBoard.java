package com.kt5.ridemission.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

public class MainMissionBoard extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mainno;

	private String missionTitle;
	private String missionLocation;
	private Long missionPeople;
	private LocalDate missonStartDay;
	private LocalDate missonEndDay;
	private Long joinCoin;
	private String missonLeader;
	private String missonState;
}
