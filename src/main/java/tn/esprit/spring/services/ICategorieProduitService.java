package tn.esprit.spring.services;


import java.util.List;

import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.entities.CategorieProduitdto;


public interface ICategorieProduitService {

	List<CategorieProduit> retrieveAllCategorieProduits();

	CategorieProduit addCategorieProduit(CategorieProduitdto cp);

	void deleteCategorieProduit(Long id);

	CategorieProduit updateCategorieProduit(CategorieProduitdto cp);

	CategorieProduit retrieveCategorieProduit(Long id);

}
