package ar.com.frupp.moviecatalogservice.services;

import ar.com.frupp.moviecatalogservice.models.CatalogItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogItemServiceImpl implements CatalogItemService {

    @Override
    public List<CatalogItem> getCatalogForUser(String userId) {
        return List.of(
                new CatalogItem()
        );
    }
}
