package com.kodali.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodali.beans.Offer;
import com.kodali.daoImpl.OfferDaoImpl;

@Service("offersService")
public class OffersService {
	private OfferDaoImpl offersDao;

	@Autowired
	public void setOffersDao(OfferDaoImpl offersDaoImpl) {
		this.offersDao = offersDaoImpl;
	}
	
	public List<Offer> getCurrentoffers(){
		return offersDao.getOffers();
	}
	
	public void create(Offer offer) {
		offersDao.createOffer(offer);
	}
}
