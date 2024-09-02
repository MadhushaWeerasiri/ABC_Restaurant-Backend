package com.abc.backend.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.user;

@Repository
public interface userRepository extends MongoRepository <user, ObjectId> {
    Optional<user> findByEmail(String email);
}

