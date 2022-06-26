package com.kt5.ridemission.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt5.ridemission.model.MissionBoard;

public interface MissionBoardRepository extends JpaRepository<MissionBoard, Long> {
	List<MissionBoard> findMissionBoardBymissionLocation(String missionLocation);
}
