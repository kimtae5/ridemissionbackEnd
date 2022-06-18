package com.kt5.ridemission.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt5.ridemission.model.MainMissionBoard;

public interface MainMissionBoardRepository extends JpaRepository<MainMissionBoard, Long> {
	List<MainMissionBoard> findMainMissionBoardBymissionLocation(String missionLocation);
}
