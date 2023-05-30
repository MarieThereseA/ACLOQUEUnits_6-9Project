import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GameFrame extends JFrame{
    private JPanel panelCards;
    private BlackJack controller;
    private StartPanel startPanel;
    private MenuPanel menuPanel;
    private BetPanel betPanel;
    private GamePanel gamePanel;
    private InfoPanel infoPanel;

    public GameFrame(BlackJack controllerRef){
        super();
        controller = controllerRef;
        panelCards = new JPanel(new CardLayout());
        startPanel = new StartPanel(controller);
        menuPanel = new MenuPanel(controller);
        betPanel = new BetPanel(controller);
        gamePanel = new GamePanel(controller);
        infoPanel = new InfoPanel(controller);
        setupFrame();
    }

    private void setupFrame(){
        setSize(1500,1000);
        setResizable(false);
        setTitle("BlackJack");
        JLabel backgroundImg = new JLabel(new ImageIcon("src/gradient.png"));
        backgroundImg.setLayout(new BorderLayout());
        setContentPane(backgroundImg);
        try{
            setIconImage((ImageIO.read(new File("src/blackjackPic.png"))));
        }catch (Exception e){
            e.printStackTrace();
        }
        backgroundImg.add(panelCards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelCards.add(startPanel, "START");
        panelCards.add(menuPanel, "MENU");
        panelCards.add(betPanel, "BET");
        panelCards.add(gamePanel, "GAME");
        panelCards.add(infoPanel, "INFO");

        replaceScreen("START");

        setVisible(true);
    }

    public void replaceScreen(String screen){
        if (screen.equals("GAME")){
            LayoutManager layout = panelCards.getLayout();
            CardLayout cardLayout = (CardLayout) layout;
            cardLayout.show(panelCards, screen);
//            gamePanel.start(controller.start());
        }else if (screen.equals("INFO")){
            LayoutManager layout = panelCards.getLayout();
            CardLayout cardLayout = (CardLayout) layout;
            cardLayout.show(panelCards, screen);
//            infoPanel.start(controller.info());
        }else if (screen.equals("MENU")){
            LayoutManager layout = panelCards.getLayout();
            CardLayout cardLayout = (CardLayout) layout;
            cardLayout.show(panelCards, screen);
//            menuPanel.start(controller.menu());
        }else if (screen.equals("BET")){
            LayoutManager layout = panelCards.getLayout();
            CardLayout cardLayout = (CardLayout) layout;
            cardLayout.show(panelCards, screen);
//            betPanel.start(controller.game());
        }else if (screen.equals("START")){
            LayoutManager layout = panelCards.getLayout();
            CardLayout cardLayout = (CardLayout) layout;
            cardLayout.show(panelCards, screen);
        }

        LayoutManager layout = panelCards.getLayout();
        CardLayout cardLayout = (CardLayout) layout;
        cardLayout.show(panelCards, screen);
    }

    public void exit(){
//        controller.reset();
        replaceScreen("START");
    }







}


