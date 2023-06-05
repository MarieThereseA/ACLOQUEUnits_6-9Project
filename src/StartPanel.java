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
    private JButton createAccountButton2;
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
        instructionsLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        userNameLabel = new JLabel("User Name:");
        userNameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        IDLabel = new JLabel("ID Number: ");
        IDLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        userNameField = new JTextField("");
        userNameField.setColumns(10);
        userNameField.setFont(new Font("SansSerif", Font.PLAIN, 24));
        IDField = new JTextField("");
        IDField.setColumns(10);
        IDField.setFont(new Font("SansSerif", Font.PLAIN, 24));
        createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        createAccountButton2 = new JButton("Create New Account");
        createAccountButton2.setVisible(false);
        createAccountButton2.setFont(new Font("SansSerif", Font.PLAIN, 16));
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("SansSerif", Font.PLAIN, 16));

        setupPanel();
        setupLayout();
        setupListeners();
    }

    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        JButton button = (JButton)source;
        if (button.getText().equals("Login")){
            String userName = userNameField.getText();
            int ID = Integer.parseInt(IDField.getText());
            if (controller.login(userName, ID)){
                controller.start();
            }else{
                userNameField.setText("Invalid User Name or ID; Please try again");
                IDField.setText("");
                userNameField.setBackground(Color.RED);
            }

        }else if (button.getText().equals("Create Account")){
            IDField.setVisible(false);
            IDLabel.setVisible(false);
            loginButton.setVisible(false);
            createAccountButton.setVisible(false);
            createAccountButton.removeActionListener(this);
            createAccountButton2.setVisible(true);
            userNameField.setText("");
            userNameLabel.setText("Create a User Name");
        }else if (button.getText().equals("Create New Account")){
            String userName = userNameField.getText();
            controller.createAccount(userName);
            controller.start();
        }
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
        add(createAccountButton2);
    }

    private void setupLayout(){
        panelLayout.putConstraint(SpringLayout.NORTH, welcomeLabel,5, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcomeLabel,0, SpringLayout.HORIZONTAL_CENTER, this);

        panelLayout.putConstraint(SpringLayout.NORTH, instructionsLabel, 5, SpringLayout.SOUTH, welcomeLabel);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, instructionsLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);

        panelLayout.putConstraint(SpringLayout.NORTH, userNameLabel, 10, SpringLayout.SOUTH, instructionsLabel);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, userNameLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);

        panelLayout.putConstraint(SpringLayout.NORTH, userNameField, 5, SpringLayout.SOUTH, userNameLabel);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, userNameField, 0, SpringLayout.HORIZONTAL_CENTER, this);

        panelLayout.putConstraint(SpringLayout.NORTH, IDLabel, 10, SpringLayout.SOUTH, userNameField);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, IDLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);

        panelLayout.putConstraint(SpringLayout.NORTH, IDField, 5, SpringLayout.SOUTH, IDLabel);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, IDField, 0, SpringLayout.HORIZONTAL_CENTER, this);


        panelLayout.putConstraint(SpringLayout.NORTH, loginButton, 10, SpringLayout.SOUTH, IDField);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, loginButton, 0, SpringLayout.HORIZONTAL_CENTER, this);

        panelLayout.putConstraint(SpringLayout.NORTH, createAccountButton, 5, SpringLayout.SOUTH, loginButton);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, createAccountButton, 0, SpringLayout.HORIZONTAL_CENTER, this);

        panelLayout.putConstraint(SpringLayout.NORTH, createAccountButton2, 10, SpringLayout.SOUTH, userNameField);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, createAccountButton2, 0, SpringLayout.HORIZONTAL_CENTER, this);
    }

    private void setupListeners(){
        loginButton.addActionListener(this);
        createAccountButton.addActionListener(this);
        createAccountButton2.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon("gradient.png");
        Image bgImage = imageIcon.getImage();
        g.drawImage(bgImage, 0, 0, this);
    }



}


