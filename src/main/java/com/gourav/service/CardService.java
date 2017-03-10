package com.gourav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourav.entity.CardDetail;
import com.gourav.repo.CardRepository;

@Service
public class CardService {
	
	@Autowired
	CardRepository cardRepository;

	public void saveCard(CardDetail cardDetail) {
		// TODO Auto-generated method stub
		cardRepository.save(cardDetail);
	}
}
