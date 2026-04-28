import java.util.*;

public class PQExample {
    public static void main(String[] args) {
        PriorityQueue<Forneymon> pq = new PriorityQueue<>();
        Burnymon b1 = new Burnymon("burny1");
        Burnymon b2 = new Burnymon("burny2");
        Burnymon b3 = new Burnymon("burny3");
        b1.takeDamage(5, "");
        b2.takeDamage(10, "");
        pq.add(b1);
        pq.add(b2);
        pq.add(b3);
        // [?] What gets printed below?
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}

// PriorityQueue<Forneymon> pq = new PriorityQueue<>();
// Burnymon b1 = new Burnymon("burny1");
// Burnymon b2 = new Burnymon("burny2");
// Burnymon b3 = new Burnymon("burny3");
// b1.takeDamage(5, "");
// b2.takeDamage(10, "");
// pq.add(b1);
// pq.add(b2);
// pq.add(b3);
// System.out.println(pq.poll());
// System.out.println(pq.poll());
// System.out.println(pq.poll());