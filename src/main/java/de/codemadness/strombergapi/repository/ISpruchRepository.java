package de.codemadness.strombergapi.repository;

import de.codemadness.strombergapi.domain.Spruch;

public interface ISpruchRepository {

    Spruch findById(int id);

    int getTotalCount();
}
