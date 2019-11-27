package ui;

import exception.RepetitionException;
import exception.UpcomingException;
import model.Genre;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Frame {

    private static ListOperation listOperation;
    private static JFrame mainFrame;
    private static JFrame searchFrame;
    private static JFrame searchGenreFrame;
    private static JFrame searchMovieFrame;
    private static JFrame movieResultFrame;
    private static JFrame uploadMovieFrame;
    private static JFrame checkWatchlistFrame;
    private static JFrame deleteFrame;
    private static JTextField searchName;
    private static JComboBox genreComboBox;
    private static JComboBox typeComboBox;
    private static JComboBox movieComboBox;
    private static JTextField enterName;
    private static JTextField enterDate;
    private static JPanel genrePanel;

    private static String[] genres = {"Action", "Adventure", "Animation", "Crime", "Comedy", "Drama", "Family",
            "Fantasy", "Horror", "Mystery", "Romance", "SciFi", "Superhero", "Other"};

    void mainFrame() throws IOException {
        listOperation = new ListOperation();
        listOperation.start();
        mainFrame = new JFrame("MovieSharing");
        mainFrame.setBounds(200, 200, 400, 300);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);

        bilibiliLogo(mainFrame);
        initialButton(mainFrame);
        mainFrame.setVisible(true);
    }

    private void initialButton(JFrame frame) {
        JButton search = new JButton("Search");
        search.setBounds(125, 150, 150, 30);
        JButton upload = new JButton("Upload");
        upload.setBounds(125, 180, 150, 30);
        JButton checkWatchlist = new JButton("Check Watchlist");
        checkWatchlist.setBounds(125, 210, 150, 30);
        JButton exit = new JButton("Exit");
        exit.setBounds(125, 240, 150, 30);

        frame.add(search);
        frame.add(upload);
        frame.add(checkWatchlist);
        frame.add(exit);
        search.addActionListener(e -> search());
        upload.addActionListener(e -> uploadMovie());
        checkWatchlist.addActionListener(e -> checkWatchlist());
        exit.addActionListener(e -> saveAndClose(mainFrame));
    }

    private void saveAndClose(JFrame frame) {
        try {
            listOperation.saveAll();
            frame.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search() {
        searchFrame = new JFrame("Search");
        searchFrame.setBounds(200, 200, 400, 300);
        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchFrame.setLayout(null);
        searchFrame.setResizable(false);

        JButton searchMovie = new JButton("Search Movie");
        searchMovie.setBounds(125, 80, 150, 50);
        JButton searchGenre = new JButton("Search Genre");
        searchGenre.setBounds(125, 160, 150, 50);

        searchFrame.add(searchMovie);
        searchFrame.add(searchGenre);
        searchGenre.addActionListener(e -> searchGenre());
        searchMovie.addActionListener(e -> searchMovie());
        searchFrame.setVisible(true);
    }

    private void searchGenre() {
        searchGenreFrame = new JFrame("Search Genre");
        searchGenreFrame.setBounds(200, 200, 400, 300);
        searchGenreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchGenreFrame.setLayout(null);
        searchGenreFrame.setResizable(false);

        JPanel genrePanel = new JPanel();
        JLabel genreLabel = new JLabel("Genre:");
        genreComboBox = new JComboBox(genres);
        genrePanel.setBounds(125, 80, 140, 55);
        genrePanel.add(genreLabel);
        genrePanel.add(genreComboBox);
        JButton searchButton = searchButton(270);

        searchGenreFrame.add(genrePanel);
        searchGenreFrame.add(searchButton);
        searchButton.addActionListener(e -> searchGenreResult());
        searchGenreFrame.setVisible(true);
    }

    private void searchGenreResult() {
        JFrame genreResultFrame = new JFrame("Search Genre Result");
        genreResultFrame.setBounds(200, 200, 400, 300);
        genreResultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        genreResultFrame.setLayout(null);
        genreResultFrame.setResizable(false);

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(25, 25, 350, 225);
        JTextArea movies = movieInfo();
        String selectedGenre = genreComboBox.getSelectedItem().toString();
        ArrayList<String> names = listOperation.printMoviesOfGivenGenre(selectedGenre);
        for (String name : names) {
            movies.append(name + "\n");
        }
        scroll.setViewportView(movies);
        genreResultFrame.add(scroll);

        saveAndClose(searchGenreFrame);
        saveAndClose(searchFrame);
        genreResultFrame.setVisible(true);
    }

    private JTextArea movieInfo() {
        JTextArea movies = new JTextArea();
        movies.setLineWrap(true);
        movies.setWrapStyleWord(true);
        movies.setBounds(25, 25, 350, 225);
        return movies;
    }

    private void searchMovie() {
        searchMovieFrame = new JFrame("Search Movie");
        searchMovieFrame.setBounds(200, 200, 400, 300);
        searchMovieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchMovieFrame.setLayout(null);
        searchMovieFrame.setResizable(false);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Movie Name:");
        searchName = new JTextField(20);
        searchName.setBounds(75, 80, 250, 30);
        namePanel.setBounds(75, 80, 250, 60);
        namePanel.add(nameLabel);
        namePanel.add(searchName);
        JButton searchButton = searchButton(325);

        searchMovieFrame.add(namePanel);
        searchMovieFrame.add(searchButton);
        searchButton.addActionListener(e -> searchMovieResult());
        searchMovieFrame.setVisible(true);
    }

    private void searchMovieResult() {
        movieResultFrame = new JFrame("Movie");
        movieResultFrame.setBounds(200, 200, 400, 300);
        movieResultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        movieResultFrame.setLayout(null);
        movieResultFrame.setResizable(false);

        JScrollPane scroll = movieInfoScroll();
        JButton addToWatchlist = new JButton("Add to Watchlist");
        addToWatchlist.setBounds(25, 160, 150, 35);
        JButton download = new JButton("Download");
        download.setBounds(225, 160, 150, 35);

        movieResultFrame.add(scroll);
        movieResultFrame.add(addToWatchlist);
        movieResultFrame.add(download);
        addToWatchlist.addActionListener(e -> doAddToWatchlist());
        download.addActionListener(e -> doDownload());
        movieResultFrame.setVisible(true);
    }

    private JScrollPane movieInfoScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(25, 25, 350, 100);
        JTextArea movieInfo = searchName();
        scroll.setViewportView(movieInfo);
        return scroll;
    }

    private JTextArea searchName() {
        JTextArea movieInfo = new JTextArea();
        movieInfo.setBounds(25, 75, 350, 40);
        movieInfo.setLineWrap(true);
        movieInfo.setWrapStyleWord(true);
        String info = listOperation.searchMovie(searchName.getText()).printInfo();
        String[] splits = info.split("---");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(splits));
        for (String i : list) {
            movieInfo.append(i + "\n");
        }
        return movieInfo;
    }

    private void doAddToWatchlist() {
        try {
            listOperation.watchList.add(listOperation.searchMovie(searchName.getText()));
            success("Add");
        } catch (RepetitionException | UpcomingException e) {
            fail("added");
        } finally {
            saveAndClose(movieResultFrame);
            saveAndClose(searchMovieFrame);
            saveAndClose(searchFrame);
        }
    }

    private void doDownload() {
        try {
            listOperation.downloadList.add(listOperation.searchMovie(searchName.getText()));
            success("Download");
        } catch (RepetitionException e) {
            fail("downloaded");
        } catch (UpcomingException e) {
            fail("Upcoming movie is not downloadable");
        } finally {
            saveAndClose(movieResultFrame);
            saveAndClose(searchMovieFrame);
            saveAndClose(searchFrame);
        }
    }

    private void uploadMovie() {
        uploadMovieFrame = new JFrame("Upload Movie");
        uploadMovieFrame.setBounds(200, 200, 400, 300);
        uploadMovieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        uploadMovieFrame.setLayout(null);
        uploadMovieFrame.setResizable(false);

        JPanel typePanel = typePanel();
        JPanel namePanel = namePanel();
        JPanel datePanel = datePanel();
        JPanel genrePanel = genreCheckBoxPanel();
        JButton uploadButton = uploadButton();

        uploadMovieFrame.add(typePanel);
        uploadMovieFrame.add(namePanel);
        uploadMovieFrame.add(datePanel);
        uploadMovieFrame.add(genrePanel);
        uploadMovieFrame.add(uploadButton);
        uploadButton.addActionListener(e -> doUpload());
        uploadMovieFrame.setVisible(true);
    }

    private JPanel typePanel() {
        JPanel typePanel = new JPanel();
        JLabel typeLabel = new JLabel("Type:");
        String[] type = {"Public", "Upcoming"};
        typeComboBox = new JComboBox(type);
        typePanel.setBounds(50, 5, 300, 28);
        typePanel.add(typeLabel);
        typePanel.add(typeComboBox);
        return typePanel;
    }

    private JPanel namePanel() {
        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        enterName = new JTextField(20);
        namePanel.setBounds(50, 33, 300, 28);
        namePanel.add(nameLabel);
        namePanel.add(enterName);
        return namePanel;
    }

    private JPanel datePanel() {
        JPanel datePanel = new JPanel();
        JLabel dateLabel = new JLabel("Release Date (yyyy-mm-dd):");
        enterDate = new JTextField(8);
        datePanel.setBounds(50, 61, 300, 28);
        datePanel.add(dateLabel);
        datePanel.add(enterDate);
        return datePanel;
    }

    private JPanel genreCheckBoxPanel() {
        genrePanel = new JPanel();
        genrePanel.setBorder(BorderFactory.createTitledBorder("Genre:"));
        genrePanel.setLayout(new GridLayout(5, 3));
        for (String s : genres) {
            JCheckBox genreCheckBox = new JCheckBox(s);
            genrePanel.add(genreCheckBox);
        }
        genrePanel.setBounds(45, 94, 305, 150);
        return genrePanel;
    }

    private void doUpload() {
        newMovie();
        try {
            listOperation.cinemaList.add(listOperation.movieOperation.movie);
            success("Upload");
        } catch (RepetitionException | UpcomingException e) {
            fail("uploaded");
        } finally {
            saveAndClose(uploadMovieFrame);
        }
    }

    private void newMovie() {
        String type = typeComboBox.getSelectedItem().toString();
        listOperation.movieOperation.chooseTypeResult(type);
        listOperation.movieOperation.movie.setName(enterName.getText());
        listOperation.movieOperation.movie.setDate(enterDate.getText());
        ArrayList<JCheckBox> checkboxes = new ArrayList<>();
        for (Component component : genrePanel.getComponents()) {
            if (component instanceof JCheckBox) {
                if (((JCheckBox) component).isSelected()) {
                    checkboxes.add((JCheckBox) component);
                }
            }
        }
        for (JCheckBox selectedBox : checkboxes) {
            listOperation.movieOperation.movie.addGenre(new Genre(selectedBox.getText()));
        }
    }

    private void checkWatchlist() {
        checkWatchlistFrame = new JFrame("Check Watchlist");
        checkWatchlistFrame.setBounds(200, 200, 400, 300);
        checkWatchlistFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkWatchlistFrame.setLayout(null);
        checkWatchlistFrame.setResizable(false);

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(25, 25, 350, 175);
        JTextArea watchlist = showWatchlist();
        scroll.setViewportView(watchlist);
        JButton manage = new JButton("Manage");
        manage.setBounds(275, 215, 100, 35);

        checkWatchlistFrame.add(scroll);
        checkWatchlistFrame.add(manage);
        manage.addActionListener(e -> delete());
        checkWatchlistFrame.setVisible(true);
    }

    private JTextArea showWatchlist() {
        JTextArea watchlist = new JTextArea();
        watchlist.setBounds(25, 25, 350, 175);
        ArrayList<String> list = listOperation.watchList.showAll();
        for (String info : list) {
            watchlist.append(info + "\n");
        }
        return watchlist;
    }

    private void delete() {
        deleteFrame = new JFrame("Delete");
        deleteFrame.setBounds(200, 200, 400, 300);
        deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteFrame.setLayout(null);
        deleteFrame.setResizable(false);

        ArrayList<String> list = listOperation.watchList.showAll();
        String[] movie = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            movie[i] = list.get(i);
        }
        movieComboBox = new JComboBox(movie);
        movieComboBox.setBounds(45, 45, 305, 150);
        JButton delete = new JButton("Delete");
        delete.setBounds(275, 215, 100, 35);

        deleteFrame.add(movieComboBox);
        deleteFrame.add(delete);
        delete.addActionListener(e -> doDelete());
        deleteFrame.setVisible(true);
    }

    private void doDelete() {
        String movieInfo = movieComboBox.getSelectedItem().toString();
        String[] splitInfo = movieInfo.split("---");
        String nameInfo = splitInfo[0];
        String[] split = nameInfo.split(":");
        String movieName = split[1];
        listOperation.watchList.delete(movieName);
        success("Delete");
        saveAndClose(deleteFrame);
        saveAndClose(checkWatchlistFrame);
    }

    private void bilibiliLogo(JFrame frame) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon img = new ImageIcon("./data/Bilibili.jpg");
        label.setIcon(img);
        panel.setBounds(125, 5, 150, 140);
        frame.add(panel);
        panel.add(label);
    }

    private void tickLogo(JFrame frame) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon img = new ImageIcon("./data/Tick.jpg");
        label.setIcon(img);
        panel.setBounds(150, 35, 100, 100);
        frame.add(panel);
        panel.add(label);
    }

    private void crossLogo(JFrame frame) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon img = new ImageIcon("./data/Cross.jpg");
        label.setIcon(img);
        panel.setBounds(150, 35, 100, 100);
        frame.add(panel);
        panel.add(label);
    }

    private JButton searchButton(int x) {
        JButton searchButton = new JButton();
        searchButton.setIcon(new ImageIcon("./data/SearchLogo.jpg"));
        searchButton.setBounds(x, 102, 35, 35);
        return searchButton;
    }

    private JButton uploadButton() {
        JButton uploadButton = new JButton();
        uploadButton.setIcon(new ImageIcon("./data/UploadLogo.jpg"));
        uploadButton.setBounds(312, 242, 35, 35);
        return uploadButton;
    }

    private void fail(String s) {
        JFrame failFrame = new JFrame("Fail");
        failFrame.setBounds(200, 200, 400, 300);
        failFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        failFrame.setLayout(null);

        crossLogo(failFrame);
        JLabel failLabel;
        JPanel failPanel = new JPanel();
        if (s.equals("Upcoming movie is not downloadable")) {
            failLabel = new JLabel(s);
        } else {
            failLabel = new JLabel("Already " + s);
        }
        failPanel.setBounds(50, 200, 300, 30);

        failPanel.add(failLabel);
        failFrame.add(failPanel);
        failFrame.setVisible(true);
    }

    private void success(String s) {
        JFrame successFrame = new JFrame("Success");
        successFrame.setBounds(200, 200, 400, 300);
        successFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        successFrame.setLayout(null);

        tickLogo(successFrame);
        JPanel successPanel = new JPanel();
        JLabel successLabel = new JLabel(s + " successfully");
        successPanel.setBounds(50, 200, 300, 30);

        successPanel.add(successLabel);
        successFrame.add(successPanel);
        successFrame.setVisible(true);
    }

}
