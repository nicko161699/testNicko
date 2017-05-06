package com.nicko.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicko.spring.dao.OffersDao;
import com.nicko.spring.model.Offer;

@Service("OfferService")
public class OfferService {

	@Autowired
	private OffersDao dao;

	public List<Offer> getOffers() {
		return dao.getOffers();
	}

	public OffersDao getDao() {
		return dao;
	}

	public void setDao(OffersDao dao) {
		this.dao = dao;
	}

}
