package com.example.SpringDBDay1.Service;

import com.example.SpringDBDay1.Repository.MovieRepository;
import com.example.SpringDBDay1.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    public List<Movie> getUsers() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }


    public void editMovie(Movie newMovie, Integer id) {
        Movie oldMovie = movieRepository.findById(id).get();
        oldMovie.setID(newMovie.getID());
        oldMovie.setName(newMovie.getName());
        oldMovie.setDuration(newMovie.getDuration());
        oldMovie.setGenre(newMovie.getGenre());
        oldMovie.setRating(newMovie.getRating());
        oldMovie.setLaunchDate(newMovie.getLaunchDate());
        movieRepository.save(oldMovie);
    }

    public void removeMovie(Integer id) {
        movieRepository.deleteById(id);
    }

}
