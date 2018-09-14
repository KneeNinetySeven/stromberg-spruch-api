package de.codemadness.strombergapi.service;

import de.codemadness.strombergapi.domain.Spruch;
import de.codemadness.strombergapi.repository.ISpruchRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class SpruchService implements ISpruchService {

    private final ISpruchRepository spruchRepository;

    public SpruchService(ISpruchRepository spruchRepository) {
        this.spruchRepository = spruchRepository;
    }

    @Override
    public Spruch getWithId(int id) {
        return spruchRepository.findById(id);
    }

    @Override
    public Spruch getRandomSpruch() {
        int randId = ThreadLocalRandom.current().nextInt(spruchRepository.getTotalCount());
        return spruchRepository.findById(randId);
    }
}
