package ru.skoltech.reportgenerator.repository.mongodb;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.skoltech.reportgenerator.model.ContrAgent;

/**
 * @author rost.
 */
@Profile("mongodb")
public interface MongoContrAgentRepository extends MongoRepository<ContrAgent, String> {
}
