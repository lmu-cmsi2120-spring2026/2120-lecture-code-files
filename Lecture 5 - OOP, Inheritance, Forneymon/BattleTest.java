import java.util.*;
public class BattleTest {

    public static void main(String[] args) {
        Burnymon emberlizard = new Burnymon("Dave");
        System.out.println(emberlizard.getHealth());
        emberlizard.takeDamage(5, "dampy");
        System.out.println(emberlizard.getHealth());

        // Try commenting out the toString method
        // on line 19 of Forneymon.java and then run
        // this - notice what it prints instead of
        // Name: Health!
        System.out.println(emberlizard);

        Dampymon sudsturtle = new Dampymon("Sudsy");
        sudsturtle.takeDamage(5, "burny");
        
        // [!] Should print 15 since our Dampymon start with
        // 25 health and take 5 bonus damage from burny dmg
        System.out.println(sudsturtle.getHealth());


        Burnymon b1 = new Burnymon("Burny"),
                 b2 = new Burnymon("Burny"),
                 b3 = b1;
        Dampymon d1 = new Dampymon("Dampy");

        System.out.println(b1.equals(b1));
        System.out.println(b1.equals(b2));
        System.out.println(d1.equals(b1));
        System.out.println(b1 == b2);
        System.out.println(b1 == b3);
        System.out.println(b1.equals("lul here's a string"));
    }

}