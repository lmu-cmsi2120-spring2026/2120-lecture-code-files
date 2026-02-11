public class Dampymon extends Forneymon {

    Dampymon (String name) {
        super(25, name);
    }

    @Override
    public int takeDamage (int dmg, String type) {
        if (type.equals("burny")) {
            dmg += 5;
        }
        return super.takeDamage(dmg, type);
    }

}
