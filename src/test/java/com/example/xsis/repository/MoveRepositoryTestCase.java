package com.example.xsis.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.xsis.entity.MovieEntity;

@DataJpaTest
@AutoConfigureTestDatabase( connection = EmbeddedDatabaseConnection.H2 )
public class MoveRepositoryTestCase {
    
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void MovieRepository_Positif_findAllMovies(){
        List<MovieEntity> listTmp = new ArrayList<MovieEntity>();        
        MovieEntity tmp = new MovieEntity();
        tmp.setId(88);
        tmp.setTitle("Hello World");
        tmp.setDescription("The Hello World Movie");
        tmp.setImage("");
        tmp.setRating(9.1f);
        tmp.setCreatedAt(new Date());
        listTmp.add(tmp);

        MovieEntity tmp2 = new MovieEntity();
        tmp2.setId(89);
        tmp2.setTitle("Flat Earth");
        tmp2.setDescription("Flat Earth Why The Earth Flat?");
        tmp2.setImage("");
        tmp2.setRating(9.9f);
        tmp2.setCreatedAt(new Date());
        listTmp.add(tmp2);

        // Insert semua data di db -> ada 2 row
        this.movieRepository.saveAll( listTmp );

        // ambil semua data
        List<MovieEntity> result = this.movieRepository.findAll();

        // harusnya ada 2 row 
        assertEquals(result.size(), 2 );
    }

    @Test
    public void MovieRepository_Positif_saveAndgetMoviesById(){
        int id = 1;

        MovieEntity tmp = new MovieEntity();
        tmp.setId(id);
        tmp.setTitle("MovieRepository_Positif_saveAndgetMoviesById");
        tmp.setDescription("MovieRepository_Positif_saveAndgetMoviesById");
        tmp.setImage("");
        tmp.setRating(9.1f);
        tmp.setCreatedAt(new Date());

        // Simpan data di variable tmp
        MovieEntity saveR = this.movieRepository.save( tmp );
        // Hasil Data yang disimpan harusnya sama dengan data tmp
        assertEquals(tmp.getTitle(), saveR.getTitle() );

        // ambil data by Id yang barusan disimpan
        MovieEntity result = this.movieRepository.getMoviesById(saveR.getId());
         // Hasil Data yang di ambil by Id harusnya sama dengan yang tadi disimpan
        assertEquals(saveR.getTitle(), result.getTitle() );
    }

    @Test
    public void MovieRepository_Positif_DeleteById(){
        List<MovieEntity> listTmp = new ArrayList<MovieEntity>();        
        MovieEntity tmp = new MovieEntity();
        tmp.setId(88);
        tmp.setTitle("Hello World");
        tmp.setDescription("The Hello World Movie");
        tmp.setImage("");
        tmp.setRating(9.1f);
        tmp.setCreatedAt(new Date());
        listTmp.add(tmp);

        MovieEntity tmp2 = new MovieEntity();
        tmp2.setId(89);
        tmp2.setTitle("Flat Earth");
        tmp2.setDescription("Flat Earth Why The Earth Flat?");
        tmp2.setImage("");
        tmp2.setRating(9.9f);
        tmp2.setCreatedAt(new Date());
        listTmp.add(tmp2);

        // Insert semua data di db -> ada 2 row
        tmp = this.movieRepository.save( tmp );
        tmp2 = this.movieRepository.save( tmp2 );

        // Diambil dulu semua data
        List<MovieEntity> result = this.movieRepository.findAll();
        // Harusnya ada 2 row data saja
        assertEquals(result.size(), 2 );

        // Dihapus 1 row
        this.movieRepository.deleteById( tmp2.getId() );

        // Diambil dulu semua data lagi
        result = this.movieRepository.findAll();
        // Harusnya ada 1 row data saja
        assertEquals(result.size(), 1 );
    }
}
