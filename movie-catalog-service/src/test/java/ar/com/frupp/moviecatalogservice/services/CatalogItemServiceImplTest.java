package ar.com.frupp.moviecatalogservice.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CatalogItemServiceImplTest {

    CatalogItemService service = new CatalogItemServiceImpl();

    @Test
    void shouldReturnListOfCatalogItems() {
        assertNotNull(service.getCatalogForUser(""));
    }


}
