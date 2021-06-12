package ar.com.frupp.movieinfoservice.services;

import ar.com.frupp.movieinfoservice.models.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Override
    public Movie getMovieById(String movieId) {
        return new Movie("id", "name");
    }
}
