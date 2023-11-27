public class Sword {
    private String name;
    private double baseAttack;
    private double attack;
    private int level;

    public Sword() {
        this("Short Sword", 10, 0);
    }

    public Sword(String name) {
        this(name, 10, 0);
    }

    public Sword(String name, double baseAttack, int level) {
        this.name = name;
        this.baseAttack = baseAttack;
        this.attack = baseAttack * (1 + 0.1 * level);
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public double getAttack() {
        return attack;
    }

    public int getLevel() {
        return level;
    }

    public void upgrade() {
        this.level++;
        this.attack = baseAttack * (1 + 0.1 * level);
    }
}
