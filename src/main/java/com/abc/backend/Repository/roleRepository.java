package com.abc.backend.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.Model.role;

@Repository
public interface roleRepository extends MongoRepository <role, Integer> {
    Optional<role> findByRoleID(int roleID);
}
