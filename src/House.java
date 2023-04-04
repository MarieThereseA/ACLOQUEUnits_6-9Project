import java.util.ArrayList;

public class House {
    private String name;

    private int currentValue;
    private ArrayList<Card> hand;

    public House(String name){
        this.name = name;
        currentValue = 0;
        hand = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getHandSize(){
        return hand.size();
    }

    public ArrayList<Card> getCards(){
        return hand;
    }
    public void setCurrentValue(int set){
        currentValue = set;
    }

    public void addToHand(Card card){
        hand.add(card);
    }

    public String getHand(boolean b){
        String str = name + "'s Cards:";
        if(b == false){
            str += "\n  [Hidden]";
            for (int i = 1; i < hand.size(); i++){
                str += "\n  " + hand.get(i).getName();
            }
        }else {
            for (int i = 0; i < hand.size(); i++){
                str += "\n  " + hand.get(i).getName();
            }
            str+= "\nTotal: " + currentValue;
        }
        return str;
    }

    public boolean play(Card card){
        if (currentValue < 17){
            hit(card);
            return true;
        }else {
            return false;
        }
    }


    public void deal(Card card){
        hand.add(card);
        if(card.isAce()){
            currentValue++;
        }else {
            currentValue += card.getValue();
        }
    }

    public void hit(Card card) {
        hand.add(card);
        if (card.isAce()){
            boolean anotherAce = false;
            for (int  i = 0; i < hand.size() - 1; i++){
                if (hand.get(i).isAce()){
                    anotherAce = true;
                }
            }
            if(anotherAce){
                currentValue++;
            }else {
                if ((currentValue + 11) > 17 && (currentValue + 11) < 21){
                    currentValue += 11;
                }else {
                    currentValue ++;
                }
            }
        }
        currentValue += card.getValue();
    }

    public void reset(){
        int i = 0;
        while (i < hand.size()){
            hand.remove(0);
            i++;
        }
        currentValue = 0;
    }
}
