package com.amigoscode.actor;

import com.amigoscode.exception.NotFoundException;
import com.amigoscode.movie.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ActorDataAccessService implements ActorDao{

    private final JdbcTemplate jdbcTemplate;

    public ActorDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Actor> selectActors() {
        var sql = """
                SELECT id, movie, name
                FROM actor
                LIMIT 100;
                """;
        System.out.println(sql);
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Actor(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            );
        });
    }



    @Override
    public int insertActor(Actor actor) {
        //TODO
        // Só inserir um ator, se ter um filme com o mesmo id,
        // retornar erro customizado se id não existir
        // amanhã eu começo a implementar isso 2.0

        System.out.println("INSERT ACTOR");
        String nome = actor.name();
        String sql = """
                INSERT INTO MOVIE(name, release_date) VALUES (?,?);
                """;
//        return jdbcTemplate.update(
//                sql,
//                movie.name(), movie.releaseDate()
//        );

        return 0;
    }

    @Override
    public int deleteActor(int id) {
        return 0;
    }


    @Override
    public Movie selectActorById(int id){
        return null;
    }


}
