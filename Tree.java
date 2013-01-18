/** 
 * A simple interface to represent a Tree abstract data structure
 * which provides the basic methods needed by a tree
 **/

//Tree Abstract Data Type
public interface Tree{
  public void insert(int n); //insert n into the Tree
  public void delete(int n); //delete n from the Tree
  public boolean oneChildMax();
  public void display(); //Display the Tree in serial form
}
//End of Interface Tree