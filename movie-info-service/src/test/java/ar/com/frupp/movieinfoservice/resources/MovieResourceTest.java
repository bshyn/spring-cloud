package ar.com.frupp.movieinfoservice.resources;

import ar.com.frupp.movieinfoservice.models.Movie;
import ar.com.frupp.movieinfoservice.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieResource.class)
public class MovieResourceTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MovieService service;

    @Test
    void shouldReturnMovie() throws Exception {
        var movieId = "testId";
        var movie = new Movie(movieId, "testName");

        when(service.getMovieById(movieId)).thenReturn(movie);

        var path = String.format("/movies/%s", movieId);

        mvc.perform(get(path).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(movie.getName()))
                .andExpect(jsonPath("$.id").value(movie.getId()));

    }
}
