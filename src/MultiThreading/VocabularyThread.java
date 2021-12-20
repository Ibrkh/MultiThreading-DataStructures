package MultiThreading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VocabularyThread extends Thread
{	
	// Binary Search Tree Object Declaration
	private BinarySearchTree BST;
	private int BSTnodeKey = 0;
	
	// Binary Search Tree Getter
	public BinarySearchTree getBST() {
		return BST;
	}
		
	// Parameterized Constructor
	public VocabularyThread(String threadName)
	{	
		setName(threadName);
		System.out.println("Thread " + getName() + " created\n");
		
		BST = new BinarySearchTree(threadName);		
	}

	@Override
	public void run()
	{
		String filepath = "D:\\Eclipse Workspace\\AP-MultiThreading\\src\\MultiThreading\\" + getName();
		File file = new File(filepath);
		Scanner fileReader;
		try {
			fileReader = new Scanner(file);
			 while (fileReader.hasNextLine()) {
			        String data = fileReader.nextLine();
			        
			        BST.insert(BSTnodeKey, data);
			        BSTnodeKey++;
			      }
			 
			 //BST.inorder();
		} catch (FileNotFoundException | BinarySearchTreeNodeNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
