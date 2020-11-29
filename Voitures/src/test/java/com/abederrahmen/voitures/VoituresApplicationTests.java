package com.abederrahmen.voitures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.abederrahmen.voitures.entities.Categorie;
import com.abederrahmen.voitures.entities.Voiture;
import com.abederrahmen.voitures.repos.VoitureRepository;
import com.abederrahmen.voitures.service.VoitureService;

@SpringBootTest
class VoituresApplicationTests {
	@Autowired
	private VoitureRepository voitureRepository;
	@Autowired
	private VoitureService voitureService;
	
	@Test
	public void testCreateProduit() {
	Voiture v = new Voiture("KIA picanto",new Date(),new Date(),2200.500);
	voitureRepository.save(v);
	}
	
	
	@Test
	public void testFindVoiture()
	{ Voiture v = voitureRepository.findById(1L).get(); System.out.println(v);
	}
	
	
	
	@Test
	public void testUpdateVoiture()
	{ Voiture v = voitureRepository.findById(1L).get();
	v.setPrixParking(1000.0); voitureRepository.save(v);
	}
	
	
	@Test
	public void testDeleteVoiture(){
		voitureRepository.deleteById(1L);;
	}
	
	
	
	@Test
	public void testListerTousVoiture()
	{
	List<Voiture> voi = voitureRepository.findAll();
	for (Voiture v : voi)
	{
	System.out.println(v);
	}
	}
	
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Voiture> v = voitureService.getAllVoituresParPage(0,2);
	System.out.println(v.getSize());
	System.out.println(v.getTotalElements());
	System.out.println(v.getTotalPages());
	v.getContent().forEach(voit -> {System.out.println(voit.toString());
	});
	/*ou bien
	for (Voiture v : voit)
	{
	System.out.println(v);
	} */
	}
	
	
	@Test
	public void findByMarqueVoiture()
	{
	List<Voiture> voit = voitureRepository.findByMarqueVoiture("KIA picanto");
	for (Voiture v : voit)
	{
	System.out.println(v);
	}
	}
	@Test
	public void findByMarqueVoitureContains ()
	{
	List<Voiture> voit=voitureRepository.findByMarqueVoitureContains("iphone X");
	for (Voiture v : voit)
	{
	System.out.println(v);
	} 
	}
	
	
	@Test public void findByMarquePrix()
	{
	List<Voiture> voit = voitureRepository.findByMarquePrix("KIA picanto", 2200.5);
	for (Voiture v : voit)
	{
	System.out.println(v);
	}
	}
	
	
	@Test
	public void findByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Voiture> voit =voitureRepository.findByCategorie(cat);
	for (Voiture v : voit)
	{
	System.out.println(v);
	}
	}
	
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Voiture> voit = voitureRepository.findByCategorieIdCat(1L);
	for (Voiture v : voit)
	{
	System.out.println(v);
	}
	}
	
	
	@Test
	public void findByOrderByMarqueVoitureAsc()
	{
	List<Voiture> voit = voitureRepository.findByOrderByMarqueVoitureAsc();
	for (Voiture v : voit)
	{
	System.out.println(v);
	}
	}
	
	
	@Test public void trierVoituresMarquePrix()
	{
	List<Voiture> voit = voitureRepository.trierVoituresMarquePrix();
	for (Voiture v : voit)
	{
	System.out.println(v);
	}
	}
	
	
	
}
