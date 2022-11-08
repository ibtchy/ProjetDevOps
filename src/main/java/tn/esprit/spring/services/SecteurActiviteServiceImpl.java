package tn.esprit.spring.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.SecteurActiviteDTO;
import tn.esprit.spring.repositories.SecteurActiviteRepository;
import tn.esprit.spring.entities.SecteurActivite;


@Service
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	@Override
	public List<SecteurActivite> retrieveAllSecteurActivite() {
		return (List<SecteurActivite>) secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActivite addSecteurActivite(SecteurActiviteDTO sa) {
		secteurActiviteRepository.save(sa);
		return sa;
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);
		
	}

	@Override
	public SecteurActivite updateSecteurActivite(SecteurActiviteDTO sa) {
		return secteurActiviteRepository.save(sa);

	}

	@Override
	public SecteurActivite retrieveSecteurActivite(Long id) {
		return secteurActiviteRepository.findById(id).orElse(null);

	}

}
