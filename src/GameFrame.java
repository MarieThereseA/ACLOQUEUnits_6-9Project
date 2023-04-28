import javax.swing.*;
import java.awt.*;
public class GameFrame extends JFrame{
private StartPanel startPanel;
private GamePanel gamePanel;
private InfoPanel infoPanel;
private JPanel panelCards;
private BlackJack controller;

    public GameFrame(BlackJack controllerRef){
        super();
        controller = controllerRef;
        panelCards = new JPanel(new CardLayout());
        startPanel = new StartPanel(controller);
        gamePanel = new GamePanel(controller);
        infoPanel = new InfoPanel(controller);
        setupFrame();
    }

    private void setupFrame(){
        setSize(1000,1000);
        setTitle("BlackJack");
        add(panelCards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelCards.add(startPanel, "START");
        panelCards.add(gamePanel, "GAME");
        panelCards.add(infoPanel, "INFO");

        replaceScreen("START");

        setVisible(true);
    }

    public void replaceScreen(String screen){
        if (screen.equals("GAME")){
            gamePanel.start(controller.start());
        }else {
            infoPanel.showInfo(controller.info());
        }

        LayoutManager layout = panelCards.getLayout();
        CardLayout cardLayout = (CardLayout) layout;
        cardLayout.show(panelCards, screen);
    }

    public void reset(){
        controller.reset();
        replaceScreen("START");
    }







}


