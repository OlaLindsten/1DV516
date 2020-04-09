import assignment1.exercise3.A1SequenceWithMinimum;

public class SequenceMain{
    public static void main(String[] args){

        A1SequenceWithMinimum seq = new SequenceWithMinimum();
        seq.insertRight(5);         //5
        seq.insertRight(4);         //5 4
        seq.insertRight(15);        //5 4 15 
        System.out.println("Removed the right most value, which is: " + seq.removeRight()); //5 4
        seq.insertLeft(9);          //9 5 4
        System.out.println("Removed the left most value, which is: " + seq.removeLeft()); //5 4
        seq.insertRight(59);        //5 4 59
        seq.insertLeft(34);         //34 5 4 59
        seq.insertRight(8);         //34 5 4 59 8

        System.out.println("Minimum Value: " + seq.findMinimum());
        System.out.println(seq.toString());
    }
}