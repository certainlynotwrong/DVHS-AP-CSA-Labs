package lab_21;

public class Main {
	 
	public static void main(String[] args) {
	
	
	
	Dictionary dictionaire = new Dictionary();
	String[] w = {"Le taureau", "La vache", "La tortue", "Le canard", "Le cochon", "La chèvre", "Le poulet", "Une poule", "Le lapin", "Le mouton", "La brebis"};
	String[] d = {"The bull", "The cow", "The turtle", "The duck", "The pig", "The goat", "The chicken", "A hen", "The rabbit", "The sheep", "The ewe"};
	
	fillDictionary(dictionaire, w, d);
	dictionaire.randomFlashCard();
	
	 }
	public static void fillDictionary(Dictionary d, String[] words, String[] defs) {
			for(int i = 0; i < words.length; i++) {
				d.add(words[i], defs[i]);
			}
		}
	
}

	
	





