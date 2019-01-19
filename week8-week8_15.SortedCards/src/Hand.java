import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand>{
    private ArrayList<Card> cards;

    public Hand(){
        this.cards = new ArrayList<Card>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void print(){
        for(Card card : cards) {
            System.out.println(card);
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void sort() {
        Collections.sort(cards);
    }

    public void sortAgainstSuit(){
        Collections.sort(cards, new SortAgainstSuitAndValue());
    }

    private int calculateValue(){
        int total = 0;
        for(Card card : cards) {
            total += card.getValue();
        }

        return total;
    }

    @Override
    public int compareTo(Hand hand) {
        return calculateValue() - hand.calculateValue();
    }
}
