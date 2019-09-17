package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Machine {
    public ArrayList<Movie> movieList;
    public Scanner scanner;

    public static void main(String[] args) {
        Operation operation = new Operation(); //local
        welcome();
        operation.chooseMovie();
        bye();
    }

    public static void welcome() {
        System.out.println("Welcome!");
    }

    public static void bye() {
        System.out.println("Bye!");
    }

}
