package com.springtest.search2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtest.search2.configuration.CommentRepositoryCustom;
import com.springtest.search2.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>,CommentRepositoryCustom<Comment> {

}
