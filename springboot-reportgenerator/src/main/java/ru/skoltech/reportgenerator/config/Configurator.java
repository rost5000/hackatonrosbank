package ru.skoltech.reportgenerator.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import ru.skoltech.reportgenerator.model.User;

/**
 * @author rost.
 */
@Configuration
@EntityScan(basePackageClasses = User.class)
public class Configurator {
}
