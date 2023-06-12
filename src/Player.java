public class Player {
    private String symbol;
    private boolean win;

    public Player() {
        symbol = "";
        win = false;
    }

    public void setWin(boolean temp) { win = temp; }

    public boolean getWin() { return win; }

    public String getSymbol() {
        return symbol;
    }
}
