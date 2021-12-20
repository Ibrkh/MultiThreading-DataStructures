package MultiThreading;

import java.util.ArrayList;
import java.util.Scanner;


@SuppressWarnings("unused")
public class DrivingInterface 
{		
	// Creating BinarySearchTree Object to store vocabulary file data
	private static BinarySearchTree MainBST = new BinarySearchTree();
	
	// Creating ArrayList Object to store English text file data 
	private static ArrayList<String> MainWordList = new ArrayList<String>();
	
	// Creating ArrayList Object to store Matching Vocabulary Objects
	private static ArrayList<Vocabulary> MainMatchingWordList = new ArrayList<Vocabulary>();	

	// This Function Searches for Query-Word in MainMatchingWordList
	public static void QuerySearching(String word) throws VocabularyFrequencyNegativeException
	{ 	
		boolean searchFlag = false;
		
		for(int i=0; i<MainMatchingWordList.size(); i++)
		{
			
			if(searchFlag == true)
				return;
			
			if(MainMatchingWordList.get(i).getWord().equals(word))
			{
				System.out.println("Query-word match found !\n");
				MainMatchingWordList.get(i).printVocabularyDetails();
				searchFlag = true;
			}
		}
		
		if(searchFlag == false)
			System.out.println("Query-word match not found !\n");
	}

	// This Function matches each word in ArrayList to BinarySearchTree
	public static void MatchingFunction() throws BinarySearchTreeNodeNullException, VocabularyFrequencyNegativeException
	{ 	
		for(int i=0;i<MainWordList.size(); i++)
		{	
			String searchWord = MainWordList.get(i);	
			boolean searchFlag = MainBST.searchString(searchWord);
			
			if(searchFlag == true)
			{
				Vocabulary object = new Vocabulary(searchWord);
				
				int searchFrequency = MainBST.searchStringFrequency(object);
			
				object.setFrequency(searchFrequency);
				
				MainMatchingWordList.add(object);	
				
				//System.out.println("hello");
				searchFlag = false;
				
			}
		}		
	}

	// This Function Reads Files from Command Line..
	public static void ThreadedFileHandling(String[] args)
	{
		for(int i=0;i<args.length; i++)
		{ 
			System.out.println("Files recieved: " + args[i]);
						
			switch(args[i])
			{
				case "vocabulary":
				{	
					VocabularyThread thread = new VocabularyThread(args[i]); 
					thread.start();
					synchronized (thread) {
						try {
							MainBST = thread.getBST();
							thread.wait();
						} catch (InterruptedException e) {
							 //TODO Auto-generated catch block
							e.printStackTrace();
						}
					}				
					
					break; 
				}
				case "textfile1", "textfile2":
				{
					TextThread thread = new TextThread(args[i]); 
					thread.start();
					synchronized (thread) {
						try {
							MainWordList = thread.getWordList();						
							thread.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}				

					break;
				}
			}						
		}	
	}

	// This Function is responsible for taking all the inputs
	public static void interfaceOptionSelection(int interfaceOption) throws BinarySearchTreeNodeNullException, VocabularyFrequencyNegativeException
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		if(interfaceOption == 1)
		{
			System.out.println("Displaying BST build from Vocabulary File");
			System.out.println("Key : Value");
			
			//Printing BST data
			MainBST.inorder();
			
		}
		else if(interfaceOption == 2)
		{
			System.out.println("Displaying ArrayList build from InputText files");
			
			//Printing ArrayList data
			for(int i=0;i<MainWordList.size(); i++)
				System.out.println(MainWordList.get(i));			
		}
		else if(interfaceOption == 3)
		{
			System.out.println("Displaying the matching words and corresponding frequencies\n");

			for(int i=0;i<MainMatchingWordList.size(); i++)
				MainMatchingWordList.get(i).printVocabularyDetails();		
		}
		else if(interfaceOption == 4)
		{
			System.out.println("Searching Query Interface\n");
			
			System.out.println("Enter your Query-word: ");
			String tempWord = input.nextLine();
			
			QuerySearching(tempWord);			
		}
		else if(interfaceOption == 5)
			System.out.println("Exiting Multi-Threaded File Handling Inteface.. Good Bye :)");
	}
	
	// This Function Displays all the Interface Options
	public static void UserInterface() throws BinarySearchTreeNodeNullException, VocabularyFrequencyNegativeException
	{
		System.out.println("\t\tUser Interface\n");
		
		boolean optionFlag = true;
		
		while(optionFlag)
		{
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("Select the following options..");
			System.out.println("1. Display BST build from Vocabulary File");
			System.out.println("2. Displaying ArrayList build from Input files");
			System.out.println("3. Viewing Match words and its frequency");
			System.out.println("4. Searching a query");
			System.out.println("5. Exit");
			
			int Option = input.nextInt();
			
			interfaceOptionSelection(Option);
			
			if(Option == 5)
				optionFlag = false;
		}	
	}
	
    ///////////////////////////////// DrivingInterface - MAIN /////////////////////////////////////

	public static void main(String[] args) throws BinarySearchTreeNodeNullException, VocabularyFrequencyNegativeException
	{   			
		System.out.println("Welcome to Multi-Threaded File Handling Inteface\n");	
		
		System.out.println("Reading Files from Command Line...");

		ThreadedFileHandling(args);
		MatchingFunction();
		UserInterface();
				
		return;
	}
}
