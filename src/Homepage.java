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
    private ImageIcon happrabbit;
    private ImageIcon happcatt;

    public Homepage(TicTacToeGame controllerRef) {
        super();
        controller = controllerRef;
        panelLayout = new SpringLayout();
        welcome = new JLabel("Welcome to Tic Tac Autoe! Choose X / O to start:");
        welcome.setFont(new Font("Courier", Font.BOLD,28));

        happrabbit = new ImageIcon("src//happrabbit.png");
        Image rabbitPic = happrabbit.getImage();
        Image scaledRabbitPic = rabbitPic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        happrabbit = new ImageIcon(scaledRabbitPic);
        happcatt = new ImageIcon("src//happcatt.png");
        Image cattPic = happcatt.getImage();
        Image scaledCattPic = cattPic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        happcatt = new ImageIcon(scaledCattPic);

        oButton = new JButton("rabbit", happrabbit);
        xButton = new JButton("catt", happcatt);

        symbol = "";

        setupPanel();
        setupLayout();
        setupListeners();
    }

    private void setupPanel() {
        setLayout(panelLayout);
        add(welcome);
        add(oButton);
        add(xButton);
    }

    private void setupLayout() {
        panelLayout.putConstraint(SpringLayout.NORTH, welcome, 100, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, welcome, 70, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.NORTH, xButton, 300, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, xButton, 200, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.NORTH, oButton, 300, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, oButton, 500, SpringLayout.WEST, this);
    }

    private void setupListeners() {
        xButton.addActionListener(this);
        oButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        JButton clickedButton = (JButton) source;
        String text = clickedButton.getText();

        if (text.equals("catt")) {
            symbol = "catt";
            controller.play();
        } else {
            symbol = "rabbit";
            controller.play();
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public String getAISymbol() { return symbol.equals("catt") ? "rabbit" : "catt"; }
}