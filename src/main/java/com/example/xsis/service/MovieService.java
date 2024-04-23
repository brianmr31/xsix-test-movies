package com.example.xsis.service;

import java.text.ParseException;
import java.util.List;

import com.example.xsis.dto.MovieAddDto;
import com.example.xsis.dto.MoviePatchDto;
import com.example.xsis.entity.MovieEntity;

public interface MovieService {
    public List<MovieEntity> findAllMovies();
    public MovieEntity getMoviesbyId(int id) throws Exception;
    public String save(MovieAddDto data) throws ParseException;
    public String patch(MoviePatchDto data) throws Exception;
    public String delMoviesById(int id);
}
