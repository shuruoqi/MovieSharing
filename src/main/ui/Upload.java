package ui;

import model.Movie;
import model.Movielist;
import model.RegularMovie;
import model.VipMovie;

import java.util.ArrayList;
import java.util.Scanner;

public class Upload extends Movielist {
    public ArrayList<Movie> uploadList;
    boolean uploadMovieLoopState = true;
    Scanner scanner;

    @Override
    public void listSetUp() {
        uploadList = new ArrayList<Movie>();
    }

    @Override
    public ArrayList<Movie> getList() {
        return uploadList;
    }

    @Override
    public void startScannerQ() {
        System.out.println("Upload movies?");
    }

    public String chooseTypeScanner() {
        scanner = new Scanner(System.in);
        System.out.println("Please define the type of the movie. [regular] [VIP]");
        return scanner.nextLine();
    }

    public Movie chooseTypeResult(String choice) {
        Movie m;
        if (choice.equals("regular")) {
            m = new RegularMovie("","",0);
        } else {
            m = new VipMovie("","",0);
        }
        return m;
    }

    public Movie enterInfo(Movie m) {
        enterName(m);
        enterQuality(m);
        enterSize(m);
        return m;
    }

    public void enterName(Movie m) {
        String choice;
        scanner = new Scanner(System.in);
        System.out.println("Name:");
        choice =  scanner.nextLine();
        m.setName(choice);
    }

    public void enterQuality(Movie m) {
        String choice;
        scanner = new Scanner(System.in);
        System.out.println("Quality:");
        choice =  scanner.nextLine();
        m.setQuality(choice);
    }

    public void enterSize(Movie m) {
        double choice;
        scanner = new Scanner(System.in);
        System.out.println("Size:");
        choice = Double.parseDouble(scanner.nextLine());
        m.setSize(choice);
    }


    @Override
    public void chooseMovieScannerQ() {
        System.out.println("Which movie would you like to upload?");
    }

    @Override
    public void addToListScannerQ() {
        System.out.println("Start upload? [Yes] [No]");
    }

    @Override
    public void continueToChooseMovieScannerQ() {
        System.out.println("Upload another movie? [Yes] [No]");
    }

    @Override
    public Boolean continueToChooseMovieResult(String choice) {
        if (choice.equals("Yes")) {
            return uploadMovieLoopState = true;
        } else {
            return uploadMovieLoopState = false;
        }
    }

    @Override
    public void printAlready() {
        System.out.println("Already uploaded.");
    }
}
