package com.abederrahmen.voitures.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.abederrahmen.voitures.entities.Categorie;
import com.abederrahmen.voitures.entities.Voiture;

public interface VoitureService {
	
	 Voiture saveVoiture(Voiture v);
	 Voiture updateVoiture(Voiture v);
	 void deleteVoiture(Voiture v);
	 void deleteVoitureById(Long id);
	 Voiture getVoiture(Long id);
	 List<Voiture> getAllVoitures();
	 
	 List<Voiture> findByMarqueVoiture(String marque);
	 List<Voiture> findByMarqueVoitureContains(String marque);
	 List<Voiture> findByMarquePrix (String marque, Double prixParking);
	 List<Voiture> findByCategorie (Categorie categorie);
	 List<Voiture> findByCategorieIdCat(Long id);
	 List<Voiture> findByOrderByMarqueVoitureAsc();
	 List<Voiture> trierVoituresMarquePrix();
	 
	 Page<Voiture> getAllVoituresParPage(int page, int size);

}
