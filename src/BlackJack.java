import java.util.*;
public class BlackJack{
  private Player p1;
//  private House house;
  private Deck[][] deck;
  private ArrayList<Card> houseHand;
  private ArrayList<SaveFile> savedPlayers;
  private SaveFile thisPlayer;
  private static final String WHITE = "\033[1;37m";
  private static final String RED = "\033[1;31m";
  private static final String RESET = "\u001B[0m";
  private Scanner scan;

  public BlackJack(){
    deck = new Deck[1][4];
    houseHand = new ArrayList<>();
    scan = new Scanner(System.in);
    savedPlayers = new ArrayList<>();
    thisPlayer = new SaveFile(null);
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
    boolean valid = false;
    while (!valid){
      System.out.println("Are you an existing Player; Yes(1) / No(2)");
      int answer = scan.nextInt();
      scan.nextLine();
      if (answer == 1){
        System.out.println("What's your ID Number?");
        int IDNum = scan.nextInt();
        scan.nextLine();
        p1 = new Player(null);
        for (int i = 0; i < savedPlayers.size(); i++){
          if (savedPlayers.get(i).confirmIDNum(IDNum)){
            p1 = savedPlayers.get(i).getPlayer();
            thisPlayer = savedPlayers.get(i);
          }
        }
        System.out.println("Welcome Back " + p1.getName());
        valid = true;
      }else if (answer == 2){
        System.out.println("\nWhat's your name?");
        String name = scan.nextLine();
        p1 = new Player(name);
        thisPlayer = new SaveFile(p1);
        savedPlayers.add(thisPlayer);
        System.out.println("\nYour IDNum is: " + thisPlayer.getIDNum());
        System.out.println("Remember this Number!!");
        valid = true;
      }else {
        System.out.println("Invalid choice, Please choose 1 or 2");
      }
    }

  }

  private void menu(){
    boolean valid = false;
    while (!valid) {
      System.out.println("\nMenu");
      System.out.println("1. Play");
//    System.out.println("┌-▀█┌-▀█┌-▀█┌-▀█ \n" +
//            "| ♣ || ♥ || ♦ |.| ♠ | ♥|\n" +
//            "█▄┘█▄-┘█▄-┘█▄-┘ ");
      System.out.println("2. Player Info");
      System.out.println("");
      int choice = scan.nextInt();
      if (choice == 1) {
        game();
        valid = true;
      } else if (choice == 2) {
        info();
        valid = true;
      } else {
        System.out.println("Invalid choice, Please choose 1 or 2");
      }
    }
  }

  private void game(){
    int row = 0;
    int col = 1;
    p1.hit(deck[row][col]);
  }

  private void info(){
    System.out.println("\n" + thisPlayer.stats());
  }

  private void shuffle(){
    for (int i = 0; i < deck[0].length; i++){
      deck[0][i].shuffle();
    }
  }

  private void deal(){
    p1.hit(deck[0][0]);
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