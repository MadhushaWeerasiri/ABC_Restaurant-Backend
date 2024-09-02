package com.abc.backend.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.product;

@Repository
public interface productRepository extends MongoRepository <product, ObjectId> {

}
