import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPanel extends JPanel implements ActionListener {

    private BlackJack controller;
    private SpringLayout panelLayout;
    private JTextPane statsPane;
    private JButton backButton;

    public InfoPanel(BlackJack controllerRef){
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


