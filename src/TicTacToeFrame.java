import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    private Player ai;
    private Player p;
    private JPanel panelCards;
    private Homepage homePanel;
    private TicTacToePanel gamePanel;
    private TicTacToeGame controller;

    public TicTacToeFrame(TicTacToeGame controllerRef) {
        super();
        controller = controllerRef;
        panelCards = new JPanel(new CardLayout());
        homePanel = new Homepage(controllerRef);
        gamePanel = new TicTacToePanel(controllerRef);
        setupFrame();
    }

    public void setupFrame() {
        setSize(1000, 800);
        setTitle("Let's play!");
        add(panelCards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelCards.add(homePanel, "home");
        panelCards.add(gamePanel, "game");
        replaceScreen("home");
        setVisible(true);
    }

    public void replaceScreen(String screen) {
        CardLayout cardLayout = (CardLayout) panelCards.getLayout();
        cardLayout.show(panelCards, screen);
    }
}
