import java.util.Objects;

abstract public class Forneymon implements Comparable<Forneymon> {

    private int health;
    private String name;

    Forneymon(int health, String name) {
        this.health = health;
        this.name = name;
    }

    @Override
    public int compareTo(Forneymon other) {
        return this.health - other.health;
    }

    public int takeDamage(int dmg, String type) {
        this.health -= dmg;
        return this.health;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.health;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.name.equals(((Forneymon) other).name);
    }

    public int getHealth() {
        return this.health;
    }

    public String getName() {
        return this.name;
    }
}
