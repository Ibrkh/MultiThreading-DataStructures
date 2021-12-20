package MultiThreading;

public class BinarySearchTree
{	
    //node class that defines BST node
    public class Node
    { 
        private int Key;
        private String Word;
        private Node left, right; 
   
        // Parameterized Constructor
        @SuppressWarnings("unused")
		public Node(int key, String word)
        { 
            Key = key; 
            Word = word;
            left = right = null; 
        }         
    } 
  
    
    // BST root node 
    private Node root;

    public Node BSTRoot() throws BinarySearchTreeNodeNullException {
    	
        if (root == null)
        {
    		//BST Node is Null; CustomException
    		throw new BinarySearchTreeNodeNullException("BST Node is Null #NullExceptionThrown");
        }

    	return root;
    }
        
	//Binary Search Tree Name
    private String BSTName;

    public String getBSTName() {
		return BSTName;
	}

	public void setBSTName(String bSTName) {
		BSTName = bSTName;
	}

	// Default Constructor - initial empty tree
    public BinarySearchTree()
    { 
        root = null; 
        BSTName = null;
    } 

    // Parameterized Constructor - initialize BST Name
    public BinarySearchTree(String BSTname)
    { 
        root = null; 
        BSTName = BSTname;
    } 

    ///////////////////////////////// BST MINIMUM VALUE ///////////////////////////////////
    
    public int minValue(Node root) throws BinarySearchTreeNodeNullException 
    { 

        if (root == null)
        {
    		//BST Node is Null; CustomException
    		throw new BinarySearchTreeNodeNullException("BST Node is Null #NullExceptionThrown");
        }

    	//initially minval = root
        int minval = root.Key; 
      
        //find minval
        while (root.left != null) 
        { 
      	
            minval = root.left.Key; 
            root = root.left; 
        }
        
        return minval; 
    } 

    ///////////////////////////////// BST MINIMUM VALUE ///////////////////////////////////

    ///////////////////////////////// NODE INSERTION ///////////////////////////////////
    
    // insert a node in BST 
    public void insert(int key, String word) throws BinarySearchTreeNodeNullException  
    { 
        root = insert_Recursive(root, key, word); 

        if (root == null)
        {
    		//BST Node is Null; CustomException
    		throw new BinarySearchTreeNodeNullException("BST Node is Null #NullExceptionThrown");
        }

    } 
   
    //recursive insert function
    public Node insert_Recursive(Node root, int key, String word)
    { 
          //tree is empty
        if (root == null) 
        { 
            root = new Node(key, word); 
            return root; 
        } 
        
        //traverse the tree 
        if (key < root.Key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key, word); 
        else if (key > root.Key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key, word); 
        
        // return pointer
        return root; 
    } 

    ///////////////////////////////// NODE INSERTION ///////////////////////////////////
    
    ///////////////////////////////// INORDER TRAVERSAL ///////////////////////////////////
    
    // method for inorder traversal of BST 
    public void inorder() throws BinarySearchTreeNodeNullException
    { 
        inorder_Recursive(root); 
        
        if (root == null)
        {
    		//BST Node is Null; CustomException
    		throw new BinarySearchTreeNodeNullException("BST Node is Null #NullExceptionThrown");
        }

    } 
   
    // recursively traverse the BST  
    public void inorder_Recursive(Node root) 
    { 
        if (root != null) 
        { 
            inorder_Recursive(root.left); 
            System.out.print(root.Key + " " + root.Word + "\n"); 
            inorder_Recursive(root.right); 
        } 
    } 

    ///////////////////////////////// INORDER TRAVERSAL ///////////////////////////////////
    
    ///////////////////////////////// NODE SEARCHING - String ///////////////////////////////////
    
    public boolean searchString(String word) throws BinarySearchTreeNodeNullException  
    {     	
    	Node tempNode = searchString_Recursive(root, word);

    	boolean searchFlag = false;

    	if(tempNode != null)
    	{
    		if(tempNode.Word.equals(word) == true)
    		{	    			
    			searchFlag = true;
    			tempNode = this.root;
    		}
    	}
    	else if(tempNode == null)
    	{
    		searchFlag = false;
    		
    		//BST Node is Null; CustomException
    		throw new BinarySearchTreeNodeNullException("BST Node is Null #NullExceptionThrown");
    	}    	
    	return searchFlag;
    } 
   
    //recursive search function
    public Node searchString_Recursive(Node root, String word)
    {    	    	
        // Base Cases: root is null or key is present at root 
        if (root==null)
        {	
        	root = this.root;
            return root;
        }
        else if(root.Word.equals(word) == true)
        	return root;
        
        // The key value of the root will always be less than it's child roots
        // key value is less than root's key 
        return searchString_Recursive(root.right, word); 
        
    } 
   
    ///////////////////////////////// NODE SEARCHING - String ///////////////////////////////////
    
    ///////////////////////////////// NODE SEARCHING - String Frequency ///////////////////////////////////
    
    public int searchStringFrequency(Vocabulary Object) throws VocabularyFrequencyNegativeException  
    { 
    	@SuppressWarnings("unused")
		Node tempNode = searchStringFrequency_Recursive(root, Object);
    	tempNode = this.root;
    	int searchFrequency = Object.getFrequency();
    	    	
		return searchFrequency; 
    } 
   
    //recursive search function
    public Node searchStringFrequency_Recursive(Node root, Vocabulary Object) throws VocabularyFrequencyNegativeException 
    { 
        // Base Cases: root is null or key is present at root 
        if (root==null) 
            return root;
        
        if(root.Word.equals(Object.getWord()) == true)
        	Object.increaseFrequency();        
        
        // The key value of the root will always be less than it's child roots
        // key value is less than root's key 
        return searchStringFrequency_Recursive(root.right, Object); 
    } 
   
    ///////////////////////////////// NODE SEARCHING - String Frequency ///////////////////////////////////
    
    ///////////////////////////////// NODE SEARCHING  ///////////////////////////////////
    
    public boolean search(int key, String word) throws BinarySearchTreeNodeNullException  
    { 
        root = search_Recursive(root, key, word); 
        
        if (root == null)
        {
    		//BST Node is Null; CustomException
    		throw new BinarySearchTreeNodeNullException("BST Node is Null #NullExceptionThrown");
        }   
    
        if (root!= null)
            return true;
        else
            return false;
        
    }
   
    //recursive insert function
    public Node search_Recursive(Node root, int key, String word) 
    { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.Key==key) 
            return root; 
        
        // val is greater than root's key 
        if (root.Key > key) 
            return search_Recursive(root.left, key, word); 
        
        // val is less than root's key 
        return search_Recursive(root.right, key, word); 
    } 
    
    ///////////////////////////////// NODE SEARCHING ///////////////////////////////////

    
    ///////////////////////////////// NODE DELETION ///////////////////////////////////

    //delete a node from BST
    public void deleteKey(int key, String word) throws BinarySearchTreeNodeNullException 
    { 
        root = delete_Recursive(root, key, word);
        
        if (root == null)
        {
    		//BST Node is Null; CustomException
    		throw new BinarySearchTreeNodeNullException("BST Node is Null #NullExceptionThrown");
        }
        
    } 
   
    //recursive delete function
    public Node delete_Recursive(Node root, int key, String word) throws BinarySearchTreeNodeNullException
    { 
        //tree is empty
        if (root == null)  return root; 
   
        //traverse the tree
        if (key < root.Key)     //traverse left subtree 
            root.left = delete_Recursive(root.left, key, word); 
        else if (key > root.Key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key, word); 
        else  { 
            // node contains only one child
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
   
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            root.Key = minValue(root.right); 
   
            // Delete the inorder successor 
            root.right = delete_Recursive(root.right, root.Key, root.Word); 
        } 
        
        return root; 
    } 

    ///////////////////////////////// NODE DELETION ///////////////////////////////////
}



//Testing Binary Search Tree Driving Inteface - Main
//public static void main(String[] args) 
//{
//	//create a BST object
//    BinarySearchTree BST = new BinarySearchTree(); 
//    
//    /* BST tree example
//          45 
//       /     \ 
//      10      90 
//     /  \    /   
//    7   12  50   */
//    
//    //insert data into BST
//    BST.insert(45); 
//    BST.insert(10); 
//    BST.insert(7); 
//    BST.insert(12); 
//    BST.insert(90); 
//    BST.insert(50); 
//    
//    //print the BST
//    System.out.println("The BST Created with IN-Order Traversal: ");
//    BST.inorder(); 
//    
//    //delete leaf node  
//    System.out.println("\nThe BST after Delete 12(leaf node):"); 
//    BST.deleteKey(12); 
//    BST.inorder(); 
//    
//    //delete the node with one child
//    System.out.println("\nThe BST after Delete 90 (node with 1 child):"); 
//    BST.deleteKey(90); 
//    BST.inorder(); 
//             
//    //delete node with two children  
//    System.out.println("\nThe BST after Delete 45 (Node with two children):"); 
//    BST.deleteKey(45); 
//    BST.inorder(); 
//    
//    //search a key in the BST
//    boolean ret_val = BST.search (50);
//    System.out.println("\nKey 50 found in BST:" + ret_val );
//    ret_val = BST.search (12);
//    System.out.println("\nKey 12 found in BST:" + ret_val );
// }