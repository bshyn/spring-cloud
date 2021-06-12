package ar.com.frupp.movieinfoservice.services;

import ar.com.frupp.movieinfoservice.models.Movie;

public interface MovieService {
    Movie getMovieById(String movieId);
}
