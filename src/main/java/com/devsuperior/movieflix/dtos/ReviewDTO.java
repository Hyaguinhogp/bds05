package com.devsuperior.movieflix.dtos;

import java.io.Serializable;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long MovieId;
	private String text;
	
	public ReviewDTO() {
	}

	public ReviewDTO(Long MovieId, String text) {
		this.MovieId = MovieId;
		this.text = text;

	}
	
	public ReviewDTO(Review review) {
		MovieId = review.getMovie().getId();
		text = review.getText();
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
}
