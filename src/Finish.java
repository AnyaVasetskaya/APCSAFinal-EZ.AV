import javax.swing.*;
import java.awt.*;

public class Finish extends JPanel {
    private JLabel finish;

    public Finish(TicTacToeGame controller) {
        finish = new JLabel();
        if (controller.getPlayerWin()) {
            finish.setText("You have won this time, fool! It shan't happen again!");
        } else if (controller.getAIWin()) {
            finish.setText("You lose! Better luck next time, human!");
        }
        finish.setFont(new Font("Courier", Font.BOLD,40));
        finish.setSize(900,900);
        add(finish);
    }
}
