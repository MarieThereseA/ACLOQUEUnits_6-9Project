import javax.swing.*;
import java.awt.*;
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
        panelLayout = new SpringLayout();

        welcomeLabel = new JLabel();
        playButton = new JButton("Play");
        infoButton = new JButton("User Info");
        exitButton = new JButton("Exit");

        setupPanel();
        setupLayout();
        setupListeners();
    }

    public void setUp(){
        if (controller.isReturningPlayer()){
            welcomeLabel.setText("Welcome Back " + controller.getName());
        }else {
            welcomeLabel.setText("Welcome " + controller.getName());
        }
    }

    public void actionPerformed(ActionEvent ae){

    }

    private void setupPanel(){
        setLayout(panelLayout);
        add(welcomeLabel);
        add(playButton);
        add(infoButton);
        add(exitButton);

        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        playButton.setFont(new Font("SansSerif", Font.PLAIN, 36));
        infoButton.setFont(new Font("SansSerif", Font.PLAIN, 36));
        exitButton.setFont(new Font("SansSerif", Font.PLAIN, 36));
    }

    private void setupLayout(){
        panelLayout.putConstraint(SpringLayout.WEST, welcomeLabel,15, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.NORTH, welcomeLabel,5, SpringLayout.NORTH, this);


        panelLayout.putConstraint(SpringLayout.NORTH, playButton,100, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, playButton,0, SpringLayout.HORIZONTAL_CENTER, this);

        panelLayout.putConstraint(SpringLayout.NORTH, infoButton,5, SpringLayout.SOUTH, playButton);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, infoButton,0, SpringLayout.HORIZONTAL_CENTER, this);

        panelLayout.putConstraint(SpringLayout.NORTH, exitButton,5, SpringLayout.SOUTH, infoButton);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, exitButton,0, SpringLayout.HORIZONTAL_CENTER, this);
    }

    private void setupListeners(){
        playButton.addActionListener(this);
        infoButton.addActionListener(this);
        exitButton.addActionListener(this);
    }
}




