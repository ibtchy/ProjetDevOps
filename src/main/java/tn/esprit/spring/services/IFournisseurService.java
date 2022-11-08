package tn.esprit.spring.services;



import java.util.List;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.FournisseurDTO;

public interface IFournisseurService {

	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(FournisseurDTO f);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(FournisseurDTO f);

	Fournisseur retrieveFournisseur(Long id);
	
	void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur);

}
