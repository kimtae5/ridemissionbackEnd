package com.kt5.ridemission.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt5.ridemission.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
	List<Reply> findReplyByWriter(String writer);
}
