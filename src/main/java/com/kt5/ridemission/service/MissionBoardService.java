package com.kt5.ridemission.service;

import com.kt5.ridemission.dto.MissionBoardDTO;
import com.kt5.ridemission.dto.PageRequestMBDTO;
import com.kt5.ridemission.dto.PageResponseMBDTO;
import com.kt5.ridemission.model.MissionBoard;

public interface MissionBoardService {

	public Long registerMissionBoard(MissionBoardDTO dto);
	public MissionBoardDTO getMissionBoard(MissionBoardDTO dto);
	public Long updateMissionBoard(MissionBoardDTO dto);
	public Long deleteMissionBoard(MissionBoardDTO dto);
	public PageResponseMBDTO getList(PageRequestMBDTO dto);
	//마지막 업데이트 된 시간을 전송하는 메서드
	public String updatedate();
	
	public default MissionBoard dtoToEntity(MissionBoardDTO dto){
		MissionBoard missionBoard =	MissionBoard.builder()
		.mainno(dto.getMainno())
		.missionTitle(dto.getMissionTitle())
		.missionLocation(dto.getMissionLocation())
		.missionPeople(dto.getMissionPeople())
		.missonStartDay(dto.getMissonStartDay())
		.missonEndDay(dto.getMissonEndDay())		
		.joinCoin(dto.getJoinCoin())
		.missonLeader(dto.getMissonLeader())
		.missonState(dto.getMissonState())
		//.member(Member.builder().nickName(dto.getNickName()).build())
		.build();
		return missionBoard;
		}
	
	public default MissionBoardDTO entityToDto(MissionBoard missionBoard){
		MissionBoardDTO dto = MissionBoardDTO.builder()
				.mainno(missionBoard.getMainno())
				.missionTitle(missionBoard.getMissionTitle())
				.missionLocation(missionBoard.getMissionLocation())
				.missionPeople(missionBoard.getMissionPeople())
				.missonStartDay(missionBoard.getMissonStartDay())
				.missonEndDay(missionBoard.getMissonEndDay())		
				.joinCoin(missionBoard.getJoinCoin())
				.missonLeader(missionBoard.getMissonLeader())
				.missonState(missionBoard.getMissonState())
				//.nickName(missionBoard.getMember().getNickName())
				.build();
		return dto;
		}
}
