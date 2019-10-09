package ui;

import model.Movie;
import model.Movielist;
import java.util.ArrayList;
import java.util.Scanner;

public class Downloadlist extends Movielist {
    public ArrayList<Movie> downloadList;
    boolean downloadMovieLoopState = true;
    Scanner scanner;

    @Override
    public void listSetUp() {
        downloadList = new ArrayList<Movie>();
    }

    @Override
    public ArrayList<Movie> getList() {
        return downloadList;
    }


    @Override
    public void startScannerQ() {
        System.out.println("Download movies?");
    }

    @Override
    public void chooseMovieScannerQ() {
        System.out.println("Which movie would you like to download?");
    }

    @Override
    public void addToListScannerQ() {
        System.out.println("Start download? [Yes] [No]");
    }

    @Override
    public void continueToChooseMovieScannerQ() {
        System.out.println("Download another movie? [Yes] [No]");
    }

    @Override
    public Boolean continueToChooseMovieResult(String choice) {
        if (choice.equals("Yes")) {
            return downloadMovieLoopState = true;
        } else {
            return downloadMovieLoopState = false;
        }
    }

    @Override
    public void printAlready() {
        System.out.println("Already downloaded.");
    }
}
