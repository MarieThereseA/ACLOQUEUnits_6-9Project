import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {
    private BlackJack controller;
    private SpringLayout panelLayout;
    private JTextPane welcomePane;
    private JLabel instructionsLabel;
    private JLabel userNameLabel;
    private JLabel IDLabel;
    private JTextField userNameField;
    private JTextField IDField;
    private JButton createAccountButton;
    private JButton loginButton;


    public StartPanel(BlackJack controllerRef){
        super();
        controller = controllerRef;
        panelLayout = new SpringLayout();
        welcomePane = new JTextPane();
        welcomePane.insertIcon(new ImageIcon("blackjackPic.png"));
        instructionsLabel = new JLabel("Login or Create an account");
        userNameLabel = new JLabel("User Name:");
        IDLabel = new JLabel("ID Number: ");
        userNameField = new JTextField("");
        IDField = new JTextField("");
        createAccountButton = new JButton("Create Account");
        loginButton = new JButton("Login");

        setupPanel();
        setupLayout();
        setupListeners();
    }

    public void actionPerformed(ActionEvent ae){

    }

    public void start(){

    }

    private void setupPanel(){
        setLayout(panelLayout);
        add(welcomePane);
        add(instructionsLabel);
        add(userNameLabel);
        add(userNameField);
        add(IDLabel);
        add(IDField);
        add(loginButton);
        add(createAccountButton);
    }

    private void setupLayout(){
        panelLayout.putConstraint(SpringLayout.NORTH, welcomePane,5, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.NORTH, instructionsLabel, 5, SpringLayout.SOUTH, welcomePane);
        panelLayout.putConstraint(SpringLayout.NORTH, userNameLabel, 10, SpringLayout.SOUTH, instructionsLabel);
        panelLayout.putConstraint(SpringLayout.NORTH, userNameField, 5, SpringLayout.SOUTH, userNameLabel);
        panelLayout.putConstraint(SpringLayout.NORTH, IDLabel, 10, SpringLayout.SOUTH, userNameField);
        panelLayout.putConstraint(SpringLayout.NORTH, IDField, 5, SpringLayout.SOUTH, IDLabel);
        panelLayout.putConstraint(SpringLayout.NORTH, loginButton, 10, SpringLayout.SOUTH, IDLabel);
        panelLayout.putConstraint(SpringLayout.EAST, createAccountButton, 5, SpringLayout.WEST, IDLabel);
    }

    private void setupListeners(){
        loginButton.addActionListener(this);
        createAccountButton.addActionListener(this);
    }

    private boolean verifyID(int ID){
        return true;
    }



}


