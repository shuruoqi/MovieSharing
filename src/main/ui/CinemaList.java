package ui;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CinemaList extends MovieList {
    public Movie movie;
    private String choice;
    private Scanner scanner;
    private String type;

    void upload() {
        identifyType();
        enterInfo();
        add(movie);
        System.out.println("Upload successfully!");
    }

    private void enterInfo() {
        enterName();
        enterQuality();
        enterSize();
    }

    private void enterName() {
        scanner = new Scanner(System.in);
        System.out.print("Name: ");
        choice =  scanner.nextLine();
        movie.setName(choice);
    }

    private void enterQuality() {
        scanner = new Scanner(System.in);
        System.out.print("Quality: ");
        choice =  scanner.nextLine();
        movie.setQuality(choice);
    }

    private void enterSize() {
        double choice;
        scanner = new Scanner(System.in);
        System.out.print("Size: ");
        choice = Double.parseDouble(scanner.nextLine());
        movie.setSize(choice);
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
        Loadable loadCL = new Load();
        movies = loadCL.load("./data/CinemaListFile.txt");
    }

    @Override
    public void save() throws IOException {
        Savable save = new Save();
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
