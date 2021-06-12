package ar.com.frupp.movieinfoservice.resources;

import ar.com.frupp.movieinfoservice.models.Movie;
import ar.com.frupp.movieinfoservice.services.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    private MovieService service;

    public MovieResource(MovieService service) {
        this.service = service;
    }

    @GetMapping("/{movieId}")
    @ResponseBody
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        return this.service.getMovieById(movieId);
    }
}
