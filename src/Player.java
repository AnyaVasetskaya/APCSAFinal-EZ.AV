public class Player {
    private String symbol;
    private boolean win;

    private static Homepage h = new Homepage(new TicTacToeGame());

    public Player(String symbol) {
        symbol = h.getSymbol();
        win = false;
    }

    public void setWin(boolean temp) { win = temp; }

    public boolean getWin() { return win; }

    public String getSymbol() {
        return symbol;
    }
}
