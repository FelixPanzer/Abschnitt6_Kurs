package felix.springframework.spring6restmvc.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
class BeerControllerTest
{

    @Autowired
    BeerController beerController;

    @Test
    void getBeerById()
    {
        System.out.println(beerController.getBeerById(UUID.randomUUID())); //randum UUID
    }
}