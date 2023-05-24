import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    private BlackJack controller;
    private SpringLayout panelLayout;
    private JLabel shuffleLabel;
    private JLabel deckValueLabel1;
    private JLabel deckValueLabel2;
    private JLabel gameResultLabel;
    private JButton hitButton;
    private JButton standButton;

    public GamePanel(BlackJack controllerRef){
        super();
        controller = controllerRef;


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
