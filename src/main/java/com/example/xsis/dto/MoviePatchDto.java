package com.example.xsis.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.xsis.entity.MovieEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MoviePatchDto {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @NotNull(message = "id is mandatory")
    private int id;

    private String title;
    private String description;

    private float rating;
    
    private String image;
  
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$", 
        message = "Invalid characters date yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private String createdAt;

    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$", 
        message = "Invalid characters date yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private String updatedAt;

    public MovieEntity marge( MovieEntity tmp ) throws ParseException {
        if(this.title != null ){
            tmp.setTitle(title);
        }

        if(this.description != null ){
            tmp.setDescription(this.description);
        }

        if(this.rating != 0 ){
            tmp.setRating(this.rating);
        }

        if(this.image != null ){
            tmp.setImage(this.image);
        }

        if(this.createdAt != null ){
            tmp.setCreatedAt(sdf.parse(this.createdAt));
        }

        if(this.updatedAt != null ){
            tmp.setUpdatedAt(sdf.parse( this.updatedAt));
        }
        return tmp;
    }

    public MovieEntity toEntity() throws ParseException {
        MovieEntity tmp = new MovieEntity();
        if( this.id != 0 ) {
            tmp.setId(this.id);
        }
        tmp.setTitle(this.title);
        tmp.setDescription(this.description);
        tmp.setRating(this.rating);
        tmp.setImage(this.image);
        tmp.setCreatedAt(sdf.parse( this.createdAt ) );
        tmp.setUpdatedAt(sdf.parse( this.updatedAt ) );
        return tmp;
    }
}
