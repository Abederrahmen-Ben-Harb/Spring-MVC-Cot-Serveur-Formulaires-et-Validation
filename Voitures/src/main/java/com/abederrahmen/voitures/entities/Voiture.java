package com.abederrahmen.voitures.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Voiture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoiture;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String marqueVoiture;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateArrive;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateSortie;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixParking;
	
	@ManyToOne
	private Categorie categorie;
	
	
	
	public Voiture() {
		super();
	}
	
	
	
	public Voiture(String marqueVoiture, Date dateArrive, Date dateSortie, Double prixParking) {
		super();
		this.marqueVoiture = marqueVoiture;
		this.dateArrive = dateArrive;
		this.dateSortie = dateSortie;
		this.prixParking = prixParking;
	}



	public Long getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}
	public String getMarqueVoiture() {
		return marqueVoiture;
	}
	public void setMarqueVoiture(String marqueVoiture) {
		this.marqueVoiture = marqueVoiture;
	}
	public Date getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public Double getPrixParking() {
		return prixParking;
	}
	public void setPrixParking(Double prixParking) {
		this.prixParking = prixParking;
	}



	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", marqueVoiture=" + marqueVoiture + ", dateArrive=" + dateArrive
				+ ", dateSortie=" + dateSortie + ", prixParking=" + prixParking + "]";
	}



	public Categorie getCategorie() {
		return categorie;
	}



	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	

}
