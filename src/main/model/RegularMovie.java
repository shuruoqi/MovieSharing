package model;

public class RegularMovie extends Movie {
    private String type;

    public RegularMovie(String name, String quality, double size) {
        super(name, quality, size);
        type = "regular";
    }

    @Override
    public String getType() {
        return "regular";
    }


}
