package com.springtest.search2;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	/*@GetMapping(value = "/findcomments") 
	public @ResponseBody List<Comment> search(@RequestParam Map<String, String> reqParam) {
		
		return commentRepository.findByProperty(reqParam);
		
	}*/
	
}
