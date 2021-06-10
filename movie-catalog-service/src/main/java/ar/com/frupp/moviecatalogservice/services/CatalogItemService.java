package ar.com.frupp.moviecatalogservice.services;

import ar.com.frupp.moviecatalogservice.models.CatalogItem;

import java.util.List;

public interface CatalogItemService {
    List<CatalogItem> getCatalogForUser(String userId);
}
