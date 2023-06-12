import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.util.Objects;

public class TicTacToePanel extends JPanel implements ActionListener {
    private TicTacToeGame controller;
    private GridLayout panelLayout;
    private JButton tile1;
    private JButton tile2;
    private JButton tile3;
    private JButton tile4;
    private JButton tile5;
    private JButton tile6;
    private JButton tile7;
    private JButton tile8;
    private JButton tile9;
    //private JButton startOver;
    private ImageIcon rabbit;
    JLabel icon;

    public TicTacToePanel(TicTacToeGame controllerRef) {
        super();
        controller = controllerRef;
        panelLayout = new GridLayout(3, 3);
        rabbit = new ImageIcon("rabbit.png");
        Image rabbitPic = rabbit.getImage();
        Image scaledRabbitPic = rabbitPic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        rabbit = new ImageIcon(scaledRabbitPic);
        icon = new JLabel(rabbit);
        setupPanel();
        setupListeners();
    }

    public void setupPanel() {
        tile1 = new JButton("Tile 1!");
        tile2 = new JButton("Tile 2!");
        tile3 = new JButton("Tile 3!");
        tile4 = new JButton("Tile 4!");
        tile5 = new JButton("Tile 5!");
        tile6 = new JButton("Tile 6!");
        tile7 = new JButton("Tile 7!");
        tile8 = new JButton("Tile 8!");
        tile9 = new JButton("Tile 9!");
        //startOver = new JButton("Start Over");
        setLayout(panelLayout);
        add(tile1);
        add(tile2);
        add(tile3);
        add(tile4);
        add(tile5);
        add(tile6);
        add(tile7);
        add(tile8);
        add(tile9);
        //add(startOver);
    }

    private void updateScreen(String tile) {
        //if (!controller.getAIWin() && !controller.getPlayerWin()) {
            if (tile.contains("1")) {
                tile1.setText(controller.getPlayerSymbol());
                tile1.setFont(new Font("Courier", Font.BOLD,28));
                tile1.setEnabled(false);
                controller.setPlayerOrAITaken(1, "player");
            } else if (tile.contains("2")) {
                tile2.setText(controller.getPlayerSymbol());
                tile2.setFont(new Font("Courier", Font.BOLD,28));
                tile2.setEnabled(false);
                controller.setPlayerOrAITaken(2, "player");
            } else if (tile.contains("3")) {
                tile3.setText(controller.getPlayerSymbol());
                tile3.setFont(new Font("Courier", Font.BOLD,28));
                tile3.setEnabled(false);
                controller.setPlayerOrAITaken(3, "player");
            } else if (tile.contains("4")) {
                tile4.setText(controller.getPlayerSymbol());
                tile4.setFont(new Font("Courier", Font.BOLD,28));
                tile4.setEnabled(false);
                controller.setPlayerOrAITaken(4, "player");
            } else if (tile.contains("5")) {
                tile5.setText(controller.getPlayerSymbol());
                tile5.setFont(new Font("Courier", Font.BOLD,28));
                tile5.setEnabled(false);
                controller.setPlayerOrAITaken(5, "player");
            } else if (tile.contains("6")) {
                tile6.setText(controller.getPlayerSymbol());
                tile6.setFont(new Font("Courier", Font.BOLD,28));
                tile6.setEnabled(false);
                controller.setPlayerOrAITaken(6, "player");
            } else if (tile.contains("7")) {
                tile7.setText(controller.getPlayerSymbol());
                tile7.setFont(new Font("Courier", Font.BOLD,28));
                tile7.setEnabled(false);
                controller.setPlayerOrAITaken(7, "player");
            } else if (tile.contains("8")) {
                tile8.setText(controller.getPlayerSymbol());
                tile8.setFont(new Font("Courier", Font.BOLD,28));
                tile8.setEnabled(false);
                controller.setPlayerOrAITaken(8, "player");
            } else if (tile.contains("9")) {
                tile9.setText(controller.getPlayerSymbol());
                tile9.setFont(new Font("Courier", Font.BOLD,28));
                tile9.setEnabled(false);
                controller.setPlayerOrAITaken(9, "player");
            }
            int aiMove = controller.aiMove();
            if (aiMove == 1) {
                tile1.setText(controller.getAISymbol());
                tile1.setFont(new Font("Courier", Font.BOLD,70));
                tile1.setEnabled(false);
                controller.setPlayerOrAITaken(1, "ai");
            } else if (aiMove == 2) {
                tile1.setText(controller.getAISymbol());
                tile2.setEnabled(false);
                controller.setPlayerOrAITaken(2, "ai");
            } else if (aiMove == 3) {
                tile1.setText(controller.getAISymbol());
                tile3.setEnabled(false);
                controller.setPlayerOrAITaken(3, "ai");
            } else if (aiMove == 4) {
                tile1.setText(controller.getAISymbol());
                tile4.setEnabled(false);
                controller.setPlayerOrAITaken(4, "ai");
            } else if (aiMove == 5) {
                tile1.setText(controller.getAISymbol());
                tile5.setEnabled(false);
                controller.setPlayerOrAITaken(5, "ai");
            } else if (aiMove == 6) {
                tile1.setText(controller.getAISymbol());
                tile6.setEnabled(false);
                controller.setPlayerOrAITaken(6, "ai");
            } else if (aiMove == 7) {
                tile1.setText(controller.getAISymbol());
                tile7.setEnabled(false);
                controller.setPlayerOrAITaken(7, "ai");
            } else if (aiMove == 8) {
                tile1.setText(controller.getAISymbol());
                tile8.setEnabled(false);
                controller.setPlayerOrAITaken(8, "ai");
            } else if (aiMove == 9) {
                tile1.setText(controller.getAISymbol());
                tile9.setEnabled(false);
                controller.setPlayerOrAITaken(9, "ai");
            }
        //}

    }

    private void setupListeners() {
        tile1.addActionListener(this);
        tile2.addActionListener(this);
        tile3.addActionListener(this);
        tile4.addActionListener(this);
        tile5.addActionListener(this);
        tile6.addActionListener(this);
        tile7.addActionListener(this);
        tile8.addActionListener(this);
        tile9.addActionListener(this);
        //startOver.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        JButton clickedButton = (JButton) source;
        String text = clickedButton.getText();

        if (text.contains("Tile")) {
            updateScreen(text);
        }
//            } else if (text.equals("Start Over")) {
//                //controller.reset();
//                controller = new TicTacToeGame();
//            }
    }


    //button.newPreference(setDimension)
}
