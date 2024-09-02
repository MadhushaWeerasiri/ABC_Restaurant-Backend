package com.abc.backend.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.productCategory;

@Repository
public interface productCategoryRepository extends MongoRepository <productCategory, ObjectId> {
    Optional<productCategory> findByCategoryId(int categoryId);
}
