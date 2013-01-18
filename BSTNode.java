/**
 * A private class hich defines a Node of Binary 
 * Search Tree that has a link to a left and right node
 * as well as an internal inteher value
 **/

public class BSTNode{
  
  //=============
  //Vars
  //=============
  
  public int val; //The integer value stored in the node
  public BSTNode left; //The link to the left node
  public BSTNode right; //the link to the right node
  
  //============
  //Constructor
  //============
  
  //Default constructor, all links are null and value is zero
  public BSTNode(){
    left = right = null;
    val = 0;
  }
  
  //Default constructor with node value
  public BSTNode(int v){;
    left = right = null;
    val = v;
  }
}
//End of Class BSTNode
