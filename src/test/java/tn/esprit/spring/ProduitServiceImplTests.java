package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.repositories.ProduitRepository;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.ProduitServiceImpl;

@Slf4j
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
                .of(new Produit("999", "Pranya", 33),  new Produit("999", "Pranya", 33)).collect(Collectors.toList()));
        Assertions.assertEquals(2, produitService.retrieveAllProduits().size());
		}
    
	
	@Test
	public void saveProduitTest() {
		Produit pd = new Produit("999", "Pranya", 33);
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
