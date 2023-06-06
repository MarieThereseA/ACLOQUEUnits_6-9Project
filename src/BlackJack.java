import java.util.*;
import java.io.*;
public class BlackJack{
  private GameFrame gameWindow;
  private Player p1;
  private House house;
  private Deck[] decks;
  private int[] cardIdx;
  private boolean isReturningPlayer;

  public BlackJack(){
    p1 = new Player();
    decks = new Deck[4];
    decks[0] = new Deck();
    decks[1] = new Deck();
    decks[2] = new Deck();
    decks[3] = new Deck();
    cardIdx = new int[2];
    cardIdx[0] = 0;
    cardIdx[1] = 0;
    house = new House("Dealer");
    gameWindow = new GameFrame(this);
  }

  public void start(){
    gameWindow.replaceScreen("MENU");
  }

  public boolean login(String userName, int IDNum){
    SaveFile sf = new SaveFile();
    if (sf.confirmIDNum(userName, IDNum)){
      p1 = new Player(userName, IDNum);
      p1.getInfo(sf.getData(userName, IDNum));
      isReturningPlayer = true;
      return true;
    }else {
      return false;
    }
  }

  public void createAccount(String userName){
    SaveFile sf = new SaveFile(userName);
    p1 = new Player(userName, sf.getIDNum());
    isReturningPlayer = false;

  }

  public String getName(){
    return p1.getName() + "#" + p1.getID();
  }

  public boolean isReturningPlayer(){
    return isReturningPlayer;
  }

  public String getInfo(){
    return "";
  }

}



 /*
    88          88                       88        88                       88
    88          88                       88        ""                       88
    88          88                       88                                 88
    88,dPPYba,  88 ,adPPYYba,  ,adPPYba, 88   ,d8  88 ,adPPYYba,  ,adPPYba, 88   ,d8
    88P'    "8a 88 ""     `Y8 a8"     "" 88 ,a8"   88 ""     `Y8 a8"     "" 88 ,a8"
    88       d8 88 ,adPPPPP88 8b         8888[     88 ,adPPPPP88 8b         8888[
    88b,   ,a8" 88 88,    ,88 "8a,   ,aa 88`"Yba,  88 88,    ,88 "8a,   ,aa 88`"Yba,
    8Y"Ybbd8"'  88 `"8bbdP"Y8  `"Ybbd8"' 88   `Y8a 88 `"8bbdP"Y8  `"Ybbd8"' 88   `Y8a
                                                  ,88
                                                888P"
  */