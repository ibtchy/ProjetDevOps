
package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.repositories.FactureRepository;
import tn.esprit.spring.services.FactureServiceImpl;
import static org.junit.Assert.assertNotNull;

@Slf4j
//@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest //(classes=ProduitServiceImpl.class)

public class FactureServiceImplTests {
	
	@Mock
	FactureRepository factureRepository ;
	@InjectMocks
	FactureServiceImpl factureService ; 
	
	

	
	
	@Test
public void getFacturesTest() {
      
		when(factureRepository.findAll()).thenReturn(Stream
                .of(new Facture(12,15),  new Facture(12,15)).collect(Collectors.toList()));
        Assertions.assertEquals(2, factureService.retrieveAllFactures().size());
		}
	
	@Test
	public void saveFactureTest() {
		Facture fc = new Facture(12,15);
		when(factureRepository.save(fc)).thenReturn(fc);
		assertEquals(fc, factureService.addFacture(fc));
	}
	
	
	
	@Test
	public void deleteFactureTest() {
		Facture ff = new Facture(11,44);
		factureService.deleteFr(ff);
		verify(factureRepository, times(1)).delete(ff);
	}
	

}
