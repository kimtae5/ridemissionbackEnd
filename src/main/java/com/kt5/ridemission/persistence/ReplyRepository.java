package com.kt5.ridemission.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt5.ridemission.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
