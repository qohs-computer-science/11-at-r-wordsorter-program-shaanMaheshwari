import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class WordSorter 
{
	//boolean keepRunning = true;
	//while(keepRunning == true){

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
				System.out.println(word);
				word = word.toLowerCase();

				int currLoc = word.charAt(0) - 97;
				wordsList[currLoc].add(word);
			}
		}
	}
//}