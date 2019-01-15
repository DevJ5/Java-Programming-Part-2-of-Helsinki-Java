import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand>{
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        for(Card card : cards) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(cards);
    }

    public int valueOfHand() {
        int total = 0;
        for (Card card : cards) {
            total += card.getValue();
        }
        return total;
    }

    @Override
    public int compareTo(Hand o) {
        return this.valueOfHand() - o.valueOfHand();
    }

    public void sortAgainstSuit() {
        SortAgainstSuitAndValue sortSuit = new SortAgainstSuitAndValue();
        Collections.sort(cards, sortSuit);
    }
}
