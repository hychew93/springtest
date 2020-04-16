package com.springtest.search2;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "posts")
public class Post {
    private Long userId;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;
    
	/*@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;*/
	
	@OneToMany(mappedBy="post")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonBackReference
    private List<Comment> comments;
    
	@JsonIgnore
	LocalDateTime createDateTime = LocalDateTime.now();

	@JsonIgnore
    private Timestamp lastmodify;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

    
    

}
