import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;


    public Deck(){
        this.cards = new ArrayList<>();
    }

    public int cardsCount(){
        return cards.size();
    }

    public void populate(){
        for (RankType rank : RankType.values()) {
            for (SuitType suit : SuitType.values()) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

    public Card dealCard(){
        return cards.get(0);
    }

    public void shuffle() {
        Collections.shuffle(Arrays.asList(cards));
        cards.sort();
        ArrayList newCards = new ArrayList<Card>();
        for (int i = 0; i < 52; i++) {
            int randomNumber = (int)(Math.random() * (52-i));

            newCards.add(cards.remove(randomNumber));
        }
        this.cards = newCards;
    }

}
