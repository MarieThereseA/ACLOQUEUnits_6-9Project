import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {
    private BlackJack controller;
    private SpringLayout panelLayout;
    private JTextPane welcomePane;
    private JLabel userNameLabel;
    private JLabel instructionsLabel;
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
        welcomePane.insertIcon(new ImageIcon(blackjackPic.png));


        setupPanel();
        setupLayout();
        setupListeners();


    }

    private void setupPanel(){

    }

    private void setupLayout(){

    }

    private void setupListeners(){

    }

    public void actionPerformed(ActionEvent ae){

    }
}


