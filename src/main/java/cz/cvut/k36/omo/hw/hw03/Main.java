package cz.cvut.k36.omo.hw.hw03;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node node = new Node(7,
                new Node(1,
                        new Node(0, null, null),
                        new Node(3,
                                new Node(2, null,null),
                                new Node(5,
                                        new Node(4, null, null),
                                        new Node(6, null, null))
                                )
                        ),
                new Node(9,
                        new Node(8, null, null),
                        new Node(10, null, null))
                );

        CustomIterator iterator1 = node.preorderIterator()  ;
        System.out.println("Preorder");
        while (iterator1.hasNext()){
            System.out.println("Iterator 1: "+String.valueOf(iterator1.next()));
        }
    }
}
