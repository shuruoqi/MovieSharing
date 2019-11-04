package ui;

import exception.ReputationException;
import exception.VipException;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CinemaList extends MovieList {
    public Movie movie;
    private String choice;
    private Scanner scanner = new Scanner(System.in);
    private String type;
    public HashMap<Genre, ArrayList<Movie>> genreMap = new HashMap<>();

    void upload() {
        try {
            identifyType();
            enterInfo();
            add(movie);
            System.out.println("Upload successfully!");
        } catch (ReputationException | VipException e) {
            printAlready("upload");
        }
    }

    private void enterInfo() {
        enterName();
        enterQuality();
        enterSize();
        enterGenre();
        updateMap(movie);
    }

    private void enterName() {
        System.out.print("Name: ");
        choice = scanner.nextLine();
        movie.setName(choice);
    }

    private void enterQuality() {
        System.out.print("Quality: ");
        choice = scanner.nextLine();
        movie.setQuality(choice);
    }

    private void enterSize() {
        double choice;
        System.out.print("Size: ");
        choice = Double.parseDouble(scanner.nextLine());
        movie.setSize(choice);
    }

    private void enterGenre() {
        String decision = "1";
        while (Integer.parseInt(decision) == 1) {
            System.out.print("Enter genre:");
            choice = scanner.nextLine();
            movie.addGenre(new Genre(choice));
            System.out.print("[1] continue entering genre");
            System.out.print("[2] exit entering genre");
            decision = scanner.nextLine();
        }
    }

    private void updateMap(Movie movie) {
        for (Genre genre : movie.getGenres()) {
            if (genreMap.containsKey(genre)) {
                ArrayList<Movie> originalList = genreMap.get(genre);
                originalList.add(movie);
            } else {
                genreMap.put(genre, genre.getMovies());
            }
        }
    }

    public void printMoviesOfGivenGenre() {
        System.out.println("Which movie Genre would you like to choose?");
        String genreName = scanner.nextLine();
        for (Genre genre : genreMap.keySet()) {
            if (genre.equals(new Genre(genreName))) {
                for (Movie movie : genre.getMovies()) {
                    System.out.print(movie.getName() + "; ");
                }
                System.out.println(" ");
            }
        }
    }

    private void identifyType() {
        System.out.print("Type: ");
        type = scanner.nextLine();
        chooseTypeResult();
    }

    public void chooseTypeResult() {
        if (type.equals("Public")) {
            movie = new PublicMovie();
        } else if (type.equals("VIP")) {
            movie = new VipMovie();
        }
    }

    public void helper(MovieList movieList, String operation) throws ReputationException, VipException, IOException {
        scanner = new Scanner(System.in);
        load();
        System.out.println("Which movie would you like to " + operation + "?");
        String name = scanner.nextLine();
        Movie movie = getMovie(name);
        movie.printInfo();
        movieList.add(movie);
        System.out.println(operation + " successfully");
    }

    @Override
    public void load() throws IOException {
        movies = load.load("./data/CinemaListFile.txt");
        for (Movie movie : movies) {
            updateMap(movie);
        }
    }
    @Override
    public void save() throws IOException {
        save.save(movies, "./data/CinemaListFile.txt");
    }
}
