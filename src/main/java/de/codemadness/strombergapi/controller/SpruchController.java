package de.codemadness.strombergapi.controller;

import de.codemadness.strombergapi.domain.Spruch;
import de.codemadness.strombergapi.service.SpruchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpruchController {

    private SpruchService spruchService;

    @Autowired
    public SpruchController(SpruchService spruchService) {
        this.spruchService = spruchService;
    }

    @GetMapping(path = "/v1/random", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Spruch> getRandomSpruch() {
        return ResponseEntity.ok(spruchService.getRandomSpruch());
    }

    @GetMapping(path = "/v1/spruch/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Spruch> getSpruch(@PathVariable Integer id) {
        Spruch spruchWithId = spruchService.getWithId(id);
        return spruchWithId == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(spruchWithId);
    }
}
