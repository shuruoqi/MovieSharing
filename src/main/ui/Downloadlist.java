package ui;

import model.*;

import java.io.IOException;
import java.util.ArrayList;

public class Downloadlist extends Movielist {
    public ArrayList<Movie> downloadList;
    public boolean downloadMovieLoopState = true;

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

    public static class DLOperation {
        public Downloadlist downloadlist;
        Watchlist.WLOperation wlOperation;
        Watchlist watchlist;
        Loadable loadDL;
        Loadable loadWL;
        Saveable saveDL;

        public void operationSetUp() throws IOException {
            downloadlist = new Downloadlist();
            downloadlist.listSetUp();
            watchlist = new Watchlist();
            wlOperation = new Watchlist.WLOperation();
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
}
