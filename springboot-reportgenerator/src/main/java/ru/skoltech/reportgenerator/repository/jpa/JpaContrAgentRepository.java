package ru.skoltech.reportgenerator.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skoltech.reportgenerator.model.ContrAgent;

/**
 * @author rost.
 */
@Repository
@Profile({"!mongodb", "!redis"})
public interface JpaContrAgentRepository extends JpaRepository<ContrAgent, String> {
}
