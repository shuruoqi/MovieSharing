package ui;

import java.util.Scanner;

public class Menu {
    public void printChoices() {
        System.out.println("[1] check watchlist");
        System.out.println("[2] add to watchlist");
        System.out.println("[3] delete from watchlist");
        System.out.println("[4] download");
        System.out.println("[5] upload");
        System.out.println("[6] Movie Genres");
        System.out.println("[7] exit");
    }

    public Integer getChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }
}