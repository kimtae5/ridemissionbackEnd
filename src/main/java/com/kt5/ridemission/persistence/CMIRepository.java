package com.kt5.ridemission.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt5.ridemission.model.CompleteMissionImage;

public interface CMIRepository extends JpaRepository<CompleteMissionImage, Long>{

}
