package ru.skoltech.reportgenerator.repository.mongodb;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.skoltech.reportgenerator.model.User;

@Repository
@Profile("mongodb")
public interface MongoUserRepository extends MongoRepository<User, String> {
}