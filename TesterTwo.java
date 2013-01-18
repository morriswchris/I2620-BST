//File to test out assignment - part two
public class TesterTwo{
  public static void main(String [] args){
    
    System.out.println("\n\n==========Testing BST============\n\n");
    
    BST tree1 = new BST();
    BST tree2 = new BST();
    BST tree3 = new BST();
    
    int t1[] = {7, 9, 5, 4, 6, 2, 10, 1, 3, 8};
    System.out.println("\nInsertion:");
    
    for(int i = 0; i < t1.length; i++){
      tree1.insert(t1[i]);
      tree2.insert(t1[i]);
    }
    
    tree1.display();
    
    System.out.println("\nRemove:");
    
    tree1.delete(1); //leaf
    tree1.display(); 
    tree1.delete(5); //internal
    tree1.display();
    tree1.delete(7); //root
    tree1.display(); 
    tree1.delete(11); //non-existant
    tree1.display();
    
    System.out.println("\noneChildMax:");
    
    System.out.println(tree1.oneChildMax());
    System.out.println(tree2.oneChildMax());
    System.out.println(tree3.oneChildMax());
  }
}