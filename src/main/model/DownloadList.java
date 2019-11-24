package model;

import exception.RepetitionException;
import exception.UpcomingException;
import java.io.IOException;

public class DownloadList extends MovieList {

    //EFFECTS: Add the given movie to the movie list.
    //         If the movie is already in the movie list, throw RepetitionException
    //         If the movie type is Upcoming, throw UpcomingException
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
    //EFFECTS: load all the movies into the movie list
    //MODIFIES: this
    public void load() throws IOException {
        movies = load.load("./data/DownloadListFile.txt");
    }

    @Override
    //EFFECTS: save all the movies from the movie list
    public void save() throws IOException {
        save.save(movies, "./data/DownloadListFile.txt");
    }
}
