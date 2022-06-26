package com.kt5.ridemission.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kt5.ridemission.dto.MissionBoardDTO;
import com.kt5.ridemission.dto.PageRequestMBDTO;
import com.kt5.ridemission.dto.PageResponseMBDTO;
import com.kt5.ridemission.model.MissionBoard;
import com.kt5.ridemission.persistence.MissionBoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MissionBoardServiceImpl implements MissionBoardService {
	private final MissionBoardRepository missionBoardRepository;

	//삽입이나 수정 그리고 삭제시 작업 시간을 기록하는 메서드
	//이 시간을 읽어서 데이터가 변경되었는지 확인
	private void updateDate() {
		try (PrintWriter pw = new PrintWriter(new FileOutputStream("./updatedate.dat"))) {
			//현재 날짜 및 시간 가져오기
			String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			System.out.println(str);
			pw.println(str);
			pw.flush();
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
		
	@Override
	public Long registerMissionBoard(MissionBoardDTO dto) {
		MissionBoard missionBoard = dtoToEntity(dto);
		missionBoardRepository.save(missionBoard);
		//수정한 시간을 기록
		updateDate();
		return missionBoard.getMainno();
	}

	@Override
	public MissionBoardDTO getMissionBoard(MissionBoardDTO dto) {
		Long mainno = dto.getMainno();
		Optional<MissionBoard> optional = missionBoardRepository.findById(mainno);
		if(optional.isPresent()) {
			return entityToDto(optional.get());
		}
		return null;
	}

	@Override
	public Long updateMissionBoard(MissionBoardDTO dto) {
		MissionBoard missionBoard = dtoToEntity(dto);
		missionBoardRepository.save(missionBoard);
		//수정한 날짜 업데이트
		updateDate();
		
		return missionBoard.getMainno();

	}

	@Override
	public Long deleteMissionBoard(MissionBoardDTO dto) {
		MissionBoard missionBoard = dtoToEntity(dto);
		Long mainno = missionBoard.getMainno();
		missionBoardRepository.deleteById(mainno);
		updateDate();
		return mainno;

	}

	@Override
	public PageResponseMBDTO getList(PageRequestMBDTO dto) {
		Sort sort = Sort.by("mainno").descending();
		Pageable pageable = PageRequest.of(
				dto.getPage()-1, dto.getSize(), sort);
		Page<MissionBoard> page = missionBoardRepository.findAll(pageable);
		
		PageResponseMBDTO result = new PageResponseMBDTO();
		result.makePageList(pageable);
		result.setTotalPage(page.getTotalPages());
		List<MissionBoardDTO> list = new ArrayList<>();
		page.get().forEach(missioBoard -> {
			list.add(entityToDto(missioBoard));
		});
		result.setMBList(list);
		return result;
	}

	@Override
	public String updatedate() {
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("./updatedate.dat")))){
			String str = br.readLine();
			return str;
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

}
