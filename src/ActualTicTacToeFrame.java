import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualTicTacToeFrame extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private TicTacToeGame game;
    private Homepage homepage;
    private TicTacToePanel gamePanel;

    public ActualTicTacToeFrame(TicTacToeGame game) {
        JFrame frame = new JFrame();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        this.game = game;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        homepage = new Homepage(game);
        gamePanel = new TicTacToePanel(game);

        mainPanel.add("home", homepage);
        mainPanel.add("game", gamePanel);
        cardLayout.show(mainPanel, "home");

        frame.add(mainPanel);
        frame.setSize(900,900);
        frame.setTitle("Let's Play!");
        frame.setVisible(true);
    }

    public String getPlayerSymbol() {
        return homepage.getSymbol();
    }

    public String getAISymbol() { return homepage.getAISymbol(); }

    public void replaceScreen() {
        cardLayout.show(mainPanel, "game");
    }

    public void actionPerformed(ActionEvent ae) {
//        Object source = ae.getSource();
//        JButton clickedButton = (JButton) source;
//        String text = clickedButton.getText();
        cardLayout.show(mainPanel, "game");
//      if (text.equals("Start Over")) {
//
//      }
    }
}
