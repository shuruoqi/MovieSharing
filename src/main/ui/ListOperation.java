package ui;

import exception.RepetitionException;
import exception.UpcomingException;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListOperation {
    private Menu menu;
    public MovieOperation movieOperation;
    public WatchList watchList;
    public DownloadList downloadList;
    public CinemaList cinemaList;

    private Scanner scanner;

    void start() throws IOException {
        boolean loopState = true;
//        menu = new Menu();
        movieOperation = new MovieOperation();
        cinemaList = new CinemaList();
        watchList = new WatchList();
        downloadList = new DownloadList();
        scanner = new Scanner(System.in);

        loadAll();
//        System.out.println("Welcome!");
//        while (loopState) {
//            loopState = loop();
//        }
//        saveAll();
    }

    private void loadAll() throws IOException {
        cinemaList.load();
        watchList.load();
        downloadList.load();
    }

    void saveAll() throws IOException {
        cinemaList.save();
        watchList.save();
        downloadList.save();
    }

    private boolean loop() throws UpcomingException, RepetitionException {
        menu.printChoices();
        return evaluate(menu.getChoice());
    }

    public boolean evaluate(int choice) throws UpcomingException, RepetitionException {
        if (choice == 1) {
            watchList.showAll();
        } else if (choice == 2) {
            addMovie();
        } else if (choice == 3) {
            deleteMovie();
        } else if (choice == 4) {
            download();
        } else if (choice == 5) {
            upload();
        } else if (choice == 6) {
            String genreName = scanner.nextLine();
            printMoviesOfGivenGenre(genreName);
        } else if (choice == 7) {
            System.out.println("See you!");
            return false;
        }
        return true;
    }

    private void helper(MovieList movieList, String operation) throws RepetitionException, UpcomingException {
        String name = scanner.nextLine();
        Movie movie = searchMovie(name);
        movie.printInfo();
        movieList.add(movie);
        printSuccess(operation);
    }

    public Movie searchMovie(String name) {
        Movie movie = cinemaList.getMovie(name);
        return movie;
    }

    private void printQuestion(String operation) {
        System.out.println("Which movie would you like to " + operation + "?");
    }

    private void printSuccess(String operation) {
        System.out.println(operation + " successfully");
    }

    public void addMovie() throws UpcomingException, RepetitionException {
        String operation = "add";
//        printQuestion(operation);
//        try {
        helper(watchList, operation);
//        } catch (RepetitionException | UpcomingException e) {
//            watchList.printAlready(operation);
//        }
    }

    private void deleteMovie() {
        String operation = "delete";
        watchList.showAll();
        printQuestion(operation);
        String name = scanner.nextLine();
        watchList.delete(name);
        printSuccess(operation);
    }

    private void download() {
        String operation = "download";
        printQuestion(operation);
        try {
            helper(downloadList, operation);
        } catch (RepetitionException e) {
            downloadList.printAlready(operation);
        } catch (UpcomingException e) {
            System.out.println("Upcoming movies are not downloadable.");
        }
    }

    public void upload() throws RepetitionException, UpcomingException {
        String operation = "upload";
//        try {
        movieOperation.identifyType();
        movieOperation.enterInfo();
        cinemaList.add(movieOperation.movie);
        printSuccess(operation);
//        } catch (RepetitionException | UpcomingException e) {
//            cinemaList.printAlready(operation);
//        }
    }

    public ArrayList<String> printMoviesOfGivenGenre(String genreName) {
        ArrayList<String> result = new ArrayList<>();
//        System.out.println("Which movie Genre would you like to choose?");
//        String genreName = scanner.nextLine();
        for (Genre genre : cinemaList.genreMap.keySet()) {
            if (genre.equals(new Genre(genreName))) {
                for (Movie movie : genre.getMovies()) {
                    result.add(movie.getName());
                }
//                System.out.println(" ");
            }
        }
        return result;
    }
}
