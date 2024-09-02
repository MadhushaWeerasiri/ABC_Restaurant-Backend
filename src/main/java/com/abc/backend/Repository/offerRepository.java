package com.abc.backend.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.offer;

@Repository
public interface offerRepository extends MongoRepository <offer, ObjectId> {

}
