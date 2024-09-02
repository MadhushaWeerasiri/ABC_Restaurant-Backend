package com.abc.backend.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.facility;

@Repository
public interface facilityRepository extends MongoRepository <facility, ObjectId>, deleteFacilityRepository  {
    Optional<facility> findByFacilityId(int facilityId);
}
