package model;

import exception.ReputationException;
import exception.UpcomingException;
import java.io.IOException;

public class DownloadList extends MovieList {

    public void add(Movie movie) throws ReputationException, UpcomingException {
        if (checkRepetition(movie)) {
            throw new ReputationException();
        } else if (movie.getType().equals("Upcoming")) {
            throw new UpcomingException();
        } else {
            movies.add(movie);
        }
    }

    @Override
    public void load() throws IOException {
        movies = load.load("./data/DownloadListFile.txt");
    }

    @Override
    public void save() throws IOException {
        save.save(movies, "./data/DownloadListFile.txt");
    }
}
