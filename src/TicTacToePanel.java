import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToePanel extends JPanel implements ActionListener {
    private Player p;
    private TicTacToeGame controller;
    private SpringLayout panelLayout;
    private JButton tile1;
    private JButton tile2;
    private JButton tile3;
    private JButton tile4;
    private JButton tile5;
    private JButton tile6;
    private JButton tile7;
    private JButton tile8;
    private JButton tile9;
    private JButton startAgainButton;

    public TicTacToePanel(TicTacToeGame controllerRef) {
        super();
        controller = controllerRef;
        panelLayout = new SpringLayout();
        setupPanel();
    }

    public void setupPanel() {
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

    private void updateScreen(String tile) {

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
        startAgainButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source instanceof JButton) {
            JButton clickedButton = (JButton) source;
            String text = clickedButton.getText();

            if (text.contains("Tile")) {
                updateScreen(text);
            } else if (text.equals("Start again")) {
                controller.reset();
                TicTacToeGame game = new TicTacToeGame();
            }
        } /* else if (source instanceof Timer) {


            timerFires();
        } */
    }


    //button.newPreference(setDimension)
}
