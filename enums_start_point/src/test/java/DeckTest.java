import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {
    private Deck deck;
    private Card card;

    @Before
    public void before(){
        this.deck = new Deck();
        this.card = new Card(SuitType.HEARTS, RankType.ACE);
    }

    @Test
    public void getCardsCount(){
        assertEquals(0, deck.cardsCount());
    }

    @Test
    public void deckIsPopulated(){
        assertEquals(0, deck.cardsCount());
        deck.populate();
        assertEquals(52, deck.cardsCount());
    }

    @Test
    public void canDealCard(){
        deck.populate();
        assertEquals(52, deck.cardsCount());
        Card dealtCard = deck.dealCard();
        assertEquals(card.getSuit(), dealtCard.getSuit());
        assertEquals(card.getRank(), dealtCard.getRank());
    }

    @Test
    public void checkShuffleReturnsFullDeck(){
        deck.populate();
        assertEquals(52, deck.cardsCount());
        deck.shuffle();
        assertEquals(52, deck.cardsCount());
    }

    @Test
    public void checkDeckIsShuffled(){
        deck.populate();
        assertEquals(52, deck.cardsCount());
        Card dealtCard = deck.dealCard();
        assertEquals(card.getSuit(), dealtCard.getSuit());
        assertEquals(card.getRank(), dealtCard.getRank());
        deck.shuffle();
        assertEquals(52, deck.cardsCount());
        Card newDealtCard = deck.dealCard();
        assertNotEquals(card.getSuit(), newDealtCard.getSuit());
        assertNotEquals(card.getRank(), newDealtCard.getRank());
    }
}
