package ui;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        CinemaList cinemaList = new CinemaList();

        cinemaList.load();
        cinemaList.showAll();
        menu.start();
    }
}
