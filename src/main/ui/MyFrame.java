package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

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

        insertLogo(frame);
        initialButton(frame);

        frame.setVisible(true);
    }

    public static void initialButton(JFrame frame) {
        JButton search = new JButton("Search");
        JButton upload = new JButton("Upload");
        JButton checkWatchlist = new JButton("Check Watchlist");
        search.setBounds(125, 150, 150, 35);
        upload.setBounds(125, 185, 150, 35);
        checkWatchlist.setBounds(125, 220, 150, 35);

        frame.add(search);
        frame.add(upload);
        frame.add(checkWatchlist);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });

        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadMovie();
            }
        });
    }

    public static void insertLogo(JFrame frame) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon img = new ImageIcon("./data/Bilibili.jpg");
        label.setIcon(img);
        panel.setBounds(125,5,150,140);
        frame.add(panel);
        panel.add(label);
    }

    public static void search() {
        JFrame searchFrame = new JFrame("Search");
        searchFrame.setBounds(200, 200, 400, 300);
        searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchFrame.setLayout(null);

        JButton searchMovie = new JButton("Search Movie");
        JButton searchGenre = new JButton("Search Genre");
        searchMovie.setBounds(125, 80, 150, 50);
        searchGenre.setBounds(125, 160, 150, 50);

        searchFrame.add(searchMovie);
        searchFrame.add(searchGenre);

        searchFrame.setVisible(true);

        searchGenre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchGenre();
            }
        });

        searchMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMovie();
            }
        });
    }

    public static JButton searchButton() {
        JButton searchButton = new JButton();
        searchButton.setIcon(new ImageIcon("./data/SearchLogo.jpg"));
        return searchButton;
    }

    public static void searchGenre() {
        JFrame searchGenreFrame = new JFrame("Search Genre");
        searchGenreFrame.setBounds(200, 200, 400, 300);
        searchGenreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchGenreFrame.setLayout(null);

        JPanel genrePanel = new JPanel();
        JLabel genreLabel = new JLabel("Genre:");
        String []genre = {"Action", "Adventure", "Animation", "Crime", "Comedy", "Drama", "Family", "Fantasy",
                "Horror", "Mystery", "Romance", "SciFi", "Superhero", "Other"};
        JComboBox genreComboBox = new JComboBox(genre);
        genrePanel.setBounds(125,80,140,55);
        genrePanel.add(genreLabel);
        genrePanel.add(genreComboBox);

        JButton searchButton = searchButton();
        searchButton.setBounds(270,102,35,35);

        searchGenreFrame.add(genrePanel);
        searchGenreFrame.add(searchButton);
        searchGenreFrame.setVisible(true);
    }

    public static void searchMovie() {
        JFrame searchMovieFrame = new JFrame("Search Movie");
        searchMovieFrame.setBounds(200, 200, 400, 300);
        searchMovieFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

    public static void uploadMovie() {
        JFrame uploadMovieFrame = new JFrame("Upload Movie");
        uploadMovieFrame.setBounds(200, 200, 400, 300);
        uploadMovieFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        uploadMovieFrame.setLayout(null);

        JPanel typePanel = new JPanel();
        JLabel typeLabel = new JLabel("Type:");
        String []type = {"Public", "Upcoming"};
        JComboBox typeComboBox = new JComboBox(type);
        typePanel.setBounds(50,10,300,30);
        typePanel.add(typeLabel);
        typePanel.add(typeComboBox);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        JTextField enterName = new JTextField(20);
        namePanel.setBounds(50,40,300,30);
        namePanel.add(nameLabel);
        namePanel.add(enterName);

        JPanel datePanel = new JPanel();
        JLabel dateLabel = new JLabel("Release Date (yyyy-mm-dd):");
        JTextField enterDate = new JTextField(8);
        datePanel.setBounds(50,70,300,30);
        datePanel.add(dateLabel);
        datePanel.add(enterDate);

        JCheckBox action = new JCheckBox("Action");
        JCheckBox adventure = new JCheckBox("Adventure");
        JCheckBox animation = new JCheckBox("Animation");
        JCheckBox crime = new JCheckBox("Crime");
        JCheckBox comedy = new JCheckBox("Comedy");
        JCheckBox drama = new JCheckBox("Drama");
        JCheckBox family = new JCheckBox("Family");
        JCheckBox fantasy = new JCheckBox("Fantasy");
        JCheckBox horror = new JCheckBox("Horror");
        JCheckBox mystery = new JCheckBox("Mystery");
        JCheckBox romance = new JCheckBox("Romance");
        JCheckBox sciFi = new JCheckBox("SciFi");
        JCheckBox superhero = new JCheckBox("Superhero");
        JCheckBox other = new JCheckBox("Other");
        JPanel genrePanel = new JPanel();
        genrePanel.setBorder(BorderFactory.createTitledBorder("Genre:"));
        genrePanel.setLayout(new GridLayout(5, 3));
        genrePanel.add(action);
        genrePanel.add(adventure);
        genrePanel.add(animation);
        genrePanel.add(crime);
        genrePanel.add(comedy);
        genrePanel.add(drama);
        genrePanel.add(family);
        genrePanel.add(fantasy);
        genrePanel.add(horror);
        genrePanel.add(mystery);
        genrePanel.add(romance);
        genrePanel.add(sciFi);
        genrePanel.add(superhero);
        genrePanel.add(other);
        genrePanel.setBounds(30,115,340,160);

        uploadMovieFrame.add(typePanel);
        uploadMovieFrame.add(namePanel);
        uploadMovieFrame.add(datePanel);
        uploadMovieFrame.add(genrePanel);
        uploadMovieFrame.setVisible(true);
    }
}
