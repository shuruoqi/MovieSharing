package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Load {

    public ArrayList<Movie> movies;

    public ArrayList<Movie> load(String textFile) throws IOException {
        movies = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(textFile));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnComma(line);
            if (partsOfLine.get(1).equals("Public")) {
                Movie m = new PublicMovie();

                set(partsOfLine, m);
                movies.add(m);
            } else {
                Movie m = new UpcomingMovie();

                set(partsOfLine, m);
                movies.add(m);
            }
        }
        return movies;
    }

    public void set(ArrayList<String> partsOfLine, Movie m) {
        m.setName(partsOfLine.get(0));
        m.setDate(Integer.parseInt(partsOfLine.get(2)));
        ArrayList<String> genrePart = splitOnSpace(partsOfLine.get(3));
        for (String next : genrePart) {
            Genre genre = new Genre(next);
            m.addGenre(genre);
        }
    }

    public ArrayList<String> splitOnComma(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
