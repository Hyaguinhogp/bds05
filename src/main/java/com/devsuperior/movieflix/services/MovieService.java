package com.devsuperior.movieflix.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.dtos.MovieReviewsDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findMoviesPaged(Long genreId, Pageable pageable){
		List<Genre> genres = (genreId == 0) ? null : Arrays.asList(genreRepository.getOne(genreId));
		Page<Movie> page = movieRepository.find(genres, pageable);
		movieRepository.findMoviesWithGenres(page.getContent());
		return page.map(x -> new MovieDTO(x));
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id){
		MovieDTO movie = new MovieDTO(movieRepository.findById(id).get());
		return movie;
	}

	@Transactional(readOnly = true)
	public MovieReviewsDTO findMovieReviews(Long id) {
		Movie movie = movieRepository.findById(id).get();
		return new MovieReviewsDTO(movie, movie.getReviews());
	}
}
