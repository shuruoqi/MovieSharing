package model;

import exception.RepetitionException;
import exception.UpcomingException;
import java.io.IOException;

public class DownloadList extends MovieList {

    public void add(Movie movie) throws RepetitionException, UpcomingException {
        if (checkRepetition(movie)) {
            throw new RepetitionException();
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
