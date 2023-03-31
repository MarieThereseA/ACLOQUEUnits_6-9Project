import java.util.*;
public class BlackJack{
  private Player p1;
  private Deck[][] deck;
  private static final String WHITE = "\033[1;37m";
  private static final String RED = "\033[1;31m";
  private static final String RESET = "\u001B[0m";
  private Scanner scan;

  public BlackJack(){
    deck = new Deck[1][4];
    scan = new Scanner(System.in);
  }

  public void play(){
    start();
    menu();
    boolean valid = false;
    while (!valid) {
      int choice = scan.nextInt();
      if (choice == 1){
        game();
        valid = true;
      }else if (choice == 2){
        info();
        valid = true;
      }else {
        System.out.println("Invalid choice, Please choose 1 or 2");
      }
    }
  }

  private void shuffle(){

  }

  private void deal(){

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
    System.out.println("What's your name?");
    String name = scan.nextLine();
    p1 = new Player(name);
  }

  private void menu(){
    System.out.println("1. Play");
    System.out.println("┌-▀█┌-▀█┌-▀█┌-▀█ \n" +
            "| ♣ || ♥ || ♦ |.| ♠ | ♥|\n" +
            "█▄┘█▄-┘█▄-┘█▄-┘ ");
    System.out.println("2. Player Info");
    System.out.println("");
  }

  private void game(){

  }

  private void info(){
    System.out.println(p1.toString());
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