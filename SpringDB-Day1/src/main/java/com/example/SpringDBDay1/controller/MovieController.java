package com.example.SpringDBDay1.controller;

import com.example.SpringDBDay1.Service.MovieService;
import com.example.SpringDBDay1.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity getMovie(){
        return ResponseEntity.status(200).body(movieService.getUsers());
    }

    @PostMapping
    public ResponseEntity addUsers(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(201).body("Movie added !");
    }

    @PutMapping("{id}")
    public ResponseEntity updateUsers(@RequestBody Movie movie, @PathVariable Integer id){
        movieService.editMovie(movie,id);
        return ResponseEntity.status(200).body("Movie Updated !");
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.removeMovie(id);
        return ResponseEntity.status(200).body("Movie deleted !");
    }

}
