package ar.com.frupp.moviecatalogservice.resources;

import ar.com.frupp.moviecatalogservice.models.CatalogItem;
import ar.com.frupp.moviecatalogservice.services.CatalogItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    private CatalogItemService catalogItemService;

    public MovieCatalogResource(CatalogItemService catalogItemService) {
        this.catalogItemService = catalogItemService;
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        return this.catalogItemService.getCatalogForUser(userId);
    }
}
