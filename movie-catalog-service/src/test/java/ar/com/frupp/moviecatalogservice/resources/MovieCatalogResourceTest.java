package ar.com.frupp.moviecatalogservice.resources;

import ar.com.frupp.moviecatalogservice.models.CatalogItem;
import ar.com.frupp.moviecatalogservice.services.CatalogItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieCatalogResource.class)
class MovieCatalogResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CatalogItemService service;

    @Test
    void shouldReturnCatalogForUser() throws Exception {
        String userId = "testUser";


        var item = new CatalogItem("Test Name", "Test description", 3.5);
        var catalogItems = List.of(item);

        Mockito.when(service.getCatalogForUser(userId)).thenReturn(catalogItems);

        var path = String.format("/catalog/%s", userId);

        mvc.perform(get(path).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(catalogItems.size())))
                .andExpect(jsonPath("$[0].name").value(item.getName()))
                .andExpect(jsonPath("$[0].description").value(item.getDescription()))
                .andExpect(jsonPath("$[0].rating").value(item.getRating()));

    }
}