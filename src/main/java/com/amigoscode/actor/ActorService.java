package com.amigoscode.actor;

import com.amigoscode.movie.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {


    private final ActorDao actorDao;

    public ActorService(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    public List<Actor> getActors() {
        return actorDao.selectActors();
    }
}
