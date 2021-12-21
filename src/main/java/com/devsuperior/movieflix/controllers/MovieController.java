package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<Page<Movie>> findAllPaged(@PageableDefault(sort = "tittle") Pageable pageable){
		Page<Movie> page = movieService.findMoviesPaged(pageable);
		return ResponseEntity.ok().body(page);
	}
}
