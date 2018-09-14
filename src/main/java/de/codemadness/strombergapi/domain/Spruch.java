package de.codemadness.strombergapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Spruch {

    @JsonProperty("_id")
    private int id;

    private String spruch;

}
