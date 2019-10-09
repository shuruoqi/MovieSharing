package ui;

import model.*;
import java.io.IOException;

public class CLOperation {
    Cinemalist cinemalist;
    Loadable loadCL;
    Saveable saveCL;

    public void operationSetUp() throws IOException {
        cinemalist = new Cinemalist();
        cinemalist.listSetUp();
    }

    public void start() throws IOException {
        loadCL = new Load();
        cinemalist.cinemaList = loadCL.load("./data/CinemaListFile.txt");
    }


    public void chooseType() {
        cinemalist.chooseTypeResult(cinemalist.chooseTypeScanner());
    }


    public void continueToChooseMovie() {
        cinemalist.continueToChooseMovieResult(cinemalist.continueToChooseMovieScanner());
    }

    public void chooseMovieLoop() throws IOException {
        Movie m;
        saveCL = new Save();
        if (cinemalist.startResult(cinemalist.startScanner())) {
            while (cinemalist.uploadMovieLoopState) {
                m = cinemalist.enterInfo(cinemalist.chooseTypeResult(cinemalist.chooseTypeScanner()));
                cinemalist.insertMovieToList(m);
                continueToChooseMovie();
            }
        }
        saveCL.save(cinemalist.getList(),"./data/CinemaListFile.txt");
    }
}
