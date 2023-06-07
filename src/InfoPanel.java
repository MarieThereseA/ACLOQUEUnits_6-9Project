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
        panelLayout = new SpringLayout();

        statsPane = new JTextPane();
        backButton = new JButton("Back");


        setupPanel();
        setupLayout();
        setupListeners();
    }

    public void setUpInfo(){

    }

    public void actionPerformed(ActionEvent ae){

    }

    private void setupPanel(){
        setLayout(panelLayout);
        add(statsPane);
        add(backButton);
    }

    private void setupLayout(){

    }

    private void setupListeners(){

    }
}


