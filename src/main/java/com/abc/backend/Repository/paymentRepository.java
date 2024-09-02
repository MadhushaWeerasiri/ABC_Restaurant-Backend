package com.abc.backend.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.payment;

@Repository
public interface paymentRepository extends MongoRepository <payment, ObjectId> {

}
