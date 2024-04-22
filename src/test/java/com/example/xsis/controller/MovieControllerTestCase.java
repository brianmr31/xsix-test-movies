package com.example.xsis.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.xsis.dto.MovieDto;
import com.example.xsis.entity.MovieEntity;
import com.example.xsis.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
public class MovieControllerTestCase {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void MovieControllerTestCase_Positive_findAllMovies(){
        List<MovieEntity> tmpList = new ArrayList<MovieEntity>();
        MovieEntity tmp = new MovieEntity();
        tmp.setId(88);
        tmp.setTitle("Hello World");
        tmp.setDescription("The Hello World Movie");
        tmp.setImage("");
        tmp.setRating(9.1f);
        tmp.setCreatedAt(new Date());
        tmpList.add(tmp);

        Mockito.when( movieService.findAllMovies() ).thenReturn( tmpList );
        try {
            ResultActions result = mockMvc.perform( get("/api/v1/Movies") );
            result.andDo(print()).andExpect( status().isOk() ).andExpect(content().string( containsString("\"id\":"+tmp.getId()) ) );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void MovieControllerTestCase_Positive_getMoviesById(){
        MovieEntity tmp = new MovieEntity();
        tmp.setId(88);
        tmp.setTitle("Hello World");
        tmp.setDescription("The Hello World Movie");
        tmp.setImage("");
        tmp.setRating(9.1f);
        tmp.setCreatedAt(new Date());

        try {
            Mockito.when( movieService.getMoviesbyId( tmp.getId() ) ).thenReturn( tmp );

            ResultActions result = mockMvc.perform( get("/api/v1/Movies/"+ tmp.getId() ) );
            result.andDo(print()).andExpect( status().isOk() ).andExpect(content().string( containsString("\"id\":"+tmp.getId()) ) );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void MovieControllerTestCase_Positive_addMovies(){
        MovieDto tmp = new MovieDto();
        tmp.setTitle("Hello World");
        tmp.setDescription("The Hello World Movie");
        tmp.setImage("");
        tmp.setRating(9.1f);
        tmp.setCreatedAt("2022-08-01 10:56:31");
        tmp.setUpdatedAt("2022-08-01 10:56:31");

        try {
            Mockito.when( movieService.save(any()) ).thenReturn( "OK" );

            ObjectMapper mapper = new ObjectMapper();
            ResultActions result  = mockMvc.perform( 
                post("/api/v1/Movies")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content( mapper.writeValueAsString(tmp) ));
            result.andDo(print()).andExpect( status().isOk() ).andExpect(content().string( containsString("\"message\":\"OK\"") ) );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void MovieControllerTestCase_Positive_putMovies(){
        MovieDto tmp = new MovieDto();
        tmp.setId(88);
        tmp.setTitle("Hello World");
        tmp.setDescription("The Hello World Movie");
        tmp.setImage("");
        tmp.setRating(9.1f);
        tmp.setCreatedAt("2022-08-01 10:56:31");
        tmp.setUpdatedAt("2022-08-01 10:56:31");

        try {
            Mockito.when( movieService.save(any()) ).thenReturn( "OK" );

            ObjectMapper mapper = new ObjectMapper();
            ResultActions result  = mockMvc.perform( 
                patch("/api/v1/Movies")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content( mapper.writeValueAsString(tmp) ));
            result.andDo(print()).andExpect( status().isOk() ).andExpect(content().string( containsString("\"message\":\"OK\"") ) );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void MovieControllerTestCase_Positive_delMovies(){
        MovieDto tmp = new MovieDto();
        tmp.setId(88);
        tmp.setTitle("Hello World");
        tmp.setDescription("The Hello World Movie");
        tmp.setImage("");
        tmp.setRating(9.1f);
        tmp.setCreatedAt("2022-08-01 10:56:31");
        tmp.setUpdatedAt("2022-08-01 10:56:31");

        try {
            Mockito.when( movieService.delMoviesById(anyInt()) ).thenReturn( "OK" );

            ResultActions result  = mockMvc.perform( 
                delete("/api/v1/Movies/"+tmp.getId()));
            result.andDo(print()).andExpect( status().isOk() ).andExpect(content().string( containsString("\"message\":\"OK\"") ) );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
