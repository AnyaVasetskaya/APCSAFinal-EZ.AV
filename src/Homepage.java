import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JPanel implements ActionListener {

    private TicTacToeGame controller;
    private SpringLayout panelLayout;

    private JLabel welcome;
    private JPanel Homepage;
    private JButton rabbitButton;
    private JButton cattButton;
    private JButton corgiButton;
    private String symbol;
    private ImageIcon happrabbit;
    private ImageIcon grumpcatt;
    private ImageIcon corgiwoof;

    public Homepage(TicTacToeGame controllerRef) {
        super();
        controller = controllerRef;
        panelLayout = new SpringLayout();
        welcome = new JLabel("Welcome to Tic Tac Autoe! Choose an avatar to start:");
        welcome.setFont(new Font("Courier", Font.BOLD,28));

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
        Image scaledCorgiPic = corgiPic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        corgiwoof = new ImageIcon(scaledCorgiPic);

        rabbitButton = new JButton("rabbit", happrabbit);
        cattButton = new JButton("catt", grumpcatt);
        corgiButton = new JButton("corgi", corgiwoof);

        symbol = "";

        setupPanel();
        setupLayout();
        setupListeners();
    }

    private void setupPanel() {
        setLayout(panelLayout);
        add(welcome);
        add(rabbitButton);
        add(cattButton);
        add(corgiButton);
    }

    private void setupLayout() {
        panelLayout.putConstraint(SpringLayout.NORTH, welcome, 100, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, welcome, 15, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.NORTH, cattButton, 300, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, cattButton, 25, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.NORTH, rabbitButton, 300, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, rabbitButton, 300, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.NORTH, corgiButton, 300, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, corgiButton, 600, SpringLayout.WEST, this);
    }

    private void setupListeners() {
        cattButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        corgiButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        JButton clickedButton = (JButton) source;
        String text = clickedButton.getText();

        if (text.equals("catt")) {
            symbol = "catt";
        } else if (text.equals("rabbit")){
            symbol = "rabbit";
        } else {
            symbol = "corgi";
        }
        controller.play();
    }

    public String getSymbol() {
        return symbol;
    }
}