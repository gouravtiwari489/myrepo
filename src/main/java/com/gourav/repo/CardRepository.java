package com.gourav.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import com.gourav.entity.CardDetail;

@Repository
public class CardRepository {
	
	@Autowired
	MongoOperations mongoOperations;

	public void save(CardDetail cardDetail) {
		mongoOperations.save(cardDetail);
	}

}
