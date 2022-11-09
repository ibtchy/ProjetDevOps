package tn.esprit.spring.services;




import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.repositories.CategorieProduitRepository;
import tn.esprit.repositories.ProduitRepository;
import tn.esprit.repositories.StockRepository;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Stock;

@Service
@Slf4j

public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits =  produitRepository.findAll();
		for (Produit produit : produits) {
			log.info(" Produit : " + produit);
		
		}
		return produits;
	}

	@Transactional
	public Produit addProduit(Produit p) {
		produitRepository.save(p);
		return p;
	}

	

	@Override
	public void deleteProduit(Long produitId) {
		produitRepository.deleteById(produitId);
	}
	@Override
	public void deletePr(Produit pr) {
		produitRepository.delete(pr);
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long produitId) {
		return produitRepository.findById(produitId).orElse(null);
		
		
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit produit = produitRepository.findById(idProduit).orElse(new Produit());
		Stock stock = stockRepository.findById(idStock).orElse(new Stock());
		produit.setStock(stock);
		produitRepository.save(produit);

	}


}