package ru.skoltech.reportgenerator;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import ru.skoltech.reportgenerator.config.SpringApplicationContextInitializer;

/**
 * @author rost.
 */

@SpringBootApplication
public class ApplicationMain {
    public static void main(String ... args){
        new SpringApplicationBuilder(ApplicationMain.class)
                .initializers(new SpringApplicationContextInitializer())
                .application()
                .run(args);
    }
}
