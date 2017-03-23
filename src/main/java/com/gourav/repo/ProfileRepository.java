package com.gourav.repo;

import org.springframework.stereotype.Repository;

import com.gourav.entity.Profile;
import com.gourav.util.DataBaseUtils;

@Repository
public class ProfileRepository {

	public void save(Profile profile) {
		
		DataBaseUtils.save(profile);
		
	}
}
