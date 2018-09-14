package de.codemadness.strombergapi.service;

import de.codemadness.strombergapi.domain.Spruch;

public interface ISpruchService {

    Spruch getWithId(int id);

    Spruch getRandomSpruch();

}
