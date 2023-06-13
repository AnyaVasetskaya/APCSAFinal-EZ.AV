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
    private ImageIcon pSymbol;
    private ImageIcon aiSymbol;
    private ImageIcon happrabbit;
    private ImageIcon grumpcatt;
    private ImageIcon corgiwoof;
    private ImageIcon wilbursmug;

    public TicTacToePanel(TicTacToeGame controllerRef) {
        super();
        controller = controllerRef;
        panelLayout = new GridLayout(3, 3);

        setupPanel();
        setupListeners();
    }

    public void setupSymbols() {
        if (controller.getPlayerSymbol().equals("catt")) {
            pSymbol = grumpcatt;
        } else if (controller.getPlayerSymbol().equals("rabbit")) {
            pSymbol = happrabbit;
        } else {
            pSymbol = corgiwoof;
        }
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

        happrabbit = new ImageIcon("src//happrabbit.png");
        Image rabbitPic = happrabbit.getImage();
        Image scaledRabbitPic = rabbitPic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        happrabbit = new ImageIcon(scaledRabbitPic);

        grumpcatt = new ImageIcon("src//grumpcatt.png");
        Image cattPic = grumpcatt.getImage();
        Image scaledCattPic = cattPic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        grumpcatt = new ImageIcon(scaledCattPic);

        corgiwoof = new ImageIcon("src//corgiwoof.png");
        Image corgiPic = corgiwoof.getImage();
        Image scaledCorgiPic = corgiPic.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        corgiwoof = new ImageIcon(scaledCorgiPic);

        wilbursmug = new ImageIcon("src//wilbursmug.png");
        Image wilburPic = wilbursmug.getImage();
        Image scaledWilburPic = wilburPic.getScaledInstance(350,  350, Image.SCALE_SMOOTH);
        wilbursmug = new ImageIcon(scaledWilburPic);
        aiSymbol = wilbursmug;

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
    }

    private void updateScreenPlayerMove(String tile) {
        setupSymbols();
        if (!controller.getAIWin() && !controller.getPlayerWin()) {
            if (tile.contains("1")) {
                tile1.setIcon(pSymbol);
                tile1.setText("");
                tile1.setEnabled(false);
                controller.setPlayerOrAITaken(1, "player");
            } else if (tile.contains("2")) {
                tile2.setIcon(pSymbol);
                tile2.setText("");
                tile2.setEnabled(false);
                controller.setPlayerOrAITaken(2, "player");
            } else if (tile.contains("3")) {
                tile3.setIcon(pSymbol);
                tile3.setText("");
                tile3.setEnabled(false);
                controller.setPlayerOrAITaken(3, "player");
            } else if (tile.contains("4")) {
                tile4.setIcon(pSymbol);
                tile4.setText("");
                tile4.setEnabled(false);
                controller.setPlayerOrAITaken(4, "player");
            } else if (tile.contains("5")) {
                tile5.setIcon(pSymbol);
                tile5.setText("");
                tile5.setEnabled(false);
                controller.setPlayerOrAITaken(5, "player");
            } else if (tile.contains("6")) {
                tile6.setIcon(pSymbol);
                tile6.setText("");
                tile6.setEnabled(false);
                controller.setPlayerOrAITaken(6, "player");
            } else if (tile.contains("7")) {
                tile7.setIcon(pSymbol);
                tile7.setText("");
                tile7.setEnabled(false);
                controller.setPlayerOrAITaken(7, "player");
            } else if (tile.contains("8")) {
                tile8.setIcon(pSymbol);
                tile8.setText("");
                tile8.setEnabled(false);
                controller.setPlayerOrAITaken(8, "player");
            } else if (tile.contains("9")) {
                tile9.setIcon(pSymbol);
                tile9.setText("");
                tile9.setEnabled(false);
                controller.setPlayerOrAITaken(9, "player");
            }
            System.out.println("tile updated");
        }
    }

    public void updateScreenAIMove() {
        if (!controller.getPlayerWin() && ! controller.getAIWin()) {
            int aiMove = controller.aiMove();
            if (aiMove == 1) {
                tile1.setIcon(aiSymbol);
                tile1.setText("");
                tile1.setEnabled(false);
                controller.setPlayerOrAITaken(1, "ai");
            } else if (aiMove == 2) {
                tile2.setIcon(aiSymbol);
                tile2.setText("");
                tile2.setEnabled(false);
                controller.setPlayerOrAITaken(2, "ai");
            } else if (aiMove == 3) {
                tile3.setIcon(aiSymbol);
                tile3.setText("");
                tile3.setEnabled(false);
                controller.setPlayerOrAITaken(3, "ai");
            } else if (aiMove == 4) {
                tile4.setIcon(aiSymbol);
                tile4.setText("");
                tile4.setEnabled(false);
                controller.setPlayerOrAITaken(4, "ai");
            } else if (aiMove == 5) {
                tile5.setIcon(aiSymbol);
                tile5.setText("");
                tile5.setEnabled(false);
                controller.setPlayerOrAITaken(5, "ai");
            } else if (aiMove == 6) {
                tile6.setIcon(aiSymbol);
                tile6.setText("");
                tile6.setEnabled(false);
                controller.setPlayerOrAITaken(6, "ai");
            } else if (aiMove == 7) {
                tile7.setIcon(aiSymbol);
                tile7.setText("");
                tile7.setEnabled(false);
                controller.setPlayerOrAITaken(7, "ai");
            } else if (aiMove == 8) {
                tile8.setIcon(aiSymbol);
                tile8.setText("");
                tile8.setEnabled(false);
                controller.setPlayerOrAITaken(8, "ai");
            } else if (aiMove == 9) {
                tile9.setIcon(aiSymbol);
                tile9.setText("");
                tile9.setEnabled(false);
                controller.setPlayerOrAITaken(9, "ai");
            }
        }
        System.out.println("ai moved");
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
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        JButton clickedButton = (JButton) source;
        String text = clickedButton.getText();

        if (text.contains("Tile")) {
            System.out.println("tile clicked");
            updateScreenPlayerMove(text);
            updateScreenAIMove();
            if (controller.getPlayerWin() || controller.getAIWin())
                controller.play();
        }
    }
}
