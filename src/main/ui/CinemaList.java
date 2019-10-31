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
    private Scanner scanner;
    private String type;
    public HashMap<Genre, ArrayList<Movie>> genreMap = new HashMap<>();

    void upload() {
        try {
            identifyType();
            enterInfo();
            add(movie);
            System.out.println("Upload successfully!");
        } catch (ReputationException | VipException e) {
            printAlready();
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
        scanner = new Scanner(System.in);
        System.out.print("Name: ");
        choice = scanner.nextLine();
        movie.setName(choice);
    }

    private void enterQuality() {
        scanner = new Scanner(System.in);
        System.out.print("Quality: ");
        choice = scanner.nextLine();
        movie.setQuality(choice);
    }

    private void enterSize() {
        double choice;
        scanner = new Scanner(System.in);
        System.out.print("Size: ");
        choice = Double.parseDouble(scanner.nextLine());
        movie.setSize(choice);
    }

    private void enterGenre() {
        scanner = new Scanner(System.in);
        System.out.print("Enter the first genre:");
        choice = scanner.nextLine();
        movie.addGenre(new Genre(choice));
        scanner = new Scanner(System.in);
        System.out.print("[1] continue entering genre");
        System.out.print("[2] exit entering genre");
        String decision = scanner.nextLine();
        while (Integer.parseInt(decision) == 1) {
            System.out.print("Enter the next genre:");
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

    private void identifyType() {
        scanner = new Scanner(System.in);

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

    @Override
    public ArrayList<Movie> getList() {
        return movies;
    }

    @Override
    public void printAlready() {
        System.out.println("Already uploaded");
    }

}
