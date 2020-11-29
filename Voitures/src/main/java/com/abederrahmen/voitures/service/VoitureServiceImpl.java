package com.abederrahmen.voitures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.abederrahmen.voitures.entities.Categorie;
import com.abederrahmen.voitures.entities.Voiture;
import com.abederrahmen.voitures.repos.VoitureRepository;


@Service
public class VoitureServiceImpl implements VoitureService{

	@Autowired
	VoitureRepository voitureRepository;
	
	@Override
	public Voiture saveVoiture(Voiture v) {
		return voitureRepository.save(v);
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		return voitureRepository.save(v);
	}

	@Override
	public void deleteVoiture(Voiture v) {
		voitureRepository.delete(v);
		
	}

	@Override
	public void deleteVoitureById(Long id) {
		voitureRepository.deleteById(id);
	}

	@Override
	public Voiture getVoiture(Long id) {
		return voitureRepository.findById(id).get();
	}

	@Override
	public List<Voiture> getAllVoitures() {
		return voitureRepository.findAll();
	}

	@Override
	public Page<Voiture> getAllVoituresParPage(int page, int size) {
		return voitureRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Voiture> findByMarqueVoiture(String marque) {
	return voitureRepository.findByMarqueVoiture(marque);
	}
	@Override public List<Voiture> findByMarqueVoitureContains(String marque) {
	return voitureRepository.findByMarqueVoitureContains(marque);
	}
	@Override
	public List<Voiture> findByMarquePrix(String marque, Double prixParking) {
		return voitureRepository.findByMarquePrix(marque, prixParking);
	}
	@Override
	public List<Voiture> findByCategorie(Categorie categorie) {
	return voitureRepository.findByCategorie(categorie);
	}
	@Override
	public List<Voiture> findByCategorieIdCat(Long id) {
	return voitureRepository.findByCategorieIdCat(id);
	}
	@Override
	public List<Voiture> findByOrderByMarqueVoitureAsc() {
	return voitureRepository.findByOrderByMarqueVoitureAsc();
	}
	@Override
	public List<Voiture> trierVoituresMarquePrix() {
	return voitureRepository.trierVoituresMarquePrix();
	}

}
