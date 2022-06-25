package com.kt5.ridemission.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainMissionBoardDTO {
	private Long mainno;

	private String missionTitle;
	private String missionLocation;
	private Long missionPeople;
	private LocalDate missonStartDay;
	private LocalDate missonEndDay;
	private Long joinCoin;
	private String missonLeader;
	private String missonState;
	
	//Entity 를 만들 때 는 Entity를 외래키로 추가하지만 화면 입출력할 때는 필요한 데이터만 선언
	private String nickName;
}
