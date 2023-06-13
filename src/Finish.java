import javax.swing.*;
import java.awt.*;

public class Finish extends JPanel {
    private TicTacToeGame controller;
    private SpringLayout panelLayout;
    private JButton text;
    private ImageIcon lose;
    private ImageIcon win;

    public Finish(TicTacToeGame controllerRef) {
        controller = controllerRef;
        panelLayout = new SpringLayout();
        text = new JButton();

        lose = new ImageIcon("src//lose.png");
        Image losePic = lose.getImage();
        Image scaledLosePic = losePic.getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        lose = new ImageIcon(scaledLosePic);

        win = new ImageIcon("src//win.png");
        Image winPic = win.getImage();
        Image scaledWinPic = winPic.getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        win = new ImageIcon(scaledWinPic);

        if (controller.getPlayerWin()) {
            text = new JButton(win);
        } else if (controller.getAIWin()) {
            text = new JButton(lose);
        }

        setLayout(panelLayout);
        add(text);
    }
}
