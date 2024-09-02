package com.abc.backend.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.reservation;

@Repository
public interface reservationRepository extends MongoRepository <reservation, ObjectId> {
    Optional<reservation> findByCustomerId(String customerId);
}
