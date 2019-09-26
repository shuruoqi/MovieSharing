package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Machine {
    public ArrayList<Movie> movieList;
    public Scanner scanner;

    public static void main(String[] args) {
        Operation operation = new Operation(); //local
        Loop loop = new Loop();
        System.out.println("Welcome!");
        loop.operationLoop();
        System.out.println("Bye!");
    }
}
