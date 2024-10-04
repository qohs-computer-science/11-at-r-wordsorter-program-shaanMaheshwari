import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class WordSorter 
{		
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in); 

		ArrayList<String>[] wordsList = new ArrayList[26];

		for(int i = 0; i < wordsList.length; i++){
			wordsList[i] = new ArrayList<String>();
		}

		try
		{
			in = new Scanner(new File("article.txt"));	
		}
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}	
		String word = "";
		while(in.hasNext())			
		{
			word = in.next();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			word = word.toLowerCase();
			System.out.println(word);
				
			int currLoc = word.charAt(0) - 97;
			boolean found = false;
			for(int x = 0; x < wordsList[currLoc].size(); x++){
				if(word.equals(wordsList[currLoc].get(x))){
					found = true;
				}

			}
			if(found == false)
				wordsList[currLoc].add(word);
		}

		boolean start = true;
		while(start == true){
			System.out.println("Here are your menu options:");
			System.out.println("1. Print out all words starting with a specific letter.");
			System.out.println("2. Print out all words .");
			System.out.println("3. Print out the total number of words.");
			System.out.println("4. Search for a specific word.");
			System.out.println("5. Search for and remove a specific word.");
			System.out.println("6. End the program.");

			System.out.print("What would you like to do? ");
			int decision = in.nextInt();

			if(decision == 1){
				printAllSpecific();
			} else if (decision == 2){
				printAllWords();
			} else if(decision == 3){
				printSize();
			} else if (decision == 4){
				searchForWord();
			} else if(decision == 5){
				searchAndRemoveWord();
			} else{
				start = false;
			}
		}
	}





	public static void printAllSpecific(ArrayList<String>[]array){
		
		
		Scanner in = new Scanner(System.in);

		System.out.print("What letter list do you want? ");
		String first = in.nextLine();
		int currLoc = first.charAt(0) - 97;
		for(int i = 0; i < array.length; i++){
			System.out.println(array[currLoc].get(i));
		}
		System.out.println(array[currLoc]);

	}
}