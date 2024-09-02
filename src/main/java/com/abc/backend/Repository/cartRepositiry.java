package com.abc.backend.Repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.cart;

@Repository
public interface cartRepositiry extends MongoRepository <cart, ObjectId>{
    List<cart> findByCustomerId(String customerId);
    Optional<cart> findByCustomerIdAndProductId(String customerId, String productId);
}
