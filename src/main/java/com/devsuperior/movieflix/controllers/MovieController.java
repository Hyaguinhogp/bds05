package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.dtos.MovieReviewsDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAllPaged(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
			@PageableDefault(sort = "title") Pageable pageable
			){
		Page<MovieDTO> page = movieService.findMoviesPaged(genreId, pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		MovieDTO movie = movieService.findById(id);
		return ResponseEntity.ok().body(movie);
	}
	
	@GetMapping(value = "/{id}/reviews")
	public ResponseEntity<MovieReviewsDTO> findMovieReviews(@PathVariable Long id){
		MovieReviewsDTO movie = movieService.findMovieReviews(id);
		return ResponseEntity.ok().body(movie);
	}
	

}
