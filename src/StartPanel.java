import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class StartPanel extends JPanel implements ActionListener {
    private BlackJack controller;
    private SpringLayout panelLayout;
    private JTextPane welcomeLabel;
    private JLabel instructionsLabel;
    private JLabel userNameLabel;
    private JLabel IDLabel;
    private JTextField userNameField;
    private JTextField IDField;
    private JButton createAccountButton;
    private JButton loginButton;
    private JTextPane textPane1;


    public StartPanel(BlackJack controllerRef){
        super();
        controller = controllerRef;
        panelLayout = new SpringLayout();
        Image image = null;
        try{
            BufferedImage bufferedImage = ImageIO.read(new File("src/blackjackPic.png"));
            image = bufferedImage.getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
        }
        // BlackJack image cloudinary.com && tutorialspoint.com
        welcomeLabel = new JTextPane();
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setItalic(attributeSet, true);
        welcomeLabel.setCharacterAttributes(attributeSet, true);
        welcomeLabel.setText("");
        Font font = new Font("Verdana", Font.BOLD, 10);
        welcomeLabel.setFont(font);
        StyledDocument doc = (StyledDocument) welcomeLabel.getDocument();
        Style style = doc.addStyle("StyleName", null);
        StyleConstants.setIcon(style, new ImageIcon(image));
        try {
            doc.insertString(0, "invisible text", style);
        }catch (Exception e){
            e.printStackTrace();
        }
        welcomeLabel.setEditable(false);

        instructionsLabel = new JLabel("Login or Create an account");
        userNameLabel = new JLabel("User Name:");
        IDLabel = new JLabel("ID Number: ");
        userNameField = new JTextField("                ");
        IDField = new JTextField("                ");
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
        add(welcomeLabel);
        add(instructionsLabel);
        add(userNameLabel);
        add(userNameField);
        add(IDLabel);
        add(IDField);
        add(loginButton);
        add(createAccountButton);

    }

    private void setupLayout(){
        panelLayout.putConstraint(SpringLayout.NORTH, welcomeLabel,5, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, welcomeLabel,5, SpringLayout.WEST, this);

        panelLayout.putConstraint(SpringLayout.NORTH, instructionsLabel, 5, SpringLayout.SOUTH, welcomeLabel);
        panelLayout.putConstraint(SpringLayout.WEST, instructionsLabel, 5, SpringLayout.WEST, this);

        panelLayout.putConstraint(SpringLayout.NORTH, userNameLabel, 10, SpringLayout.SOUTH, instructionsLabel);
        panelLayout.putConstraint(SpringLayout.WEST, userNameLabel, 10, SpringLayout.WEST, this);

        panelLayout.putConstraint(SpringLayout.NORTH, userNameField, 5, SpringLayout.SOUTH, userNameLabel);
        panelLayout.putConstraint(SpringLayout.WEST, userNameField, 5, SpringLayout.WEST, this);

        panelLayout.putConstraint(SpringLayout.NORTH, IDLabel, 10, SpringLayout.SOUTH, userNameField);
        panelLayout.putConstraint(SpringLayout.WEST, IDLabel, 10, SpringLayout.WEST, this);

        panelLayout.putConstraint(SpringLayout.NORTH, IDField, 5, SpringLayout.SOUTH, IDLabel);
        panelLayout.putConstraint(SpringLayout.WEST, IDField, 5, SpringLayout.WEST, this);


        panelLayout.putConstraint(SpringLayout.NORTH, loginButton, 10, SpringLayout.SOUTH, IDField);
        panelLayout.putConstraint(SpringLayout.WEST, loginButton, 10, SpringLayout.WEST, this);

        panelLayout.putConstraint(SpringLayout.NORTH, createAccountButton, 5, SpringLayout.SOUTH, loginButton);
        panelLayout.putConstraint(SpringLayout.WEST, createAccountButton, 5, SpringLayout.WEST, this);
    }

    private void setupListeners(){
        loginButton.addActionListener(this);
        createAccountButton.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon("gradient.png");
        Image bgImage = imageIcon.getImage();
        g.drawImage(bgImage, 0, 0, this);
    }

    private boolean verifyID(int ID){
        return true;
    }



}


