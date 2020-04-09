import assignment1.exercise1.A1Tree;

public class TreeMain{
    public static void main(String[] args){
        A1Tree tree = new MyIntegerBST();
        tree.insert(10); 
        tree.insert(7); 
        tree.insert(20); 
        tree.insert(4); 
        tree.insert(9); 
        tree.insert(25); 
        tree.insert(8); 

        tree.printByLevels();
        System.out.println("The closest number is: " +  tree.mostSimilarValue(5));
    }
}