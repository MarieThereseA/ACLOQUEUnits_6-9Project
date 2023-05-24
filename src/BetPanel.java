import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class BetPanel extends JPanel implements ActionListener, ChangeListener {
    private BlackJack controller;
    private SpringLayout panelLayout;
    private JTextPane chipsPane;
    private JLabel instructionsLabel;
    private JLabel betLabel;
    private JLabel blackChipsLabel;
    private JLabel blueChipsLabel;
    private JLabel greenChipsLabel;
    private JSlider blackChipsSlider;
    private JSlider blueChipsSlider;
    private JSlider greenChipsSlider;
    private JButton playButton;

    public BetPanel(BlackJack controllerRef){
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

    public void stateChanged(ChangeEvent ce){

    }
}
