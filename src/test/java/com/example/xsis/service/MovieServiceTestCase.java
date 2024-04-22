package com.example.xsis.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.xsis.dto.MovieDto;
import com.example.xsis.entity.MovieEntity;
import com.example.xsis.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MovieServiceTestCase {

    @Mock
    private MovieRepository movieRepository; 

    @InjectMocks
    private MovieService movieService = new MovieServiceImpl( movieRepository );

    @Test
    public void MovieService_Positif_findAllMovies(){
        List<MovieEntity> mockdata = new ArrayList<MovieEntity>();
        MovieEntity tmp = new MovieEntity();
        tmp.setId(1);
        tmp.setTitle("Hello World");
        tmp.setDescription("The Hello World Movie");
        tmp.setImage("");
        tmp.setRating(9.1f);
        tmp.setCreatedAt(new Date());
        mockdata.add(tmp);
        given( movieRepository.findAll()).willReturn( mockdata );

        List<MovieEntity> result = this.movieService.findAllMovies();
        assertEquals(result.size(), mockdata.size());
        assertEquals(result.get(0).getTitle(), mockdata.get(0).getTitle() );
    }   
    

    @Test
    public void MovieService_Positif_getMoviesbyId() throws Exception{
        int id = 1;

        MovieEntity mockdata = new MovieEntity();
        mockdata.setId(1);
        mockdata.setTitle("Hello World");
        mockdata.setDescription("The Hello World Movie");
        mockdata.setImage("");
        mockdata.setRating(9.1f);
        mockdata.setCreatedAt(new Date());

        given( movieRepository.getMoviesById(id) ).willReturn( mockdata );

        MovieEntity result = this.movieService.getMoviesbyId(id);
        assertEquals(result.getTitle(), mockdata.getTitle() );
    }
    
    @Test
    public void MovieService_Negatif_getMoviesbyId() {
        int id = 999; // input disalahkan
        Exception error = new Exception("Bad Request Error");
        Exception thrown = assertThrows(Exception.class, ()-> { this.movieService.getMoviesbyId(id);}, "Bad Request Error");
        assertEquals(thrown.getMessage(), error.getMessage() );
    }

    @Test
    public void MovieService_Positif_save() {

        MovieDto mockdata = new MovieDto();
        mockdata.setId(1);
        mockdata.setTitle("Hello World");
        mockdata.setDescription("The Hello World Movie");
        mockdata.setImage("");
        mockdata.setRating(9.1f);
        mockdata.setCreatedAt("2022-08-13 09:30:23");
        mockdata.setUpdatedAt("2022-08-13 09:30:23");

        MovieEntity mockEntity1;
        try {
            mockEntity1 = mockdata.toEntity();;
            given( movieRepository.save(any()) ).willReturn(mockEntity1);

            String result = this.movieService.save(mockdata);
            assertEquals( result, "OK");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test_positif_deleteById() {
        int id = 1;
        doNothing().when(movieRepository).deleteById(id);

        String result = this.movieService.delMoviesById(id);
        assertEquals( result, "OK");
    }
}
