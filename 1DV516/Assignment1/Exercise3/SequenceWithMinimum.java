import assignment1.exercise3.A1SequenceWithMinimum;

import java.util.EmptyStackException;
import java.util.Iterator;

public class SequenceWithMinimum implements A1SequenceWithMinimum{
    private Node mostRight = null;
    private Node mostLeft = null;

    public void insertRight(Integer value){
        if(mostLeft==null){
            mostLeft = new Node(value);
            mostRight = mostLeft;
        }else{
            Node temp = mostRight;
            mostRight.right = new Node(value);
            mostRight = mostRight.right;
            mostRight.left = temp;
        }
    }

    public Integer removeRight(){
        if(!isEmpty()){
            Integer tempRight = mostRight.value;
            mostRight = mostRight.left;
            mostRight.right = null;

            return tempRight;
        }
        throw new EmptyStackException();
    }

    public void insertLeft(Integer value){
        if(mostLeft==null){
            mostLeft = new Node(value);
            mostRight = mostLeft;
        }else{
            Node temp = mostLeft;
            mostLeft.left = new Node(value);
            mostLeft = mostLeft.left;
            mostLeft.right = temp;
        }
    }

    public Integer removeLeft(){
        if(!isEmpty()){
            Integer tempLeft = mostLeft.value;
            mostLeft = mostLeft.right;
            mostLeft.left = null;
    
            return tempLeft;
        }
        throw new EmptyStackException();
    }

    public Integer findMinimum(){
        if(!isEmpty()){
            Iterator<Integer> iterator = iterator();
            Integer min = mostLeft.value;
            while(iterator.hasNext()){
                Integer val = iterator.next();
                if (val < min) {
                    min = val;
                }
            }
            return min;
        }
        throw new EmptyStackException();
    }

    @Override
    public String toString(){
        String sequence = "";
        Iterator<Integer> iterator = iterator();
        while(iterator.hasNext()){
            Object val = iterator.next();
            sequence = sequence + val + ", ";
        }
        sequence += "\n---------------------";
        return sequence;
    }

    public Iterator<Integer> iterator(){
        return new NodeIterator();
    }

    class NodeIterator implements Iterator<Integer>{
        private Node node = mostLeft;
        public Integer next(){
            Integer val = node.value;
            node = node.right;
            return val;
        }

        public boolean hasNext(){
            return node != null;
        }

        public void remove(){
            throw new RuntimeException("remove() is not implemented");
        }
    }

    private boolean isEmpty(){
        if(mostRight == null && mostLeft == null){
            return true;
        }
        return false;
    }

    private class Node{
        Integer value;
        Node right = null;
        Node left = null;

        Node(Integer v){ value = v; }
    }
}
