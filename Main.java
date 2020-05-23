import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {

    Scanner choose = new Scanner(System.in);

    Deck newDeck = new Deck();
    newDeck.makeDeck();
    newDeck.shuffle();

    ArrayList<Card> playerCards = new ArrayList<Card>();
    ArrayList<Card> compCards = new ArrayList<Card>();
    int playerDeal = 500;
    int compDeal = 500;
    int inGame = 0;
    int turn = 1;
    int cont = 0;
    System.out.println("Welcome to black jack, would you like to play?");
    System.out.println("---------------------------");
    System.out.println("Yes:0");
    System.out.println("No:1");
    System.out.println("---------------------------");
    inGame = choose.nextInt();

    if (inGame == 0) {
      Card playerOne = newDeck.draw();
      playerCards.add(playerOne);
      Card playerTwo = newDeck.draw();
      playerCards.add(playerTwo);
      Card dealerOne = newDeck.draw();
      compCards.add(dealerOne);
      Card dealerTwo = newDeck.draw();
      compCards.add(dealerTwo);
      System.out.println("Here are your cards: " + playerOne.getNumber() + " of " + playerOne.getSuits() + 
      " and " + playerTwo.getNumber() + " of " + playerTwo.getSuits()+". The total of your cards is : " + addUp(playerCards));
      System.out.println("The Dealer's face up card is " + dealerOne.getNumber() + " of " + dealerOne.getSuits() + ".");
      System.out.println("");

      while(cont == 0 || cont == 1) {
        System.out.println("Would you like to draw another card, do nothing, or leave?");
        System.out.println("---------------------------");
        System.out.println("Draw:0");
        System.out.println("Do nothing:1");
        System.out.println("exit: 2");
        System.out.println("---------------------------");
        cont = choose.nextInt();

        if (cont == 0) {
          Card newCard = newDeck.draw();
          playerCards.add(newCard);
          System.out.println("The card drawn was the " +newCard.getNumber()+ " of " + newCard.getSuits());
          if (addUp(playerCards) > 21) {
            System.out.println("You lost.");
            cont = 3;
          }
          System.out.println("The total of your cards is now: " +
          addUp(playerCards));
        }

        if (cont == 1){
          while (addUp(compCards) <= 16) {
            Card newCompCard = newDeck.draw();
            compCards.add(newCompCard);
            System.out.println("The computer drew a " +  newCompCard.getNumber() + " of " + newCompCard.getSuits()+ ". The computer's total is now: " + addUp(compCards));
            if (addUp(compCards) > 21 ) {
              System.out.println("You won.");
              cont = 3;
            }
          } if (addUp(compCards) > 16 && addUp(compCards) <= 21) {
              if (addUp(playerCards) > addUp(compCards)) {
                System.out.println("");
                System.out.println("You win.");
                cont = 3;
              } else {
                System.out.println("The computer wins.");
                cont = 3;
              }
            }
        }
      }
    System.out.println("");
    System.out.println("Goodbye.");
    }
  }


  public static int addUp(ArrayList<Card> cards) {
    int total = 0;
    int aces = 0;
    for (int i = 0; i < cards.size(); i++) {
      if (cards.get(i).getNumber() >= 10) {
        total = total + 10;
      } else if (cards.get(i).getNumber() == 1 ) {
        aces = aces + 1;
        total = total + 11;
      } else if (cards.get(i).getNumber() < 10 && cards.get(i).getNumber() != 1) {
        total = total + cards.get(i).getNumber();
      }
    }
    if (total > 21 && aces > 0) {
      while (0 < aces) {
        total = total - 10;
        aces = aces - 1;
        if (total <= 21) {
          aces = 0;
        }
      }
    }
    return total;
  }

  // public static void winCondition(ArrayList<Card> cards) {
  //   if (addUp(playerCards) ) {
  //     System.out.println("You won.");
  //   } else if (total == 21) {
  //     System.out.println("The computer won.");
  //   }
  // }

  // public static void switchTurn(int turn) {
  //   if (turn == 1) {
  //     turn = 2;
  //     System.out.println("It's now the computer's turn.");
  //   }
  //   else {
  //     turn = 1;
  //     System.out.println("It's now your turn.");
  //   }
  // }

}