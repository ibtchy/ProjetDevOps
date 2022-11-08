package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.SecteurActivite;
import tn.esprit.spring.entities.SecteurActiviteDTO;


public interface ISecteurActiviteService {

	List<SecteurActivite> retrieveAllSecteurActivite();

	SecteurActivite addSecteurActivite(SecteurActiviteDTO sa);

	void deleteSecteurActivite(Long id);

	SecteurActivite updateSecteurActivite(SecteurActiviteDTO sa);

	SecteurActivite retrieveSecteurActivite(Long id);

}
