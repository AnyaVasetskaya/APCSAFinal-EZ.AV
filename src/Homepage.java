import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JPanel implements ActionListener {

    private TicTacToeGame controller;
    private SpringLayout panelLayout;

    private JLabel welcome;
    private JPanel Homepage;
    private JButton oButton;
    private JButton xButton;
    private String symbol;

    public Homepage(TicTacToeGame controllerRef) {
        super();
        controller = controllerRef;
        panelLayout = new SpringLayout();
        welcome = new JLabel("Welcome to Tic Tac Toe! Choose X / O to start:");
        welcome.setFont(new Font("Courier", Font.BOLD,28));
        oButton = new JButton("O");
        xButton = new JButton("X");
        symbol = "";

        setupPanel();
        setupLayout();
        setupListeners();
        //createUIComponents();
    }

    private void setupPanel() {
        setLayout(panelLayout);
        add(welcome);
        add(oButton);
        add(xButton);
    }

    private void setupLayout() {
        panelLayout.putConstraint(SpringLayout.NORTH, welcome, 100, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, welcome, 100, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.NORTH, xButton, 300, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, xButton, 400, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.NORTH, oButton, 300, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, oButton, 550, SpringLayout.WEST, this);
    }

    private void setupListeners() {
        xButton.addActionListener(this);
        oButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        JButton clickedButton = (JButton) source;
        String text = clickedButton.getText();

        if (text.equals("X")) {
            symbol = "X";
            controller.play();
        } else {
            symbol = "O";
            controller.play();
        }
    }

    public String getSymbol() {
        return symbol;
    }


}
