package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Operateur;
import tn.esprit.spring.entities.OperateurDTO;


public interface IOperateurService {

	List<Operateur> retrieveAllOperateurs();

	Operateur addOperateur(OperateurDTO o);

	void deleteOperateur(Long id);

	Operateur updateOperateur(OperateurDTO o);

	Operateur retrieveOperateur(Long id);

}
