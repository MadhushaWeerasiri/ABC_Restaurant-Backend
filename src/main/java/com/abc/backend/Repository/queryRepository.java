package com.abc.backend.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.query;

@Repository
public interface queryRepository extends MongoRepository <query, ObjectId> {

}
