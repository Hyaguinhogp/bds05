package com.devsuperior.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dtos.GenreDTO;
import com.devsuperior.movieflix.services.GenreService;

@RestController
@RequestMapping(path = "/genres")
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public ResponseEntity<List<GenreDTO>> findAll(){
		List<GenreDTO> genres = genreService.findAll();
		return ResponseEntity.ok().body(genres);
	}
}
