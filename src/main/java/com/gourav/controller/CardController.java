package com.gourav.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gourav.entity.CardDetail;
import com.gourav.service.CardService;

@Controller
@RequestMapping("/spring")
public class CardController {
	
	@Autowired
	CardService cardService;
	
	@RequestMapping(value = "/saveCard", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveCard(@RequestBody CardDetail cardDetail) {
		cardService.saveCard(cardDetail);
		List<CardDetail> cardDetails = new ArrayList<CardDetail>();
		cardDetails.add(cardDetail);
		return new ResponseEntity<List<CardDetail>>(cardDetails, HttpStatus.OK);
	}
	
}
