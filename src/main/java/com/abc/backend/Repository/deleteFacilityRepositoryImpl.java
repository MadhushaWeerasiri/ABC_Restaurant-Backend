package com.abc.backend.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.facility;

@Repository
public class deleteFacilityRepositoryImpl implements deleteFacilityRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void deleteByFacilityId(int facilityId) {
        Query query = new Query(Criteria.where("facilityId").is(facilityId));
        mongoTemplate.remove(query, facility.class);
    }
}
