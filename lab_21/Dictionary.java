package lab_21;

import java.util.Random;
import java.util.Scanner;

public class Dictionary {
	ArrayList words = new ArrayList();
	ArrayList defs = new ArrayList();
	
	
	public static void main(String[] args) {

	}
	
	public void add(String word, String def) {
		words.add(word);
		defs.add(def);
	}
	
	public int size() {
		return words.size();
	}
		
	public void randomFlashCard() {
		int correct = (int) (Math.random() * (words.size()));
		System.out.println(words.get(correct));
		String[] sent = new String[4];
		sent[0] = (String) defs.get(correct);
		sent[1] = (String) defs.get((int) (Math.random() * (defs.size())));
		sent[2] = (String) defs.get((int) (Math.random() * (defs.size())));
		sent[3] = (String) defs.get((int) (Math.random() * (defs.size())));
		
		Random rand = new Random();
		for(int i = 0; i < sent.length; i++) {
			int rI = rand.nextInt(sent.length);
			String t = sent[rI];
			sent[rI] = sent[i];
			sent[i] = t;
		}
		
		//index of correct
		int cor = 0;
		for(int i = 0; i < sent.length; i++) {
			if(sent[i].equals((String) defs.get(correct))) {
				cor = i;
				break;
			}
		}
		System.out.println("Enter 1-4 for your response corresponding with A-D:");
		System.out.println("A. " + sent[0]);
		System.out.println("B. " + sent[1]);
		System.out.println("C. " + sent[2]);
		System.out.println("D. " + sent[3]);
		
		Scanner uRes = new Scanner(System.in);
		int uC = uRes.nextInt();
		uRes.close(); 
		if(uC - 1 == cor) {
			System.out.println("Congrats, you guessed correctly! \n");
		} else {
			System.out.print("Sorry, your guess was incorrect. \n");
		}
		System.out.println("The correct answer was: " + sent[cor]);
	}
	

}
