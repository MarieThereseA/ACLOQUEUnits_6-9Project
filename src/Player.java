import java.util.*;
public class Player {
  String name;
  int bank;
  int wins;
  int losses;
  int games;
  int currentValue;
  ArrayList<Card> hand;
  ArrayList<Chip> black;
  ArrayList<Chip> green;
  ArrayList<Chip> blue;
  private static final String BLUE = "\u001b[34;1m";
  private static final String GREEN = "\u001b[32;1m";
  private static final String WHITE = "\u001b[37;1m";
  private static final String RESET = "\u001B[0m";


  public Player(String name){
    this.name = name;
    bank = 500;
    wins = 0;
    losses = 0;
    games = 0;
    currentValue = 0;
    hand = new ArrayList<>();
    black = new ArrayList<Chip>();
    green = new ArrayList<Chip>();
    blue = new ArrayList<Chip>();

    black.add(new Chip(100));
    for (int i = 0; i < 8; i++){
      green.add(new Chip(25));
    }
    for (int i = 0; i < 20; i++){
      blue.add(new Chip(10));
    }
  }

  public int getBank(){
    return bank;
  }

  public void updateBank(int change){
    int val = 0;
  }

  public void addGame(){
    games++;
  }

  public void addWin(){
    wins++;
  }

  public void addLoss(){
    losses++;
  }

  public String getName(){
    return name;
  }
  public String getChips(){
    String chips =WHITE + "Black ($100)" + RESET + ": " + black.size();
    chips+= GREEN + "\nGreen ($25)" + RESET + ": " + green.size();
    chips+= BLUE + "\nBlue ($10)" + RESET + ": " + blue.size();
    return chips;
  }

  public String toString(){
    String info = name + "'s Stats:";
    info+= "\nBank value: " + "$" + bank;
    info += "\nChips: \n" + getChips();
    info += "\nGames Played: " + games;
    info += "\nWins: " + wins;
    info += "\nLosses: " + losses;
    return info;
  }

  public void hit(Card card){
    hand.add(card);
    currentValue += card.getValue();
    System.out.println("Hit!");
    System.out.println(card.getName());
    System.out.println(name + ": " + currentValue);
    if (currentValue < 21){

    }else if (currentValue == 21){

    }else {

    }
  }






}