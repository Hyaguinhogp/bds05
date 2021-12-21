package com.devsuperior.movieflix.dtos;

import java.util.Set;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

public class MovieReviewsDTO extends MovieDTO{
	private static final long serialVersionUID = 1L;

	public MovieReviewsDTO(Movie movie, Set<Review> reviews) {
		super(movie);
		for(Review review : reviews) {
			this.getReviews().add(new ReviewDTO(review));
		}
	}
}
