import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {

    private BlackJack controller;
    private SpringLayout panelLayout;
    private JLabel welcomeLabel;
    private JButton playButton;
    private JButton infoButton;
    private JButton exitButton;


    public MenuPanel (BlackJack controllerRef){
        super();
        controller = controllerRef;



        setupPanel();
        setupLayout();
        setupListeners();
    }

    public void actionPerformed(ActionEvent ae){

    }

    public void start(){

    }

    private void setupPanel(){

    }

    private void setupLayout(){

    }

    private void setupListeners(){

    }
}




