/**A class which represents an implementation of a Binary Search Tree
  * 
  * Please fill out the following imarking information below:
  * 
  * Family name : Morris
  * given names : Christopher
  * course : Itec 2620
  * Section: M
  * Student ID: 209142027
  * 
  **/

public class BST implements Tree{
  //===============
  //Vars
  //===============
  
  //Tree Root
  private BSTNode root;
  private int numberOfChildren = 0; //used for traversal in boolean method oneChildMax()
  //===============
  //Constructors
  //===============
  
  //Create an empty Binary Search Tree with a Root set to null
  public BST(){
    root = null;
  }
  
  //==============
  //Methods 
  //==============
  
  //Print the Binary Search Tree
  public void display(){
    System.out.print("(");
    traverse(root);
    System.out.println(")");
  }
  
  //A recursive function that traverses and prints out
  //the binary search tree with an inorder traversal
  private void traverse(BSTNode node){
    //check for leaf nodes
    if(node == null)
      return;
    //go left
    traverse(node.left);
    //Print node value
    System.out.print(node.val + " ");
    //go right 
    traverse(node.right);
  }
  
  //=============
  //Implement these
  //=============
  
  //This method takes an integer parameter n and inserts it as 
  //a node in a binary search tree
  public void insert(int n){
    int insertValue = n;
      if(root == null)
      root = new BSTNode(insertValue);
    else{
      BSTNode previous = root;
      BSTNode next = null;
      
      if(insertValue >=root.val)
        next = root.right;
      else if(insertValue < root.val)
        next = root.left;
      
      while(next != null){
        previous = next;
        
        if(insertValue >= next.val)
          next = next.right;
        else if(insertValue < next.val)
          next = next.left;
      }
      
      if(insertValue >=previous.val)
        previous.right = new BSTNode(insertValue);
      else if(insertValue < previous.val)
        previous.left = new BSTNode(insertValue);
    }
    return;
  }
  
  //this method searches the binary tree for an integer n and if it
  //exists deletes this node from the tree
  public void delete (int n){
    int deleteValue = n;
    if(root == null)
      return;
    
//search tree for value
    BSTNode temp = root;
    boolean exist = false;
    
    if(deleteValue == root.val)
      exist = true;
    
    while(exist == false && temp != null){
      if(deleteValue > temp.val)
        temp = temp.right;
      else if(deleteValue < temp.val)
        temp = temp.left;
      
      if(temp != null && deleteValue == temp.val)
        exist = true;
    }
    
    if(exist == false)
      return;
    else if(deleteValue == root.val){
//delete node that has 2 children
      BSTNode previous = root.right;
      BSTNode next = root.right;
      
      if(next.left == null && next.right == null){
        root.val = next.val;
        root.right = null;
        return;
      }
      else if(next.left == null && next.right != null){
        root.val = next.val;
        root.right = next.right;
        return;
      }
      
      while(next.left != null)
        next = next.left;
      
      while(previous.left.val != next.val)
        previous = previous.left;
      
      if(next.right == null){
        root.val = next.val;
        previous.left = null;
      }
      else if(next.right != null){
        root.val = next.val;
        previous.left = next.right;
      }
    }
    else{
//delete
      BSTNode previous = root;
      BSTNode next = null;
      
      if(deleteValue > root.val)
        next = root.right;
      else if(deleteValue < root.val)
        next = root.left;
      
      while(deleteValue != next.val){
        previous = next;
        if(deleteValue > next.val)
          next = next.right;
        else if(deleteValue < next.val)
          next = next.left;
      }
      
      if(next.left == null && next.right == null){
        
        if(previous.left == next)
          previous.left = null;
        else if(previous.right == next)
          previous.right = null;
      }
      else if(next.left == null && next.right != null){
        if(previous.left == next)
          previous.left = next.right;
        else if(previous.right == next)
          previous.right = next.right;
      }
      
      else if(next.left != null && next.right == null){
        if(previous.left == next)
          previous.left = next.left;
        else if(previous.right == next.left)
          previous.right = next.left;
      }
      
      else if(next.left != null && next.right != null){
//delete 2 children
        BSTNode target = next;
        previous = target.right;
        next = target.right;
        
        if(next.left == null && next.right == null){
          target.val = next.val;
          target.right = null;
          return;
        }
        else if(next.left == null && next.right != null){
          next.val = next.val;
          next.right = next.right;
          return;
        }
        
        while(next.left != null)
          next = next.left;
        
        while(previous.left.val != next.val)
          previous = previous.left;
        
        if(next.right == null){
          target.val = next.val;
          previous.left = null;
        }
        else if(next.right != null){
          target.val = next.val;
          previous.left = next.right;
        }
      }
    }
    return;
  }
  
  //This function returns true if no node in the binary tree has more than one
  //child, otherwise it returs false
  public boolean oneChildMax(){
    boolean isOneChildMax = true;
    
//post order traversal from root
    int foundChild = postOrderTraversal(root);
    
    if(foundChild == 2)
      isOneChildMax = false;
    
    return isOneChildMax;
  }
//private method for traversal in finding node with two children
  private int postOrderTraversal(BSTNode node){
    if(node == null){
      //do nothing
    }else{
      postOrderTraversal(node.left);
      postOrderTraversal(node.right);
      
      if(numberOfChildren == 2){
        //do nothing
      }else if(node.left != null && node.right != null){
        numberOfChildren = 2;
      }
    }
    
    return numberOfChildren;
  }
}
//end of Class BST




