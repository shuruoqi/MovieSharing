package ui;

import model.*;

import java.util.Scanner;

public class MovieOperation {
    public CinemaList cinemaList = new CinemaList();
    public Movie movie;
    private String choice;
    private Scanner scanner = new Scanner(System.in);
    private String type;

    public void enterInfo() {
        enterName();
        enterQuality();
        enterSize();
        enterGenre();
        cinemaList.updateMap(movie);
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

    public void identifyType() {
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
}
