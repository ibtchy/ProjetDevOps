package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.ProduitDTO;


public interface IProduitService {

	List<Produit> retrieveAllProduits();

	Produit addProduit(ProduitDTO p);

	void deleteProduit(Long id);

	Produit updateProduit(ProduitDTO p);

	Produit retrieveProduit(Long id);

	void assignProduitToStock(Long idProduit, Long idStock);

}