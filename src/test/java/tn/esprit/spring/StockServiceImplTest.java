package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.junit.JUnitTestRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repositories.StockRepository;
import tn.esprit.spring.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



@RunWith(SpringRunner.class)
//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StockServiceImplTest {

    @InjectMocks
    private StockServiceImpl stockservice;

    @Mock
    private StockRepository sr;


    @Test
     void getStockTest() {

        when(sr.findAll()).thenReturn(Stream
                .of(new Stock("epuise", 4 , 5), new Stock("test",6,8)).collect(Collectors.toList()));
        Assertions.assertEquals(2, stockservice.retrieveAllStocks().size());
    }

    @Test
    void addStockTest() {
        Stock s = new Stock("epuise", 4 , 5);
        when(sr.save(s)).thenReturn(s);
        assertEquals(s, stockservice.addStock(s));
    }


    @Test
    void deleteStockTest() {
        Stock s = new Stock("aaa", 66 , 55);
        stockservice.deleteStock(s);
        verify(sr, times(1)).delete(s);
    }


}
