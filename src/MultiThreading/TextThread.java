package MultiThreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TextThread extends Thread
{
	//LinkedList Object Decalaration
	//private ArrayList<String> WordList = new ArrayList<String>();
	
	private ArrayList<String> WordList = new ArrayList<String>();
	
	public ArrayList<String> getWordList() {
		return WordList;
	}
	
	// Parameterized Constructor
	public TextThread(String threadName)
	{	
		setName(threadName);
		System.out.println("Thread " + getName() + " created\n");
	}
		
	@Override
	public void run()
	{	
		String filepath = "D:\\Eclipse Workspace\\AP-MultiThreading\\src\\MultiThreading\\" + getName();
		FileReader file = null;
		try {
			file = new FileReader(filepath);
			@SuppressWarnings("resource") BufferedReader buffer = new BufferedReader(file);
			
			String tempLine = "";
			
			while((tempLine = buffer.readLine()) != null) {
				String[] tempArray = tempLine.split("\\s+");
				
				for(int i=0;i<tempArray.length; i++)
					WordList.add(tempArray[i]);
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//for(int i=0;i<WordList.size(); i++)
			//System.out.println(WordList.get(i));
		
	}
}
