package com.example.xsis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping("/api/v1/Movies")
    public List<MovieEntity> findAllMovies(){
        return this.movieService.findAllMovies();
    }

    @GetMapping("/api/v1/Movies/{id}")
    public MovieEntity getMoviesById(@PathVariable Integer id) throws Exception{
        return this.movieService.getMoviesbyId(id);
    }

    @PostMapping("/api/v1/Movies")
    public MessageRes addMovies(@Valid @RequestBody MoveDto movie) throws Exception{
        String result = this.movieService.save(movie);
        return new MessageRes(result);
    }

    @PatchMapping("/api/v1/Movies")
    public MessageRes putMovies(@Valid @RequestBody MoveDto movie) throws Exception{
        String result = this.movieService.save(movie);
        return new MessageRes(result);
    }

    @DeleteMapping("/api/v1/Movies/{id}")
    public MessageRes delMovies(@PathVariable Integer id) throws Exception{
        String result = this.movieService.delMoviesById(id);
        return new MessageRes(result);
    }
}
