package com.amigoscode.actor;

import com.amigoscode.movie.Movie;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ActorDao {

    List<Actor> selectActors();

    @Transactional
    int insertActor(Actor actor);

    int deleteActor(int id);

    Movie selectActorById(int id);

}
