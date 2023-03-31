import java.util.ArrayList;

public class Deck extends Card{
    private Card[] deck; //Represents a standard 54 card deck as an array

    public Deck(){
        deck = new Card[54];
        this.createDeck();
    }

    //Getter & Setter Methods
    public Card[] getDeck(){
        return deck;
    }

    //Other Methods
    public void shuffleDeck(){
        ArrayList<Integer> chosen1 = new ArrayList<>(); // 0 - 26
        ArrayList<Integer> chosen2 = new ArrayList<>(); // 26 - 54
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while(idx != idx1){

        }

        while(idx != idx1){

        }




    }

    //Private Helper Methods

    private void createDeck(){
        int idx = 1;
        deck[0] = new Card();
        String suit = "Heart";
        int suitNum = 1;
        while (idx < deck.length){
            //Adding Hearts & Clubs
            if (suitNum == 1 || suitNum == 2){
                deck[idx] = new Card(suit, "Ace");
                idx++;
                for (int i = 2; i <= 10; i++){
                    deck[idx] = new Card(suit, i);
                    idx++;
                }
                idx++;
                deck[idx] = new Card(suit, "Jack");
                deck[idx] = new Card(suit, "Queen");
                deck[idx] = new Card(suit, "King");
                idx += 3;

            }else { //Adding Diamonds + Spades
                deck[idx] = new Card(suit, "King");
                deck[idx] = new Card(suit, "Queen");
                deck[idx] = new Card(suit, "Jack");
                idx += 3;
                for (int i = 10; i >= 2; i--){
                    deck[idx] = new Card(suit, i);
                    idx++;
                }
                idx++;
                deck[idx] = new Card(suit, "Ace");
                idx++;

            }
            suitNum++;
            if (suitNum == 2){
                suit = "Club";
            }else if (suitNum == 3){
                suit = "Diamond";
            }else {
                suit = "Spade";
            }
        }
        deck[idx] = new Card();
        idx++;
        deck[idx] = new Card();
    }

//    @Override
//    public String toString(){
//
//    }

}
