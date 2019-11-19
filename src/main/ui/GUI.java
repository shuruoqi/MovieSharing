package ui;

import exception.RepetitionException;
import exception.UpcomingException;
import model.Genre;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI extends JFrame {

    static ListOperation listOperation;
    static String selectedGenre = "";
    static JTextField searchName;
    static JComboBox genreComboBox;
    static JComboBox typeComboBox;
    static JTextField enterName;
    static JTextField enterDate;
    static JPanel genrePanel;

    private static String []genres = {"Action", "Adventure", "Animation", "Crime", "Comedy", "Drama", "Family",
            "Fantasy", "Horror", "Mystery", "Romance", "SciFi", "Superhero", "Other"};

    public static void main(String[] args) throws IOException {
        listOperation = new ListOperation();
        listOperation.start();
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
        listOperation.saveAll();
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("MovieSharing");
        frame.setBounds(200, 200, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        bilibiliLogo(frame);
        initialButton(frame);

        frame.setVisible(true);
    }

    private static void initialButton(JFrame frame) {
        JButton search = new JButton("Search");
        JButton upload = new JButton("Upload");
        JButton checkWatchlist = new JButton("Check Watchlist");
        search.setBounds(125, 150, 150, 35);
        upload.setBounds(125, 185, 150, 35);
        checkWatchlist.setBounds(125, 220, 150, 35);

        frame.add(search);
        frame.add(upload);
        frame.add(checkWatchlist);

        search.addActionListener(e -> search());
        upload.addActionListener(e -> uploadMovie());
        checkWatchlist.addActionListener(e -> checkWatchlist());
    }

    private static void bilibiliLogo(JFrame frame) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon img = new ImageIcon("./data/Bilibili.jpg");
        label.setIcon(img);
        panel.setBounds(125,5,150,140);
        frame.add(panel);
        panel.add(label);
    }

    private static void tickLogo(JFrame frame) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon img = new ImageIcon("./data/Tick.jpg");
        label.setIcon(img);
        panel.setBounds(150,35,100,100);
        frame.add(panel);
        panel.add(label);
    }

    private static void crossLogo(JFrame frame) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon img = new ImageIcon("./data/Cross.jpg");
        label.setIcon(img);
        panel.setBounds(150,35,100,100);
        frame.add(panel);
        panel.add(label);
    }

    private static JButton searchButton() {
        JButton searchButton = new JButton();
        searchButton.setIcon(new ImageIcon("./data/SearchLogo.jpg"));
        return searchButton;
    }

    private static JButton uploadButton() {
        JButton uploadButton = new JButton();
        uploadButton.setIcon(new ImageIcon("./data/UploadLogo.jpg"));
        return uploadButton;
    }

    private static void search() {
        JFrame searchFrame = new JFrame("Search");
        searchFrame.setBounds(200, 200, 400, 300);
        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        searchFrame.setLayout(null);

        JButton searchMovie = new JButton("Search Movie");
        searchMovie.setBounds(125, 80, 150, 50);
        JButton searchGenre = new JButton("Search Genre");
        searchGenre.setBounds(125, 160, 150, 50);

        searchFrame.add(searchMovie);
        searchFrame.add(searchGenre);

        searchFrame.setVisible(true);

        searchGenre.addActionListener(e -> searchGenre());

        searchMovie.addActionListener(e -> searchMovie());
    }

    private static void searchGenre() {
        JFrame searchGenreFrame = new JFrame("Search Genre");
        searchGenreFrame.setBounds(200, 200, 400, 300);
        searchGenreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        searchGenreFrame.setLayout(null);

        JPanel genrePanel = new JPanel();
        JLabel genreLabel = new JLabel("Genre:");
        genreComboBox = new JComboBox(genres);
        genrePanel.setBounds(125,80,140,55);
        genrePanel.add(genreLabel);
        genrePanel.add(genreComboBox);

        JButton searchButton = searchButton();
        searchButton.setBounds(270,102,35,35);

        searchGenreFrame.add(genrePanel);
        searchGenreFrame.add(searchButton);
        searchGenreFrame.setVisible(true);
        searchButton.addActionListener(e -> searchGenreResult());
    }

    private static void searchGenreResult() {
        JFrame genreResult = new JFrame("Search Genre Result");
        genreResult.setBounds(200, 200, 400, 300);
        genreResult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        genreResult.setLayout(null);

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(25,25,350,225);

        JTextArea movies = new JTextArea();
        movies.setLineWrap(true);
        movies.setWrapStyleWord(true);
        movies.setBounds(25,25,350,225);
        selectedGenre = genreComboBox.getSelectedItem().toString();
        ArrayList<String> names = listOperation.printMoviesOfGivenGenre(selectedGenre);
        for (String name : names) {
            movies.append(name + "\n");
        }
        scroll.setViewportView(movies);
        genreResult.add(scroll);
        genreResult.setVisible(true);
    }

    private static void searchMovie() {
        JFrame searchMovieFrame = new JFrame("Search Movie");
        searchMovieFrame.setBounds(200, 200, 400, 300);
        searchMovieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        searchMovieFrame.setLayout(null);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Movie Name:");
        searchName = new JTextField(20);
        searchName.setBounds(75,80,250,30);
        namePanel.setBounds(75,80,250,60);
        namePanel.add(nameLabel);
        namePanel.add(searchName);

        JButton searchButton = searchButton();
        searchButton.setBounds(325,102,35,35);

        searchMovieFrame.add(namePanel);
        searchMovieFrame.add(searchButton);
        searchMovieFrame.setVisible(true);

        searchButton.addActionListener(e -> searchMovieResult());
    }

    private static void searchMovieResult() {
        JFrame movieFrame = new JFrame("Movie");
        movieFrame.setBounds(200, 200, 400, 300);
        movieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        movieFrame.setLayout(null);

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(25,25,350,100);
        JTextArea movieInfo = searchName();

        JButton addToWatchlist = new JButton("Add to Watchlist");
        addToWatchlist.setBounds(25, 160, 150, 35);
        JButton download = new JButton("Download");
        download.setBounds(225, 160, 150, 35);

        scroll.setViewportView(movieInfo);
        movieFrame.add(scroll);
        movieFrame.add(addToWatchlist);
        movieFrame.add(download);
        movieFrame.setVisible(true);

        addToWatchlist.addActionListener(e -> doAddToWatchlist());
        download.addActionListener(e -> doDownload());
    }

    private static JTextArea searchName() {
        JTextArea movieInfo = new JTextArea();
        movieInfo.setBounds(25,75,350,40);
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

    private static void doAddToWatchlist() {
        try {
            listOperation.watchList.add(listOperation.searchMovie(searchName.getText()));
            addSuccess();
        } catch (RepetitionException | UpcomingException e) {
            addFail();
        }
    }

    private static void doDownload() {
        try {
            listOperation.downloadList.add(listOperation.searchMovie(searchName.getText()));
            downloadSuccess();
        } catch (RepetitionException e) {
            downloadFail();
        } catch (UpcomingException e) {
            upcoming();
        }
    }

    private static void uploadMovie() {
        JFrame uploadMovieFrame = new JFrame("Upload Movie");
        uploadMovieFrame.setBounds(200, 200, 400, 300);
        uploadMovieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        uploadMovieFrame.setLayout(null);

        JPanel typePanel = typePanel();
        JPanel namePanel = namePanel();
        JPanel datePanel = datePanel();
        JPanel genrePanel = genreCheckBoxPanel();
        JButton uploadButton  = uploadButton();
        uploadButton.setBounds(312,242,35,35);

        uploadMovieFrame.add(typePanel);
        uploadMovieFrame.add(namePanel);
        uploadMovieFrame.add(datePanel);
        uploadMovieFrame.add(genrePanel);
        uploadMovieFrame.add(uploadButton);
        uploadMovieFrame.setVisible(true);
        uploadButton.addActionListener(e -> doUpload());
    }

    public static JPanel typePanel() {
        JPanel typePanel = new JPanel();
        JLabel typeLabel = new JLabel("Type:");
        String []type = {"Public", "Upcoming"};
        typeComboBox = new JComboBox(type);
        typePanel.setBounds(50,5,300,28);
        typePanel.add(typeLabel);
        typePanel.add(typeComboBox);
        return typePanel;
    }

    private static JPanel namePanel() {
        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        enterName = new JTextField(20);
        namePanel.setBounds(50,33,300,28);
        namePanel.add(nameLabel);
        namePanel.add(enterName);
        return namePanel;
    }

    private static JPanel datePanel() {
        JPanel datePanel = new JPanel();
        JLabel dateLabel = new JLabel("Release Date (yyyy-mm-dd):");
        enterDate = new JTextField(8);
        datePanel.setBounds(50,61,300,28);
        datePanel.add(dateLabel);
        datePanel.add(enterDate);
        return datePanel;
    }

    private static JPanel genreCheckBoxPanel() {
        genrePanel = new JPanel();
        genrePanel.setBorder(BorderFactory.createTitledBorder("Genre:"));
        genrePanel.setLayout(new GridLayout(5, 3));
        for (String s : genres) {
            JCheckBox genreCheckBox = new JCheckBox(s);
            genrePanel.add(genreCheckBox);
        }
        genrePanel.setBounds(45,94,305,150);
        return genrePanel;
    }

    private static void doUpload() {
        newMovie();
        try {
            listOperation.cinemaList.add(listOperation.movieOperation.movie);
            uploadSuccess();
        } catch (RepetitionException | UpcomingException e) {
            uploadFail();
        }
    }

    private static void newMovie() {
        String type = typeComboBox.getSelectedItem().toString();
        listOperation.movieOperation.chooseTypeResult(type);
        listOperation.movieOperation.movie.setName(enterName.getText());
        listOperation.movieOperation.movie.setDate(enterDate.getText());
        ArrayList<JCheckBox> checkboxes = new ArrayList<>();
        for (Component component : genrePanel.getComponents()) {
            if (component instanceof JCheckBox) {
                checkboxes.add((JCheckBox)component);
            }
        }
        for (JCheckBox box : checkboxes) {
            listOperation.movieOperation.movie.addGenre(new Genre(box.getText()));
        }
    }

    private static void checkWatchlist() {
        JFrame checkWatchlistFrame = new JFrame("Check Watchlist");
        checkWatchlistFrame.setBounds(200, 200, 400, 300);
        checkWatchlistFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        checkWatchlistFrame.setLayout(null);

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(25,25,350,175);
        JTextArea watchlist = new JTextArea();
        watchlist.setBounds(25,25,350,175);
        ArrayList<String> list = listOperation.watchList.showAll();
        for (String info : list) {
            watchlist.append(info + "\n");
        }
        JButton manage = new JButton("Manage");
        manage.setBounds(275,215,100, 35);

        scroll.setViewportView(watchlist);
        checkWatchlistFrame.add(scroll);
        checkWatchlistFrame.add(manage);
        checkWatchlistFrame.setVisible(true);
        manage.addActionListener(e -> delete());
    }

    private static void delete() {
        JFrame deleteFrame = new JFrame("Delete");
        deleteFrame.setBounds(200, 200, 400, 300);
        deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        deleteFrame.setLayout(null);

        ArrayList<String> list = listOperation.watchList.showAll();
        String []movie = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            movie[i] = list.get(i);
        }
        JComboBox movieComboBox = new JComboBox(movie);

        movieComboBox.setBounds(45,45,305,150);
        JButton delete = new JButton("Delete");
        delete.setBounds(275,215,100, 35);

        deleteFrame.add(movieComboBox);
        deleteFrame.add(delete);
        deleteFrame.setVisible(true);
    }

    private static void uploadFail() {
        JFrame uploadFailFrame = new JFrame("Fail");
        uploadFailFrame.setBounds(200, 200, 400, 300);
        uploadFailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        uploadFailFrame.setLayout(null);

        crossLogo(uploadFailFrame);
        JPanel repetitionPanel = new JPanel();
        JLabel repetitionLabel = new JLabel("Already uploaded");
        repetitionPanel.setBounds(50,200,300,30);

        repetitionPanel.add(repetitionLabel);
        uploadFailFrame.add(repetitionPanel);
        uploadFailFrame.setVisible(true);
    }

    private static void downloadFail() {
        JFrame downloadFailFrame = new JFrame("Fail");
        downloadFailFrame.setBounds(200, 200, 400, 300);
        downloadFailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        downloadFailFrame.setLayout(null);

        crossLogo(downloadFailFrame);
        JPanel repetitionPanel = new JPanel();
        JLabel repetitionLabel = new JLabel("Already downloaded");
        repetitionPanel.setBounds(50,200,300,30);

        repetitionPanel.add(repetitionLabel);
        downloadFailFrame.add(repetitionPanel);
        downloadFailFrame.setVisible(true);
    }

    private static void upcoming() {
        JFrame addFailFrame = new JFrame("Fail");
        addFailFrame.setBounds(200, 200, 400, 300);
        addFailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addFailFrame.setLayout(null);

        crossLogo(addFailFrame);
        JPanel repetitionPanel = new JPanel();
        JLabel repetitionLabel = new JLabel("Upcoming movie is not downloadable");
        repetitionPanel.setBounds(50,200,300,30);

        repetitionPanel.add(repetitionLabel);
        addFailFrame.add(repetitionPanel);

        addFailFrame.setVisible(true);
    }

    private static void addFail() {
        JFrame addFailFrame = new JFrame("Fail");
        addFailFrame.setBounds(200, 200, 400, 300);
        addFailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addFailFrame.setLayout(null);

        crossLogo(addFailFrame);
        JPanel repetitionPanel = new JPanel();
        JLabel repetitionLabel = new JLabel("Already added");
        repetitionPanel.setBounds(50,200,300,30);

        repetitionPanel.add(repetitionLabel);
        addFailFrame.add(repetitionPanel);

        addFailFrame.setVisible(true);
    }

    private static void uploadSuccess() {
        JFrame uploadSuccessFrame = new JFrame("Success");
        uploadSuccessFrame.setBounds(200, 200, 400, 300);
        uploadSuccessFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        uploadSuccessFrame.setLayout(null);

        tickLogo(uploadSuccessFrame);
        JPanel successPanel = new JPanel();
        JLabel successLabel = new JLabel("Upload successfully");
        successPanel.setBounds(50,200,300,30);

        successPanel.add(successLabel);
        uploadSuccessFrame.add(successPanel);
        uploadSuccessFrame.setVisible(true);
    }

    private static void downloadSuccess() {
        JFrame downloadSuccessFrame = new JFrame("Success");
        downloadSuccessFrame.setBounds(200, 200, 400, 300);
        downloadSuccessFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        downloadSuccessFrame.setLayout(null);

        tickLogo(downloadSuccessFrame);
        JPanel successPanel = new JPanel();
        JLabel successLabel = new JLabel("download successfully");
        successPanel.setBounds(50,200,300,30);

        successPanel.add(successLabel);
        downloadSuccessFrame.add(successPanel);
        downloadSuccessFrame.setVisible(true);
    }

    private static void addSuccess() {
        JFrame addSuccessFrame = new JFrame("Success");
        addSuccessFrame.setBounds(200, 200, 400, 300);
        addSuccessFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addSuccessFrame.setLayout(null);

        tickLogo(addSuccessFrame);
        JPanel successPanel = new JPanel();
        JLabel successLabel = new JLabel("Add successfully");
        successPanel.setBounds(50,200,300,30);

        successPanel.add(successLabel);
        addSuccessFrame.add(successPanel);
        addSuccessFrame.setVisible(true);
    }
}
