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
import tn.esprit.repositories.ProduitRepository;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.ProduitServiceImpl;


//@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest //(classes=ProduitServiceImpl.class)
public class ProduitServiceImplTests {
	@Mock
	ProduitRepository produitRepo;
	
	
	@InjectMocks
	ProduitServiceImpl produitService;
	
	
	
	
	
	@Test
    public void getProduitsTest() {
      
		
		when(produitRepo.findAll()).thenReturn(Stream
                .of(new Produit("999", "Pran", 33),  new Produit("999", "Prnya", 33)).collect(Collectors.toList()));
        Assertions.assertEquals(2, produitService.retrieveAllProduits().size());
		}
    
	
	@Test
	public void saveProduitTest() {
		Produit pd = new Produit("999", "Pra", 33);
		when(produitRepo.save(pd)).thenReturn(pd);
		assertEquals(pd, produitService.addProduit(pd));
	}
	
	
	
	@Test
	public void deleteProduitTest() {
		Produit pe = new Produit("95", "Pr", 33);
		produitService.deletePr(pe);
		verify(produitRepo, times(1)).delete(pe);
	}
	
	
	
	
	

}
