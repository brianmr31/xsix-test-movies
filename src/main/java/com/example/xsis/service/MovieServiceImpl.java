package com.example.xsis.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xsis.dto.MoveDto;
import com.example.xsis.entity.MovieEntity;
import com.example.xsis.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieEntity> findAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public MovieEntity getMoviesbyId(int id) throws Exception {
        MovieEntity tmp = this.movieRepository.getMoviesById(id);
        if( tmp == null ){
            throw new Exception("Bad Request Error");
        }
        return this.movieRepository.getMoviesById(id);
    }

    @Override
    public String save(MoveDto data) throws ParseException {
        try{
            MovieEntity tmp = this.movieRepository.save(data.toEntity());
            if(tmp == null ) {
                return "ERROR";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
        return "OK";
    }

    @Override
    public String delMoviesById(int id) {
        try{
            this.movieRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
        return "OK";
    }
    
}
