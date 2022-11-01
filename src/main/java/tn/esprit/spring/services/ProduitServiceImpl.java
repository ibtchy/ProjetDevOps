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
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		for (Produit produit : produits) {
			//log.info(" Produit : " + produit);
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
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long produitId) {
		Produit produit = produitRepository.findById(produitId).orElse(null);
		//log.info("produit :" + produit);
		return produit;
	}

//	@Override
//	public void assignProduitToStock(Long idProduit, Long idStock) {
//		Produit produit = produitRepository.findById(idProduit).orElse(null);
//		Stock stock = stockRepository.findById(idStock).orElse(null);
//		produit.setStock(stock);
//		produitRepository.save(produit);
//
//	}


}