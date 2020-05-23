// Card has numbers and suits
// Numbers: Ace - King
// Suits: spades, clubs, diamonds, and hearts
class Card {
  private String suits;
  private int numbers;

  public Card() {
    this.suits = "spades";
    this.numbers = 4;
  }

  public Card(String suits, int numbers) {
    this.suits = suits;
    this.numbers = numbers;
  }

  public int getNumber() {
    return this.numbers;
  }
  
  public String getSuits() {
    return this.suits;
  }

  public void setNumber(int number) {
    this.numbers = number;
  }

  public void setSuits(String suits) {
    this.suits = suits;
  }

}