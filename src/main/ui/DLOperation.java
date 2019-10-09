package ui;

import model.*;

import java.io.IOException;
import java.util.ArrayList;

public class DLOperation {
    Downloadlist downloadlist;
    WLOperation wlOperation;
    Watchlist watchlist;
    Loadable loadDL;
    Loadable loadWL;
    Saveable saveDL;

    public void operationSetUp() throws IOException {
        downloadlist = new Downloadlist();
        downloadlist.listSetUp();
        watchlist = new Watchlist();
        wlOperation = new WLOperation();
        watchlist.listSetUp();
        wlOperation.operationSetUp();
        wlOperation.start();
    }

    public void start() throws IOException {
        loadDL = new Load();
        loadWL = new Load();
        downloadlist.downloadList = loadDL.load("./data/DownloadListFile.txt");
        watchlist.watchList = loadWL.load("./data/WatchListFile.txt");
    }

    public void chooseMovie() {
        String movieChoice = downloadlist.chooseMovieScanner();
        for (Movie next :wlOperation.watchlist.watchList) {
            if (next.getType().equals("regular")) {
                if (next.getName().equals(movieChoice)) {
                    downloadlist.printAllInfo(next);
                    if (downloadlist.addToListResult(downloadlist.addToListScanner())) {
                        downloadlist.insertMovieToList(next);
                    }
                }
            } else {
                System.out.println("VIP movies are only available online.");
            }
        }
    }

    public void continueToChooseMovie() {
        downloadlist.continueToChooseMovieResult(downloadlist.continueToChooseMovieScanner());

    }

    public void chooseMovieLoop() throws IOException {
        saveDL = new Save();
        if (downloadlist.startResult(downloadlist.startScanner())) {
            while (downloadlist.downloadMovieLoopState) {
                chooseMovie();
                continueToChooseMovie();
            }
        }
        saveDL.save(downloadlist.getList(),"./data/DownloadListFile.txt");
    }

    public void printNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Movie next : downloadlist.getList()) {
            nameList.add(next.getName());
        }
        System.out.println("Your download list : " + nameList);
    }
}
