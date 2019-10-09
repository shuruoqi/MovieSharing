package ui;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    WLOperation wloperation = new WLOperation();
    DLOperation dloperation = new DLOperation();
    Scanner scanner;
    boolean machineLoopState = true;

    public void machine() throws IOException {
        machineSetUp();
        while (machineLoopState) {
            chooseOperation();
            exit();
        }
    }

    public void machineSetUp() throws IOException {
        wloperation.operationSetUp();
        wloperation.start();
        dloperation.operationSetUp();
        dloperation.start();
    }

    public void printChoice() {
        System.out.println("[1] check watchlist");
        System.out.println("[2] add movie to watchlist");
        System.out.println("[3] delete movie to watchlist");
        System.out.println("[4] purchase movie");
    }

    public void chooseOperation() throws IOException {
        scanner = new Scanner(System.in);
        String choose;
        choose = scanner.nextLine();
        printChoice();
        if (choose.equals("1")) {
            wloperation.printNameList();
        } else if (choose.equals("2")) {
            wloperation.printNameList();
            wloperation.chooseMovieLoop();
            wloperation.printNameList();
        } else if (choose.equals("3")) {
            wloperation.printNameList();
            wloperation.deleteMovieLoop();
            wloperation.printNameList();
        } else if (choose.equals("4")) {
            dloperation.chooseMovieLoop();
            dloperation.printNameList();
        }
    }

    public boolean exit() {
        scanner = new Scanner(System.in);
        String choose = "";
        choose = scanner.nextLine();
        System.out.println("Exit? [Yes] [No]");
        if (choose.equals("Yes")) {
            return machineLoopState = false;
        } else {
            return machineLoopState = true;
        }
    }
}
