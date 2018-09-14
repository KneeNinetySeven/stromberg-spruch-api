package de.codemadness.strombergapi;

import de.codemadness.strombergapi.repository.ISpruchRepository;
import de.codemadness.strombergapi.repository.SpruchRepository;
import de.codemadness.strombergapi.service.ISpruchService;
import de.codemadness.strombergapi.service.SpruchService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ISpruchService injectService(ISpruchRepository spruchRepository){
        return new SpruchService(spruchRepository);
    }

    @Bean
    public ISpruchRepository injectRepository(){
        return new SpruchRepository();
    }

}
