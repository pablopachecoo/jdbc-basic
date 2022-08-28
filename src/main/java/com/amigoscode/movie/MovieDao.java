package com.amigoscode.movie;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MovieDao {
    List<Movie> selectMovies();
    @Transactional
    int insertMovie(Movie movie);
    int deleteMovie(int id);

    int editMovie(int id);

    Optional<Movie> selectMovieById(int id);
    // TODO: Update
}
