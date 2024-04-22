package com.example.xsis.service;

import java.text.ParseException;
import java.util.List;

import com.example.xsis.dto.MoveDto;
import com.example.xsis.entity.MovieEntity;

public interface MovieService {
    public List<MovieEntity> findAllMovies();
    public MovieEntity getMoviesbyId(int id) throws Exception;
    public String save(MoveDto data) throws ParseException;
    public String delMoviesById(int id);
}
