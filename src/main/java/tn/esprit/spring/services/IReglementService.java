package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Reglement;
import tn.esprit.spring.entities.ReglementDTO;


public interface IReglementService {

	List<Reglement> retrieveAllReglements();
	Reglement addReglement(ReglementDTO r);
	Reglement retrieveReglement(Long id);
	List<Reglement> retrieveReglementByFacture(Long idFacture);
	float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate); 

}
