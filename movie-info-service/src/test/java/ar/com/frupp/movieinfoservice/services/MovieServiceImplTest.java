package ar.com.frupp.movieinfoservice.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MovieServiceImplTest {
    private MovieService service = new MovieServiceImpl();

    @Test
    public void shouldReturnMovies() {
        var movieId = "testId";

        assertNotNull(service.getMovieById(movieId));
    }
}
