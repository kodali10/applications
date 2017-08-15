package com.kodali.dao;

import java.util.List;

import javax.sql.DataSource;

import com.kodali.beans.Offer;

public interface OfferDao {
	public void setDataSource(DataSource jdbc);

	public List<Offer> getOffers();

	public Offer getOffer(int id);

	public boolean createOffer(Offer offer);

	public int[] createOffers(List<Offer> offerList);

	public boolean updateOffer(Offer offer);

	public boolean deleteOffer(int id);

}
