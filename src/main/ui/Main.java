package ui;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Watchlist.WLOperation wloperation = new Watchlist.WLOperation();
        Downloadlist.DLOperation dloperation = new Downloadlist.DLOperation();
        Cinemalist.CLOperation cloperation = new Cinemalist.CLOperation();
        System.out.println("Welcome!");
        cloperation.operationSetUp();
        cloperation.chooseMovieLoop();
        wloperation.operationSetUp();
        wloperation.start();
        wloperation.chooseMovieLoop();
        wloperation.printNameList();
        wloperation.deleteMovieLoop();
        wloperation.printNameList();
        dloperation.operationSetUp();
        dloperation.start();
        dloperation.chooseMovieLoop();
        dloperation.printNameList();
        System.out.println("Bye!");
    }
}
