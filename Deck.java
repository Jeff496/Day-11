import java.util.ArrayList;
import java.util.Collections;

class Deck {
  private ArrayList<Card> deck;

  public Deck() {
    this.deck = new ArrayList<Card>();
  } 
   
  public ArrayList<Card> getDeck() {
    return this.deck;
  }

  public void makeDeck() {
    // creates a full deck of 52 cards
    // all 4 suits and all 13 card from each suit

    for (int i = 1; i <= 13; i++) {
      deck.add(new Card("spades", i)); 
    }
    for (int i = 1; i <= 13; i++) {
      deck.add(new Card("clubs", i)); 
    }
    for (int i = 1; i <= 13; i++) {
      deck.add(new Card("diamonds", i)); 
    }
    for (int i = 1; i <= 13; i++) {
      deck.add(new Card("hearts", i)); 
    }
  }

  public Card draw() {
    Card hold = deck.get(0);
    deck.remove(0);
    return hold;
  }

  public void shuffle() {
    Collections.shuffle(this.deck);
  }

}