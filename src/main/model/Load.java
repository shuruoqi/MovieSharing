package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Load implements Loadable {

    public ArrayList<Movie> movies;

    public ArrayList<Movie> load(String textFile) throws IOException {
        movies = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(textFile));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            if (partsOfLine.get(1).equals("Public")) {
                Movie m = new PublicMovie();

                set(partsOfLine, m);
                movies.add(m);
            } else {
                Movie m = new VipMovie();

                set(partsOfLine, m);
                movies.add(m);
            }
        }
        return movies;
    }

    public void set(ArrayList<String> partsOfLine, Movie m) {
        m.setName(partsOfLine.get(0));
        m.setQuality(partsOfLine.get(2));
        m.setSize(Double.parseDouble(partsOfLine.get(3)));
    }

    public ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
