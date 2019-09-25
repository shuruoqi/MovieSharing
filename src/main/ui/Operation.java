package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Operation {
    public ArrayList<Movie> movieList; //field

    Movie spiderman = new Movie("Spiderman",1430,15);
    Movie ironman = new Movie("Ironman",1630,16);
    Movie captainAmerica = new Movie("Captain America",1700,16);
    Movie thor = new Movie("Thor",1400,17);

    //EFFECTS: Build a new list and add objects into it
    public void operationSetUp() {
        movieList = new ArrayList<>(); //field

        movieList.add(spiderman);
        movieList.add(ironman);
        movieList.add(captainAmerica);
        movieList.add(thor);
    }

    //REQUIRES: the input equals to the movie's name
    //EFFECTS: execute printAll() method to the given movie
    public void chooseMovie() {

        Scanner s;
        s = new Scanner(System.in); //field
        String choose = ""; //field
        System.out.println("Which movie would you like to watch?");
        choose = s.nextLine();
        for (Movie next : movieList) { //loop
            if (choose.equals(next.getName())) { //condition
                printAll(next);
            }
        }
    }

    //EFFECTS: print out all the information of the given movie
    public void printAll(Movie m) {
        System.out.println("Movie name:" + m.getName());
        System.out.println("Price:" + m.getPrice());
        System.out.println("Show time:" + m.getShowTime());
    }
}
