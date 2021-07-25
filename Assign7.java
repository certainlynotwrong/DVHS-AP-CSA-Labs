package mrsdstuff;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Assign7 {

	public static void main(String[] args) {
		System.out.println(face(26));
		System.out.println(suit(40));
		System.out.println(cardToString(16));
		int[] arr = {1, 16, 40};
		System.out.println(cardsToString(arr));
		int[] ned = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
				20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
				38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
		shuffle(ned);
		System.out.println(Arrays.toString(createShuffledDeck()));
		task8();
		int[] tst = {12, 25, 38, 51, 6};
		System.out.println((bestPokerHand(tst)));
		System.out.println((pokerHand(tst)));
		play();
		}

	public static int face(int card) { // start face
		int choice  = card % 13; // set choice to be the mod of the card by 13
		if(choice != 0) { // if card is not a multiple of 13
			return choice; // return the choice
		}
		else // if card is a multiple of 13
			return 13; // return 13
		} // end face
	
	public static int suit(int card) { // start suit
		int ret = card - (card % 13); // initialize ret and set it equal to the card minus it modded by 13
		if(card % 13 == 0) { // if the card is a multiple of 13
			return ret / 13; // return ret divided by 13
		} else { // if the card is not a multiple of 13
			return (ret / 13) + 1; // return ret divided by 13 added to one
		}
	} // end suit
	
	public static String cardToString(int card) { // start cardToString
		int f = face(card); // initialize f
		int s = suit(card); // initialize s
		String a = ""; // initialize return string
		if(s == 1) { // if suit is 1
			a += "S"; // append S
		} else if(s == 2) { // if suit is 2
			a += "H"; // append H
		} else if(s == 3) { // if suit is 3
			a += "C"; // append C
		} else if(s == 4) { // if suit is 4
			a += "D"; // append D
		}
		if(f == 1) { // if face is 1
			a += "A"; // append A
		} else if(f == 2) { // if face is 2
			a += "2"; // append 2
		} else if(f == 3) { // if face is 3
			a += "3"; // append 3
		} else if(f == 4) { // if face is 4
			a += "4"; // append 4
		} else if(f == 5) { // if face is 5
			a += "5"; // append 5
		} else if(f == 6) { // if face is 6
			a += "6"; // append 6
		} else if(f == 7) { // if face is 7
			a += "7"; // append 7
		} else if(f == 8) { // if face is 8
			a += "8"; // append 8
		} else if(f == 9) { // if face is 9
			a += "9"; // append 9
		} else if(f == 10) { // if face is 10
			a += "X"; // append X
		} else if(f == 11) { // if face is 11
			a += "J"; // append J
		} else if(f == 12) { // if face is 12
			a += "Q"; // append Q
		} else if(f == 13) { // if face is 13
			a += "K"; // append K
		}
		return a; // return the string
	} // end cardToString
	
	public static String cardsToString(int[] cards) { // start cardsToString
		if(cards == null) { // null check
			return "[]"; // if null return []
		} else { // if not null
			String ret = "["; // initialize return string
			for(int i = 0; i < cards.length; i ++) { // run through the length of the cards array 
				ret += cardToString(cards[i]); // append result of cardToString into the string
				if(i < cards.length - 1) { // add a comma between each
					ret += ", ";
				}
			}
			ret += "]"; // end the string with closing bracket
		return ret; // return the string 
		}
	} // end cardsToString
	
	public static void shuffle(int[] deck) { // start shuffle
		int rand = 0; // initialize random integer
		for(int i = 0; i < deck.length; i++) { // run through the length of the deck array
			rand = (int)(Math.random() * deck.length); // sets random integers
			int t = deck[i]; // initialize temporary storage
			deck[i] = deck[rand]; // set the new positions from the random
			deck[rand] = t; //set the random positions from the original position
		}
	} // end shuffle
	
	public static int[] createShuffledDeck() { // start createShuffledDeck
		int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
				20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
				38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52}; 
		int rand = 0; // initialize random integer
		for(int i = 0; i < cards.length; i++) { // run through the length of the deck array
			rand = (int)(Math.random() * cards.length); // sets random integers
			int t = cards[i]; // initialize temporary storage
			cards[i] = cards[rand]; // set the new positions from the random
			cards[rand] = t; // set the random positions from the original position
		}
		return cards; // return the scrambled array
	} // end createShuffledDeck
	
	public static int nextCard(int[] deck){ // start nextCard
	    int rv = 0; // initialize return integer
	    int i = 0;
	    while (deck[i]==0){ // if there are still cards remaining
	      i++; // increment
	    }
	    if (i<deck.length){ // if there are cards remaining
	      rv = deck[i]; // increase return integer
	      deck[i]=0; // set the used cards' positions to 0
	    }
	    return rv; // return result
	  } // end nextCard
	
	public static void task8() { // start task8
		int[] ret = createShuffledDeck(); // create a shuffled deck
		System.out.println(cardsToString((ret))); // print the shuffled deck
		for(int i = 0; i < 5; i++) { // run through the first 5 elements in the array
			System.out.println(cardToString(ret[i])); // prints out the elements
		}
	} // end task8
	
	public static int bestPokerHand(int[] hand) { // start bestPokerHand
		int[] sort = new int[5]; // initialize new array that contains all the face values of the hand
		sort[0] = face(hand[0]);
		sort[1] = face(hand[1]);
		sort[2] = face(hand[2]);
		sort[3] = face(hand[3]);
		sort[4] = face(hand[4]);
		int[] sort2 = new int[5]; // initialize new array that contains all the suit values of the hand
		sort2[0] = suit(hand[0]);
		sort2[1] = suit(hand[1]);
		sort2[2] = suit(hand[2]);
		sort2[3] = suit(hand[3]);
		sort2[4] = suit(hand[4]);
		int temp = 0; // initialize temporary integer
		for(int i = 0; i < 4; i++) { // run through the length of the array
			if(sort[i] > sort[i+1] && sort[1] != 1) { // checks if there is an ace
				temp = hand[i];
				hand[i] = hand[i+1];
				hand[i+1] = temp; // sorts the hand by face
			} else if(sort[i+1] == 1) {
				temp = hand[i+1];
				hand[i+1] = hand[i];
				hand[i] = temp; // sorts the hand by face
			}
		}
		if(sort[0] == 1 && sort[1] == 13 && sort[2] == 12 && sort[3] == 11 && sort[4] == 10
				&& sort2[0] == sort2[1] && sort2[0] == sort2[2] && sort2[0] == sort2[3]
				&& sort2[0] == sort2[4]) { // if faces are royal cards and if suits are the same
			return 1; // return Royal Flush
		} else if(sort2[0] == sort2[1] && sort2[0] == sort2[2] && sort2[0] == sort2[3]
				&& sort2[0] == sort2[4] && sort[0] == sort[0] + 1 && sort[1] == sort[2] + 1
				&& sort[2] == sort[3] + 1 && sort[3] == sort[4]+ 1) { // if suits are same and faces are consecutive
			return 2; // return Straight Flush
		} else if(sort[0] == sort[1] && sort[0] == sort[2] && sort[0] == sort[3]
				|| sort[4] == sort[1] && sort[4] == sort[2] && sort[4] == sort[3]) { // if 4 cards have the same face
			return 3; // return Four of a Kind
		} else if(sort[0] == sort[1] && sort[0] == sort[2] && sort[3] == sort[4]
				|| sort[0] == sort[1] && sort[4] == sort[2] && sort[4] == sort[3]) { // if three cards are the same and the remaining two are the same
			return 4; // return Full House
		} else if(sort2[0] == sort2[1] && sort2[0] == sort2[2] && sort2[0] == sort2[3]
				&& sort2[0] == sort2[4]) { // if all cards have the same suit
			return 5; // return Flush
		} else if(sort[0] == sort[1] + 1 && sort[1] == sort[2] + 1 && sort[2] == sort[3] + 1
				&& sort[3] == sort[4] + 1) { // if cards are consecutive
			return 6; // return Straight
		} else if(sort[0] == sort[1] && sort[2] == sort[2] || sort[1] == sort[2]
				&& sort[1] == sort[3] || sort[2] == sort[3] || sort[2] == sort[4]) { // if 3 cards are same
			return 7; // return Three of a Kind
		} else if(sort[0] == sort[1] && sort[2] == sort[3] || sort[0] == sort[1]
				&& sort[3] == sort[4] || sort[1] == sort[2] && sort[3] == sort[4]) { // if there are 2 pairs
			return 8; // return Two Pair
		} else if(sort[0] == sort[1] || sort[1] == sort[2] || sort[2] == sort[3]
				|| sort[3] == sort[4]) { // return the single pair
			return 9; // return One Pair
		} else { // highest possible card
			return 10; // return High Card
		}
	}
	public static String pokerHand(int[] hand) { // start pokerHand
		int choice = bestPokerHand(hand); // call bestPokerHand
		if(choice == 1) { // if bestPokerHand was 1
			return "Royal Flush";
		} else if(choice == 2) { // if bestPokerHand was 2
			return "Straight Flush";
		} else if(choice == 3) { // if bestPokerHand was 3
			return "Four of a Kind";
		} else if(choice == 4) { // if bestPokerHand was 4
			return "Full House";
		} else if(choice == 5) { // if bestPokerHand was 5
			return "Flush";
		} else if(choice == 6) { // if bestPokerHand was 6
			return "Straight";
		} else if(choice == 7) { // if bestPokerHand was 7
			return "Three of a Kind";
		} else if(choice == 8) { // if bestPokerHand was 8
			return "Two Pair";
		} else if(choice == 9) { // if bestPokerHand was 9
			return "One Pair";
		} else { // if bestPokerHand was 10
			return "High Card";
		}
	} // end pokerHand

	public static void play() { // start play
		int[] ret = createShuffledDeck(); // create a shuffled deck
		int[] handA = new int[5]; // create handA deck
		int[] handB = new int[5]; // create handB deck
		for(int i = 0; i < 5; i++) { // run through the length of the hand decks
			handA[i] = nextCard(ret); // deal the cards into handA
			handB[i] = nextCard(ret); // deal the cards into handB
		}
		System.out.println("Player 1's Turn: " + cardsToString(handA));
		Scanner pinput = new Scanner(System.in); // initialize a user input
		boolean[] rep = new boolean[5]; // initialize a boolean array
		while(true) { // while the array is true
			System.out.println("Replace which card? If no card, type 0."); // ask Player 1 which card they wish to replace
			int numb = pinput.nextInt(); // initialize integer that stores response
			if(numb == 0) { // if Player 1 enters 0
				break; // end the loop and move to the next player
			}
			rep[numb - 1] = true; // set the element in the array to be true
		}
		for(int i = 0; i < rep.length; i++) { // run through the length of the boolean array
			if(rep[i]) {
				handA[i] = nextCard(ret); // replace the card requested by Player 1
			}
		}
		System.out.println("Your new hand: " + cardsToString(handA)); // print out the new hand
		System.out.println("Player 2's Turn: " + cardsToString(handB)); // print out Player 2's hand
		rep = new boolean[5]; // initialize boolean array
		while(true) { // while the array is true
			System.out.println("Replace which card? If no card, type 0"); // ask player 2 which card to replace
			int numb = pinput.nextInt(); // initialize integer that stores response
			if(numb == 0) { // if Player 2 enters 0 
				break; // end the loop and move to the next player
			}
			rep[numb - 1] = true; // set the element in the array to be true
		}
		for(int i = 0; i < rep.length; i++) { // run through the length of the array
			if(rep[i]) { 
				handB[i] = nextCard(ret); // replace the card requested by Player 2
			}
		}
		System.out.println("Your new hand: " + cardsToString(handB)); // print out the new hand
		if(bestPokerHand(handA) < bestPokerHand(handB)) { // determine the winner, that has the lower score
            System.out.println("Player 2 Wins!");
        } else if(bestPokerHand(handB) < bestPokerHand(handA)) {
            System.out.println("Player 1 Wins!");
        } else { // if they have the same value its a tie
            System.out.println("Both Players tied. It's a Draw!");
        }
	} // end play
}
