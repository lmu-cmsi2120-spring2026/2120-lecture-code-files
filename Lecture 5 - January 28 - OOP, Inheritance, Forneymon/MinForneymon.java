public interface MinForneymon {
    // Interfaces are a contract. A way we can hold
    // Classes we design to certain requirements

    public int takeDamage (int dmg, String type);
    public String toString ();

    // Any class that is a MinForneymon MUST
    // implement the above method signatures

    // An interface tells you the programmer
    // what methods your class must implement
    // and what those methods' inputs and
    // outputs are

}