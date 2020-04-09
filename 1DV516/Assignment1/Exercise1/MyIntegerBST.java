import assignment1.exercise1.A1Tree;

public class MyIntegerBST implements A1Tree{
    private Node root = null;
    private Integer minDifferent = 1000, minDifferentValue = 0;

    public void insert(Integer value){
        root = insertValue(value, root);
    }

    private Node insertValue(Integer value, Node node){
        if(node==null){
            return new Node(value);
        }

        int compareResult = value.compareTo(node.value);

        if(compareResult < 0){
            node.left = insertValue(value, node.left);
        }else if(compareResult > 0 ){
            node.right = insertValue(value, node.right);
        }

        return node;
    }
    
    public void printByLevels(){
        int depth = 0;
        while(printDepth(root, depth)){
            System.out.println(" ");
            depth++;
        }
    }

    private boolean printDepth(Node node, int depth){
        if(node == null){
            return false;
        }

        if(depth == 0){
            System.out.print(node.value + " ");
            return true;
        }
        
        boolean left = printDepth(node.left, depth-1);
        boolean right = printDepth(node.right, depth-1);

        if(left){
            return left;
        }else{
            return right;
        }
    }

    public Integer mostSimilarValue(Integer value){
        similarValue(value, root);
        return minDifferentValue;
    } 

    private void similarValue(Integer value, Node node){
        
        if(node ==  null) {
            return ;            //Exit
        }else if(node.value == value) {
            minDifferentValue = value;
            return ;
        }else{
            int tempValue = Math.abs(node.value - value);

            if(minDifferent.compareTo(tempValue) > 0) {
                minDifferent = tempValue;
                minDifferentValue = node.value;
            }
            if(value.compareTo(node.value) < 0) {
                similarValue(value, node.left);
            }else {
                similarValue(value, node.right);
            }
        }
    }

    private class Node{
        Integer value;
        Node left = null;
        Node right = null;

        Node(Integer v){
            value = v;
        }
    }
}