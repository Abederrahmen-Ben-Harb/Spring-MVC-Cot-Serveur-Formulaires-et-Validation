package com.abederrahmen.voitures.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "marquVoit", types = { Voiture.class })
public interface ProduitProjection {
	public String getMarqueVoiture();
}
