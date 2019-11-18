package ui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private static String []genres = {"Action", "Adventure", "Animation", "Crime", "Comedy", "Drama", "Family",
            "Fantasy", "Horror", "Mystery", "Romance", "SciFi", "Superhero", "Other"};

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
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
        JComboBox genreComboBox = new JComboBox(genres);
        genrePanel.setBounds(125,80,140,55);
        genrePanel.add(genreLabel);
        genrePanel.add(genreComboBox);

        JButton searchButton = searchButton();
        searchButton.setBounds(270,102,35,35);

        searchGenreFrame.add(genrePanel);
        searchGenreFrame.add(searchButton);
        searchGenreFrame.setVisible(true);
    }

    private static void searchMovie() {
        JFrame searchMovieFrame = new JFrame("Search Movie");
        searchMovieFrame.setBounds(200, 200, 400, 300);
        searchMovieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        searchMovieFrame.setLayout(null);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Movie Name:");
        JTextField searchName = new JTextField(20);
        namePanel.setBounds(75,80,250,60);
        namePanel.add(nameLabel);
        namePanel.add(searchName);

        JButton searchButton = searchButton();
        searchButton.setBounds(325,102,35,35);

        searchMovieFrame.add(namePanel);
        searchMovieFrame.add(searchButton);
        searchMovieFrame.setVisible(true);
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
    }

    private static JPanel typePanel() {
        JPanel typePanel = new JPanel();
        JLabel typeLabel = new JLabel("Type:");
        String []type = {"Public", "Upcoming"};
        JComboBox typeComboBox = new JComboBox(type);
        typePanel.setBounds(50,5,300,28);
        typePanel.add(typeLabel);
        typePanel.add(typeComboBox);
        return typePanel;
    }

    private static JPanel namePanel() {
        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        JTextField enterName = new JTextField(20);
        namePanel.setBounds(50,33,300,28);
        namePanel.add(nameLabel);
        namePanel.add(enterName);
        return namePanel;
    }

    private static JPanel datePanel() {
        JPanel datePanel = new JPanel();
        JLabel dateLabel = new JLabel("Release Date (yyyy-mm-dd):");
        JTextField enterDate = new JTextField(8);
        datePanel.setBounds(50,61,300,28);
        datePanel.add(dateLabel);
        datePanel.add(enterDate);
        return datePanel;
    }

    private static JPanel genreCheckBoxPanel() {
        JPanel genrePanel = new JPanel();
        genrePanel.setBorder(BorderFactory.createTitledBorder("Genre:"));
        genrePanel.setLayout(new GridLayout(5, 3));
        for (String s : genres) {
            JCheckBox box = new JCheckBox(s);
            genrePanel.add(box);
        }
        genrePanel.setBounds(45,94,305,150);
        return genrePanel;
    }

}
