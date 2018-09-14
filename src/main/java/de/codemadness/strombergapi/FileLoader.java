package de.codemadness.strombergapi;

import de.codemadness.strombergapi.domain.Spruch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileLoader {

    private final String fileName;

    public FileLoader(String filePath) {
        fileName = filePath;
    }

    public List<Spruch> loadFromFile() throws IOException {
        List<Spruch> spruchList = new ArrayList<>();


        Scanner scanner = new Scanner(new FileInputStream(fileName), "UTF-8");
		scanner.useLocale(new Locale("de", "DE"));

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
