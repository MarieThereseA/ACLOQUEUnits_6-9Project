import javax.swing.*;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {
    private BlackJack controller;
    private ButtonGroup typeGroup;
    private SpringLayout panelLayout;
    private JLabel welcomeLabel;
    private JTextField answerField;
    private JButton nextButton;
    private JButton startButton;

}

public StartPanel(BlackJack controllerRef){
    super();
    controller = controllerRef;
    panelLayout = new SpringLayout();

}
