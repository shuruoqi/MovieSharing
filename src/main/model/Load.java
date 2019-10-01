package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Load implements Loadable {

    public ArrayList<Movie> movies;

    public ArrayList<Movie> load(String textfile) throws IOException {
        movies = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(textfile));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            Movie m = new Movie(partsOfLine.get(0),
                    Integer.parseInt(partsOfLine.get(1)),
                    Integer.parseInt(partsOfLine.get(2)));
            movies.add(m);
        }
        return movies;
    }

    public ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
