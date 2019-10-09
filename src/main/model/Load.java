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
            if (partsOfLine.get(1).equals("regular")) {
                Movie m = new RegularMovie(partsOfLine.get(0),
                        (partsOfLine.get(2)),
                        Double.parseDouble(partsOfLine.get(3)));
                movies.add(m);
            } else {
                Movie m = new VipMovie(partsOfLine.get(0),
                        (partsOfLine.get(2)),
                        Double.parseDouble(partsOfLine.get(3)));
                movies.add(m);
            }
        }
        return movies;
    }

    public ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
