package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query("SELECT DISTINCT obj "
			+ "FROM Movie obj "
			+ "WHERE (COALESCE(:genres) IS NULL OR obj.genre IN :genres)")
	public Page<Movie> find(List<Genre> genres, Pageable pageable);
	
	@Query("SELECT obj "
			+ "FROM Movie obj "
			+ "WHERE obj IN :movies")
	public List<Movie> findMoviesWithGenres(List<Movie> movies);
	
}
