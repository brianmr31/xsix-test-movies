package com.example.xsis.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xsis.config.BadRequestException;
import com.example.xsis.dto.MovieAddDto;
import com.example.xsis.dto.MoviePatchDto;
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
    public MovieEntity getMoviesbyId(int id) throws BadRequestException {
        MovieEntity tmp = this.movieRepository.getMoviesById(id);
        if( tmp == null ){
            throw new BadRequestException("Bad Request Error, Id Not Found");
        }
        return this.movieRepository.getMoviesById(id);
    }

    @Override
    public String save(MovieAddDto data) throws ParseException {
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
    public String patch(MoviePatchDto data) throws BadRequestException {
        MovieEntity tmp = this.movieRepository.getMoviesById(data.getId());
        if( tmp == null ){
            throw new BadRequestException("Bad Request Error, Id Not Found");
        }
        try{  
            tmp = this.movieRepository.save(data.marge(tmp));
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
