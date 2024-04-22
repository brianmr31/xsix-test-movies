package com.example.xsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.xsis.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{

    @Query("SELECT e FROM MovieEntity e WHERE e.id = :id ")
    MovieEntity getMoviesById(@Param("id")int id);
}
