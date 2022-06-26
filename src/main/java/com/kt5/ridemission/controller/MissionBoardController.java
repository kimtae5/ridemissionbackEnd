package com.kt5.ridemission.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt5.ridemission.dto.MissionBoardDTO;
import com.kt5.ridemission.dto.PageRequestMBDTO;
import com.kt5.ridemission.dto.PageResponseMBDTO;
import com.kt5.ridemission.service.MissionBoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("missionboard")
@RequiredArgsConstructor
public class MissionBoardController {
	private final MissionBoardService missionBoardService;
	
	//페이지 단위로 데이터 가져오기
	@GetMapping("list")
	public ResponseEntity<?> getList(PageRequestMBDTO dto){
		PageResponseMBDTO response = null;
		try {
			response = missionBoardService.getList(dto);
		}catch(Exception e) {
			response = new PageResponseMBDTO();
			response.setError(e.getMessage());
		}
		return ResponseEntity.ok().body(response);
	}
	
	//데이터 삽입
	@PostMapping("register")
	public ResponseEntity<?> registerMissionBoard(MissionBoardDTO dto){
		MissionBoardDTO response = null;
		try {
			Long mainno = missionBoardService.registerMissionBoard(dto);
			response = MissionBoardDTO.builder().mainno(mainno).build();
		}catch(Exception e) {
			response = MissionBoardDTO.builder().error(e.getMessage()).build();
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	//데이터 1개 가져오기
	@GetMapping("get")
	public ResponseEntity<?> getMissionBoard(MissionBoardDTO dto){
		MissionBoardDTO response = null;
		try {
			response = missionBoardService.getMissionBoard(dto);
		}catch(Exception e) {
			response = MissionBoardDTO.builder().error(e.getMessage()).build();
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	//데이터 삭제
	@PostMapping("delete")
	public ResponseEntity<?> deleteMissionBoard(MissionBoardDTO dto){
		MissionBoardDTO response = null;
		try {
			Long mainno = missionBoardService.deleteMissionBoard(dto);
			response = MissionBoardDTO.builder().mainno(mainno).build();
		}catch(Exception e) {
			response = MissionBoardDTO.builder().error(e.getMessage()).build();
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	//데이터 수정
	@PostMapping("update")
	public ResponseEntity<?> updateMissionBoard(MissionBoardDTO dto){
		MissionBoardDTO response = null;
		try {
			Long mainno = missionBoardService.updateMissionBoard(dto);
			response = MissionBoardDTO.builder().mainno(mainno).build();
		}catch(Exception e) {
			response = MissionBoardDTO.builder().error(e.getMessage()).build();
		}
			return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("updatedate")
	public ResponseEntity<?> updatetime(){
		String updatedate = missionBoardService.updatedate();
		//별도의 DTO가 없어서 Map을 이용해서 저장
		Map<String, String> map = new HashMap<>();
		map.put("updatedate", updatedate);
		
		return ResponseEntity.ok().body(map);
	}

}
