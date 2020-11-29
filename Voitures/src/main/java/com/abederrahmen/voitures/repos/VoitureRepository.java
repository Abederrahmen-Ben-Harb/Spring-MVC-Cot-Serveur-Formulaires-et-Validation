package com.abederrahmen.voitures.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.abederrahmen.voitures.entities.Categorie;
import com.abederrahmen.voitures.entities.Voiture;

@RepositoryRestResource(path = "rest")
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
		List<Voiture> findByMarqueVoiture(String marque);
		List<Voiture> findByMarqueVoitureContains(String marque);
		
		
		@Query
		("select v from Voiture v where v.marqueVoiture like %?1 and v.prixParking > ?2") List<Voiture> findByMarquePrix (String marque, Double prixParking);
		@Query("select v from Voiture v where v.categorie = ?1") List<Voiture> findByCategorie (Categorie categorie);
		List<Voiture> findByCategorieIdCat(Long id);
		List<Voiture> findByOrderByMarqueVoitureAsc();
		@Query("select v from Voiture v order by v.marqueVoiture ASC, v.prixParking DESC")
		List<Voiture> trierVoituresMarquePrix ();
		
		
		
}
