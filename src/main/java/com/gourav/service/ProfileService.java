package com.gourav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gourav.entity.Profile;
import com.gourav.repo.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	public void saveProfile(Profile profile) {
		profileRepository.save(profile);
	}
}
