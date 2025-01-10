package com.example.insta_backend.repository;

import com.example.insta_backend.util.Credentials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstaRepository extends MongoRepository<Credentials, String> {
}
