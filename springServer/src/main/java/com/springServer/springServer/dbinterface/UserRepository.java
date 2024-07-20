package com.springServer.springServer.dbinterface;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springServer.springServer.modal.UserModal;

public interface UserRepository extends MongoRepository<UserModal, String> {
    boolean existsByEmail(String email);
    UserModal findByEmail(String email);
}
