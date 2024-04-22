package com.example.xsis;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieEntity> findAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public MovieEntity getMoviesbyId(int id) throws Exception {
        MovieEntity tmp = this.movieRepository.getMoviesById(id);
        if( tmp == null ){
            throw new Exception("Bad Request Erro");
        }
        return this.movieRepository.getMoviesById(id);
    }

    @Override
    public String save(MoveDto data) throws ParseException {
        try{
            this.movieRepository.save(data.toEntity());
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
