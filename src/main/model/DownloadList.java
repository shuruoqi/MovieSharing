package model;

import exception.ReputationException;
import exception.VipException;
import ui.CinemaList;
import java.io.IOException;

public class DownloadList extends MovieList {

    public void add(Movie movie) throws ReputationException, VipException {
        if (checkRepetition(movie)) {
            throw new ReputationException();
        } else if (movie.getType().equals("VIP")) {
            throw new VipException();
        } else {
            movies.add(movie);
        }
    }

    public void download() throws IOException {
        String operation = "download";
        CinemaList cinemaList = new CinemaList();
        try {
            cinemaList.helper(this, operation);
        } catch (ReputationException e) {
            printAlready(operation);
        } catch (VipException e) {
            System.out.println("VIP movies are not downloadable, but they are accessible online.");
        } finally {
            System.out.println("Enjoy the movie!");
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
