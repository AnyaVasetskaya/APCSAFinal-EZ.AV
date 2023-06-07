public class Tile {
    private String type;
    private int place;
    private String taken;

    public Tile(String type, int place) {
        this.type = type;
        this.place = place;
        taken = "no";
    }

    public String getType() {
        return type;
    }

    public int getPlace() {
        return place;
    }

    public void setTaken(String t) {
        taken = t;
    }

    public String getTaken() {
        return taken;
    }
}