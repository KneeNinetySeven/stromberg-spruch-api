package de.codemadness.strombergapi.repository;

import de.codemadness.strombergapi.FileLoader;
import de.codemadness.strombergapi.domain.Spruch;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class SpruchRepository implements ISpruchRepository {

    private List<Spruch> sprüche;
    private static final String filePath = "sprueche";

    public SpruchRepository() {
        sprüche = new CopyOnWriteArrayList<>();
    }

    @PostConstruct
    private void loadFromFile() throws IOException {
        List<Spruch> spruches = new FileLoader(filePath).loadFromFile();
        sprüche.addAll(spruches);
    }


    @Override
    public Spruch findById(int id) {
        Optional<Spruch> firstFound = sprüche.stream().filter(spruch -> spruch.getId() == id).findFirst();
        return firstFound.orElse(null);
    }

    @Override
    public int getTotalCount() {
        return sprüche.size();
    }
}
