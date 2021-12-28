package com.devsuperior.movieflix.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long MovieId;
	
	@NotBlank
	private String text;
	
	private User user;
	
	public ReviewDTO() {
	}

	public ReviewDTO(Long id, Long MovieId, String text, User user) {
		this.id = id;
		this.MovieId = MovieId;
		this.text = text;
		this.user = user;

	}
	
	public ReviewDTO(Review review) {
		id = review.getId();
		MovieId = review.getMovie().getId();
		text = review.getText();
		user = review.getUser();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovieId() {
		return MovieId;
	}

	public void setMovieId(Long id) {
		this.MovieId = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
