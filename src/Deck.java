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

    public Card getCard(){
        return deck[0];
    }
    //Other Methods

    public void shuffle(){
        int count = 0;
        while (count < 27){
            ArrayList<Integer> chosen1 = new ArrayList<>(); // 0 - 26
            ArrayList<Integer> chosen2 = new ArrayList<>(); // 26 - 54
            int idx1 = 0;
            int idx2 = 0;
            boolean valid = false;
            while(!valid){
                idx1 = (int) (Math.random() * (27));
                valid = true;
                for(int i = 0; i < chosen1.size(); i++){
                    if (chosen1.get(i) == idx1){
                        valid = false;
                    }
                }
            }

            while(!valid){
                idx2 = (int) (Math.random() * (28) + 27);
                valid = true;
                for(int i = 0; i < chosen1.size(); i++){
                    if (chosen1.get(i) == idx2){
                        valid = false;
                    }
                }
            }

            Card temp = deck[idx2];
            deck[idx2] = deck[idx1];
            deck[idx1] = temp;

            count++;
        }

    }

    //Private Helper Methods

    private void createDeck(){
        deck[0] = new Card();
        System.out.println(0 + deck[0].getName());
        int idx = 1;
        int suitNum = 1;
        String suit = "Heart";
        while (idx < deck.length){
            //Adding Hearts & Clubs
            if (suitNum == 1 || suitNum == 2){
                deck[idx] = new Card(suit, "Ace");
//                System.out.println(idx + " " + deck[idx].getName());
                idx++;
                for (int i = 2; i <= 10; i++){
                    deck[idx] = new Card(suit, i);
//                    System.out.println(idx + " " + deck[idx].getName());
                    idx++;
                }
//                idx++;
                deck[idx] = new Card(suit, "Jack");
//                System.out.println(idx + " " + deck[idx].getName());
                idx++;
                deck[idx] = new Card(suit, "Queen");
//                System.out.println(idx + " " + deck[idx].getName());
                idx++;
                deck[idx] = new Card(suit, "King");
//                System.out.println(idx + " " + deck[idx].getName());
                idx++;

            }else if ((suitNum == 3) || (suitNum == 4)) { //Adding Diamonds + Spades
                deck[idx] = new Card(suit, "King");
//                System.out.println(idx + " " + deck[idx].getName());
                idx++;
                deck[idx] = new Card(suit, "Queen");
//                System.out.println(idx + " " + deck[idx].getName());
                idx++;
                deck[idx] = new Card(suit, "Jack");
//                System.out.println(idx + " " + deck[idx].getName());
                idx++;
                for (int i = 10; i >= 2; i--){
                    deck[idx] = new Card(suit, i);
//                    System.out.println(idx + " " + deck[idx].getName());
                    idx++;
                }
                deck[idx] = new Card(suit, "Ace");
//                System.out.println(idx + " " + deck[idx].getName());
                idx++;

            }
            suitNum++;
            if (suitNum == 2){
                suit = "Club";
            }else if (suitNum == 3){
                suit = "Diamond";
            }else if (suitNum == 4){
                suit = "Spade";
            }else if (suitNum == 5) {
                deck[idx] = new Card();
                idx++;
            }
        }
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < deck.length; i++){
            str += "\n" + deck[i].getName();
        }
        return str;
    }
}
