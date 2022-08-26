package com.amigoscode.movie;

import org.apache.tomcat.jni.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {
        var sql = """
                SELECT id, name, release_date
                FROM movie
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    @Transactional
    public int insertMovie(Movie movie) {
        //throw new UnsupportedOperationException("not implemented");
        System.out.println("inicio");
        String nome = movie.name();
        LocalDate data = movie.releaseDate();
        String sql = """
                INSERT INTO MOVIE(name, release_date) VALUES (?,?);
                """;
        return jdbcTemplate.update(
                sql,
                movie.name(), movie.releaseDate()
        );

    }

    @Override
    public int deleteMovie(int id) {
        var sql = """
                DELETE from movie
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);


    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        var sql = """
                SELECT id, name, release_date
                FROM movie
                WHERE id = ?
                """;
        List<Movie> movies = jdbcTemplate.query(sql, new MovieRowMapper(), id);
        return movies.stream().findFirst();
    }

}
