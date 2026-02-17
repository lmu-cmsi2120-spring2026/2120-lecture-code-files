public class IntLinkedListTests {

    public static void main (String[] args) {
        IntLinkedList llCoolJ = new IntLinkedList();
        llCoolJ.append(1);
        llCoolJ.append(2);
        llCoolJ.append(3);
        System.out.println(llCoolJ.getAt(0));  // 1
        System.out.println(llCoolJ.getAt(1));  // 2
        System.out.println(llCoolJ.getAt(2));  // 3

        llCoolJ = new IntLinkedList();
        llCoolJ.prepend(3);
        llCoolJ.prepend(2);
        llCoolJ.prepend(1);
        llCoolJ.removeAt(1);
        System.out.println(llCoolJ.getAt(0)); // 1
        System.out.println(llCoolJ.getAt(1)); // 3

        llCoolJ = new IntLinkedList();
        llCoolJ.prepend(3);
        llCoolJ.prepend(2);
        llCoolJ.prepend(1);
        IntLinkedList.Iterator it = llCoolJ.getIterator();
        System.out.println(it.getCurrentInt()); // 1
        it.next(); // Advance the iterator one node
        System.out.println(it.getCurrentInt()); // 2
        it.next(); // Advance the iterator one node
        System.out.println(it.getCurrentInt()); // 3

        IntLinkedList newList = new IntLinkedList();
        newList.append(5);
        newList.append(8);
        newList.append(9);
        newList.append(67);
        newList.append(18);
        
        it = newList.getIterator();

        while (it.hasNext()) {
            System.out.println(it.getCurrentInt());
            it.next();
        }

        IntList inty = new IntLinkedList();
        inty.append(5);   // OK because append is in the IntList
        // inty.prepend(1);  // NOT OK because prepend is not in the interface
    }

}