public class Shield {
    private String name;
    private double baseDefense;
    private double defense;
    private int level;

    public Shield() {
        this("Small Shield", 10, 0);
    }

    public Shield(String name) {
        this(name, 10, 0);
    }

    public Shield(String name, double baseDefense, int level) {
        this.name = name;
        this.baseDefense = baseDefense;
        this.defense = baseDefense * (1 + 0.05 * level);
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public double getDefense() {
        return defense;
    }

    public int getLevel() {
        return level;
    }

    public void upgrade() {
        this.level++;
        this.defense = baseDefense * (1 + 0.05 * level);
    }
}
