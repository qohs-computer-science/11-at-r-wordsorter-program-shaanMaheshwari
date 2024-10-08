import java.io.File;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

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


		in = new Scanner(System.in);


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
			in.nextLine();


			if(decision == 1){
				printAllSpecific(wordsList);
			} else if (decision == 2){
				printAllWords(wordsList);
			} else if(decision == 3){
				printSize(wordsList);
			} else if (decision == 4){
				searchForWord(wordsList);
			} else if(decision == 5){
				searchAndRemoveWord(wordsList);
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

		
		if(array[currLoc].size()>0){
			for(int i = 0; i < array[currLoc].size(); i++){
				System.out.println(array[currLoc].get(i));
			}
		} else {
			System.out.println("No words start with this letter");
		}
	}


	public static void printAllWords(ArrayList<String>[]array){
		int counter = 0;

		for(int i = 0; i < array.length; i++){
			for(int x = 0; x < array[i].size(); x++){
				System.out.println(array[i].get(x));
				counter++;
			}
		}
		if(counter == 0){
			System.out.println("Empty List");
		}
	}


	public static void printSize(ArrayList<String>[]array){
		int total = 0;

		for(int i = 0; i < array.length; i++){
			total += array[i].size();
		}
		System.out.println(total);

		if(total > 0){
			System.out.println("There are " + total + " unique words in the article");
		} else{
			System.out.println("Empty List");
		}
	}


	public static void searchForWord(ArrayList<String>[]array){
		Scanner in = new Scanner(System.in);


		System.out.print("What word do you want to search for? Your words must be all lowercase with no symbols or spaces. ");
		String userWord = in.nextLine();


		int currLoc = userWord.charAt(0) - 97;
		boolean found = false;


		for(int i = 0; i < array[currLoc].size(); i++){
			if(userWord.equals(array[currLoc].get(i)))
				found = true;
		}


		if(found == true)
			System.out.println("Word found in the article");
		else 
			System.out.println("Word NOT found in the article.");
	}


	public static void searchAndRemoveWord(ArrayList<String>[]array){
		Scanner in = new Scanner(System.in);

		System.out.print("What word do you want to remove? Your words must be all lowercase with no symbols or spaces. ");
		String userWord = in.nextLine();

		int currLoc = userWord.charAt(0) - 97;
		boolean found = false;

		for(int i = 0; i < array[currLoc].size(); i++){
			if(userWord.equals(array[currLoc].get(i))){
				array[currLoc].remove(i);
				found = true;
			}
				
		}
		if(found == true)
			System.out.println("Word successfully removed from the list");
		else 
			System.out.println("Word NOT found in the article");
		
	}
}