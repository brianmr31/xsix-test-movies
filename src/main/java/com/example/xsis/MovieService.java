package com.example.xsis;

import java.text.ParseException;
import java.util.List;

public interface MovieService {
    public List<MovieEntity> findAllMovies();
    public MovieEntity getMoviesbyId(int id) throws Exception;
    public String save(MoveDto data) throws ParseException;
    public String delMoviesById(int id);
}
