package model;

public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Movie movie) {
        System.out.print("Hi " + name + ", ");
        System.out.println("<" + movie.getName() + ">" + " is uploaded!");
    }
}
