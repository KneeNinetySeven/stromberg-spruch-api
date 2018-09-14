package de.codemadness.strombergapi;

import de.codemadness.strombergapi.domain.Spruch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLoader {

    private final File file;

    public FileLoader(String filePath) {
        file = new File(filePath);
    }

    public List<Spruch> loadFromFile() throws IOException {
        List<Spruch> spruchList = new ArrayList<>();


        Scanner scanner = new Scanner(file);

        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            String lineContent = scanner.nextLine();
            if (lineContent.startsWith("#")) continue;
            spruchList.add(new Spruch(lineNumber, lineContent));
            lineNumber++;
        }


        return spruchList;
    }
}
