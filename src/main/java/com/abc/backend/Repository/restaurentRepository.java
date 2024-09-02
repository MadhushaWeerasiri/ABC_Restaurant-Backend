package com.abc.backend.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.restaurent;

@Repository
public interface restaurentRepository extends MongoRepository <restaurent, ObjectId> {

}
