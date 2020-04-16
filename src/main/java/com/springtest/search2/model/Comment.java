package com.springtest.search2.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comments")
public class Comment {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
  	
	  	private String body;

	  	/*private Long postId;*/
	  	
	  	private String name;
	  	
	  	private String email;
		
		@JsonIgnore
	  	LocalDateTime createDateTime = LocalDateTime.now();
		
		@JsonIgnore
		private Timestamp lastmodify;
		
		/*@ManyToOne(targetEntity = User.class)
		@JoinColumn(name = "user_id", referencedColumnName = "id")
	    private User user;*/
		
		@JsonIgnore
		@ManyToOne(targetEntity = Post.class)
	    @JoinColumn(name = "post_id",referencedColumnName = "id")
		//@JsonBackReference
	    private Post post;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public Timestamp getLastmodify() {
			return lastmodify;
		}
		public void setLastmodify(Timestamp lastmodify) {
			this.lastmodify = lastmodify;
		}
		public LocalDateTime getCreateDateTime() {
			return createDateTime;
		}
		public void setCreateDateTime(LocalDateTime createDateTime) {
			this.createDateTime = createDateTime;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Post getPost() {
			return post;
		}
		public void setPost(Post post) {
			this.post = post;
		}
		
		
		
		
}
