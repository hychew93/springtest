package com.springtest.search2.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springtest.search2.model.Comment;
import com.springtest.search2.model.IPostCount;
import com.springtest.search2.model.Post;
import com.springtest.search2.repo.CommentRepository;
import com.springtest.search2.repo.PostRepository;

@Controller    
public class SearchController {
	@Autowired 
	private PostRepository postRepository;
	
	@Autowired 
	private CommentRepository commentRepository;

	@GetMapping(path = "/posts")
	public @ResponseBody Iterable<Post> getAllPost() {
		return postRepository.findAll();
	}

	@GetMapping(value = "/posts/{post_id}")
	public @ResponseBody List<Post> searchByPid(@PathVariable("post_id") long id) {
		//System.out.println(postId);
		return postRepository.findById(id);
	}
	
	@GetMapping(value = "/toppost")
	public @ResponseBody List<IPostCount> findTopPost() {
		return postRepository.findTopPost();
	}
	
	@GetMapping(path = "/comments")
	public @ResponseBody Iterable<Comment> getAllComment() {
		return commentRepository.findAll();
	}
	
	@GetMapping(value = "/findcomments") 
	@NotFound(action = NotFoundAction.IGNORE)
	public @ResponseBody List<Comment> search(@RequestParam Map<String, String> reqParam) {
		
		return commentRepository.findByProperty(reqParam);
		
	}
	
}
