package model;

public class VipMovie extends Movie {
    private String type;

    public VipMovie(String name, String quality, double size) {
        super(name, quality, size);
    }

    @Override
    public String getType() {
        return "VIP";
    }
}
