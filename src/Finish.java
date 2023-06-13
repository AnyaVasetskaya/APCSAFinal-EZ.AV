import javax.swing.*;
import java.awt.*;

public class Finish extends JPanel {
    private TicTacToeGame controller;
    private SpringLayout panelLayout;
    private JButton text;
    private ImageIcon lose;
    private ImageIcon gg;

    public Finish(TicTacToeGame controllerRef) {
        controller = controllerRef;
        panelLayout = new SpringLayout();
        text = new JButton();

        gg = new ImageIcon("src//gghumanz.png");
        Image ggPic = gg.getImage();
        Image scaledGGPic = ggPic.getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        gg = new ImageIcon(scaledGGPic);

        text = new JButton(gg);

        setLayout(panelLayout);
        add(text);
    }
}
