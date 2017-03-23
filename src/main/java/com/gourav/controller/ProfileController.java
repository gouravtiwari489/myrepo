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

import com.gourav.entity.Profile;
import com.gourav.service.ProfileService;

@Controller
@RequestMapping("/spring")
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveCard(@RequestBody Profile profile) {
		profileService.saveProfile(profile);
		List<Profile> profileDetails = new ArrayList<Profile>();
		profileDetails.add(profile);
		return new ResponseEntity<List<Profile>>(profileDetails, HttpStatus.OK);
	}
	

}
