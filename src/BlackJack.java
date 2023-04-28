import java.util.*;
import java.io.*;
public class BlackJack{
  private Player p1;
  private House house;
  private Deck[] decks;
  private int[] cardIdx;
  private static final String WHITE = "\033[1;37m";
  private static final String RED = "\033[1;31m";
  public static final String RED_BACKGROUND = "\033[41m";
  public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
  public static final String BLACK = "\033[0;30m";   // BLACK
  public static final String GREEN_BRIGHT = "\033[0;92m";
  public static final String WHITE_BRIGHT = "\033[4;37m";  // WHITE
  private static final String BLUE = "\u001b[34;1m";
  private static final String GREEN = "\u001b[32;1m";
  public static final String RESET = "\033[0m";
  private Scanner scan;

  public BlackJack(){
    decks = new Deck[4];
    decks[0] = new Deck();
    decks[1] = new Deck();
    decks[2] = new Deck();
    decks[3] = new Deck();
    cardIdx = new int[2];
    cardIdx[0] = 0;
    cardIdx[1] = 0;
    scan = new Scanner(System.in);
    house = new House("Dealer");
  }

  public void play(){
    start();
    menu();
  }

  private void start(){
    System.out.println("Welcome to: ");
    System.out.println(WHITE + "88          88                       88        88                       88         \n" +
            "88          88                       88        \"\"                       88         \n" +
            "88          88                       88                                 88         \n" +
            "88,dPPYba,  88 ,adPPYYba,  ,adPPYba, 88   ,d8  88 ,adPPYYba,  ,adPPYba, 88   ,d8" + RESET);
    System.out.print(RED +     "88P'    \"8a 88 \"\"     `Y8 a8\"     \"\" 88 ,a8\"   88 \"\"     `Y8 a8\"     \"\" 88 ,a8\"    \n" +
            "88       d8 88 ,adPPPPP88 8b         8888[     88 ,adPPPPP88 8b         8888[      \n" +
            "88b,   ,a8\" 88 88,    ,88 \"8a,   ,aa 88`\"Yba,  88 88,    ,88 \"8a,   ,aa 88`\"Yba,   \n" +
            "8Y\"Ybbd8\"'  88 `\"8bbdP\"Y8  `\"Ybbd8\"' 88   `Y8a 88 `\"8bbdP\"Y8  `\"Ybbd8\"' 88   `Y8a  \n" +
            "                                              ,88                                  \n" +
            "                                            888P\"   " + RESET);
    System.out.println();
    System.out.println("❤   ♣   ♠   ♦");
    System.out.println("\nWhat's your name?");
    String name = scan.nextLine();
    p1 = new Player(name);
  }


  private void menu(){
    boolean valid = false;
    boolean reiterate = true;
    while(reiterate){
      valid = false;
      while (!valid) {
        reiterate = true;
        System.out.println("\n" + WHITE_BACKGROUND + BLACK + "Menu" + RESET);
        System.out.println("1. Play");
        System.out.println("2. Player Info");
        System.out.println("3. Exit");
        System.out.println("");
        int choice = scan.nextInt();
        if (choice == 1) {
          game();
          valid = true;
          if (checkBankrupt()){
            reiterate = false;
          }else {
            reiterate = true;
          }
        } else if (choice == 2) {
          info();
          valid = true;
          reiterate = true;
        } else if (choice == 3){
          System.out.println("See you again :)");
          reiterate = false;
          valid = true;
        }else {
          System.out.println(RED + "Invalid choice, Please choose 1 or 2" + RESET);
        }
      }
    }
  }

  private void game(){
    int currentBet = 0;
    Card currentCard = null;

    //Placing Bet
    System.out.println("How much would you like to bet?");
    int maxBlack = p1.getMaxBet()[0];
    int maxGreen = p1.getMaxBet()[1];
    int maxBlue = p1.getMaxBet()[2];
    int blackBet = 0;
    int greenBet = 0;
    int blueBet = 0;
    System.out.print("Maximum Bet: Black($100) = " + maxBlack);
    System.out.print(" | Green($25) = " + maxGreen);
    System.out.println(" | Blue($10) = " + maxBlue);
    boolean valid = false;
    while(!valid){
      System.out.println(WHITE + "Black " + RESET + "Chips?");
      blackBet = scan.nextInt();
      scan.nextLine();

      System.out.println(GREEN + "Green " + RESET + "Chips?");
      greenBet = scan.nextInt();
      scan.nextLine();

      System.out.println(BLUE + "Blue " + RESET + "Chips?");
      blueBet = scan.nextInt();
      scan.nextLine();

      if ((blackBet <= maxBlack) && (greenBet <= maxGreen) && (blueBet <= maxBlue)){
        valid = true;
      }else if ((blackBet == 0 && maxBlack != 0) && (greenBet == 0 && maxGreen != 0) && (blueBet == 0 && maxBlue !=0)){
        System.out.println(RED + "Please place a bet; 0 is not a valid bet" + RESET);
      }else {
        System.out.println(RED + "\nPlease place a bet lower than or equal to the # of chips you have" + RESET);
      }
    }
    currentBet = (blackBet * 100) + (greenBet * 25) + (blueBet * 10);

    //Dealing first cards
    deal();
    boolean gameOver = false;
    boolean stand = false;
    boolean won = false;
    boolean tie = false;
    while(!gameOver){
      System.out.println(WHITE_BRIGHT + "\nHit (1) or Stand(2) ?" + RESET);
      int choice = scan.nextInt();
      scan.nextLine();
      if (choice == 1){ //Hit
        System.out.println(GREEN_BRIGHT + "\n" + p1.getName() + " hits!" + RESET);
        checkShuffle();
        currentCard = decks[cardIdx[0]].getCard(cardIdx[1]);
        p1.hit(currentCard);
        nextCardIdx();
        System.out.println(p1.getHand(true)); //Print Hand

        //Check if player busted
        gameOver = checkBust();
        if(gameOver){
          p1.lose(blackBet, greenBet, blueBet);
        }else {
          //Check if player hit 21
          gameOver = check21();
          if(gameOver){
            p1.win(blackBet, greenBet, blueBet);
            won = true;
          }
        }

      }else if (choice == 2){ //Stand
        System.out.println(GREEN_BRIGHT + "\n"+ p1.getName() + " Stands" + RESET);
        stand = true;
      }else{
        System.out.println(RED + "Invalid choice, Please choose 1 or 2" + RESET);
      }

      checkShuffle();
      currentCard = decks[cardIdx[0]].getCard(cardIdx[1]);

      if(stand){
        if(house.play(currentCard)){ //If Dealer hits
          nextCardIdx();
        }

        System.out.println(house.getHand(true));
        if (p1.getCurrentValue() > house.getCurrentValue()){
          System.out.println(WHITE_BRIGHT + "\n" + p1.getName() + " Wins!" + RESET);
          p1.win(blackBet, greenBet, blueBet);
          gameOver = true;
          won = true;
        }else if (p1.getCurrentValue() < house.getCurrentValue()){
          System.out.println(WHITE_BRIGHT + "\n" + house.getName() + " Wins!" + RESET);
          p1.lose(blackBet, greenBet, blueBet);
          gameOver = true;
        }else {
          System.out.println(WHITE_BRIGHT + "\n" + "Tie!" + RESET);
          gameOver = true;
          tie = true;
        }
      }else if (!gameOver){
        //Dealers turn
        if(house.play(currentCard)){ //If Dealer hits
          nextCardIdx();
          System.out.println(GREEN_BRIGHT + "\n" + house.getName() + " Hits!" + RESET);
          System.out.println(house.getHand(false)); //Print Hand

        }else { //if Dealer Stands
          System.out.println(GREEN_BRIGHT + house.getName() + " Stands" + RESET);
        }

      }
    }

    if(won){
      System.out.println("You won $" + currentBet);
    }else if (!won && !tie) {
      System.out.println("You lost $" + currentBet);
    }else {
      System.out.println("Nothing lost; nothing gained");
    }
    reset();
  }

  private void info(){
    System.out.println("\n" + p1.toString());
  }

  private void shuffle(){
    for (int i = 0; i < decks.length; i++){
      for (int j = 0; j < 3; j++){
        decks[i].shuffle();
        decks[i].shuffle();
      }
    }
  }


  private void deal(){
    shuffle();
    System.out.println("\n" + WHITE_BACKGROUND + BLACK + "Cards are Dealt" + RESET);
    Card card = null;
    for (int j = 0; j < 2; j++){
      checkShuffle();
      card = decks[cardIdx[0]].getCard(cardIdx[1]);
      // System.out.println(card.getName());
      p1.deal(card);
      nextCardIdx();
    }

    for (int j = 0; j < 2; j++){
      checkShuffle();
      card = decks[cardIdx[0]].getCard(cardIdx[1]);

      house.deal(card);
      nextCardIdx();
    }
    System.out.println("\n" + house.getHand(false));
    System.out.println(p1.getHand(true));
    System.out.println("");
  }

  private void nextCardIdx(){
    cardIdx[1]++;
    if (cardIdx[1] >= 54){
      cardIdx[0]++;
      if(cardIdx[0] >= 4){
        shuffle();
        cardIdx[0] = 0;
      }
      cardIdx[1] = 0;
    }
  }

  private void checkShuffle(){
    Card card = decks[cardIdx[0]].getCard(cardIdx[1]);
    while(card.isJoker()){
      shuffle();
      card = decks[cardIdx[0]].getCard(cardIdx[1]);
    }
  }

  private boolean checkBust(){
    if(p1.getCurrentValue() > 21){
      System.out.println(house.getHand(true)); //Print Hand
      System.out.println("\n" + RED_BACKGROUND + p1.getName() + " Busted :(" + RESET);
      System.out.println("\n" + WHITE_BRIGHT + house.getName() + " Wins!" + RESET);
      return true;
    }
    return false;
  }

  private boolean check21(){
    if(p1.getCurrentValue() == 21 && house.getCurrentValue() != 21){
      System.out.println(house.getHand(true)); //Print Hand
      System.out.println(WHITE_BRIGHT + p1.getName() + " Wins!" + RESET);
      return true;
    }
    return false;
  }

  private void reset(){
    house.reset();
    p1.reset();
  }

  private boolean checkBankrupt(){
    if (p1.getBank() == 0){
      System.out.println("\n" + RED + "Game Over :(" + RESET);
      System.out.println("\n" + RED_BACKGROUND + "You've gone bankrupt :(" + RESET);
      return true;
    }
    return false;
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