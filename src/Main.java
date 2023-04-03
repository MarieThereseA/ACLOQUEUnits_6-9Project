public class Main {
    private static final String RED = "\u001B[41m";
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[44m";
    private static final String GREEN = "\u001B[42m";
    private static final String WHITE = "\u001B[44m";
    public static void main(String[] args) {
//         BlackJack game = new BlackJack();
//         game.play();
      // System.out.println("❤   ♣   ♠   ♦");
            Deck deck = new Deck();
            deck.shuffle();
            System.out.println(deck.toString());
      
    }
}