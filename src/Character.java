public class Character {
    private String name;
    private double baseHp;
    private double hp;
    private double maxHp;
    private double baseMana;
    private double mana;
    private double maxMana;
    private double baseAttack;
    private double attack;
    private double baseSpeed;
    private double speed;
    private double maxSpeed;
    private int level;
    private Sword sword;
    private Shield shield;

    public Character() {
        this("Sam");
    };

    public Character(String name) {
        this(name, 100, 50, 10, 10, 0);
    }

    public Character(String name, int level) {
        this(name, 100, 50, 10, 10, level);
    }

    public Character(String name, double baseHp, double baseMana, double baseAttack, double baseSpeed, int level) {
        this.name = name;
        this.level = level;
        this.baseHp = baseHp;
        this.hp = baseHp + (10 * level);
        this.maxHp = baseHp + (10 * level);
        this.baseMana = baseMana;
        this.mana = baseMana + (2 * level);
        this.maxMana = baseMana + (2 * level);
        this.baseAttack = baseAttack;
        this.attack = baseAttack * (1 + 0.1 * level);
        this.baseSpeed = baseSpeed;
        this.speed = baseSpeed + (0.1 + 0.03 * level);
        this.maxSpeed = baseSpeed + (0.1 + 0.03 * level);
    }

    private void calculateStats() {
        this.maxHp = baseHp + (10 * level);
        this.maxMana = baseMana + (2 * level);
        this.maxSpeed = baseSpeed + (0.1 + 0.03 * level);
        this.attack = baseAttack * (1 + 0.1 * level);
        if (sword != null && shield != null) {
            this.speed = maxSpeed * (0.1 + 0.12 * level);
        } else if (sword != null) {
            this.speed = maxSpeed * (0.1 + 0.08 * level);
        } else if (shield != null) {
            this.speed = maxSpeed * (0.1 + 0.04 * level);
        } else {
            this.speed = maxSpeed;
        }
    }

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public double getMana() {
        return mana;
    }

    public double getMaxMana() {
        return maxMana;
    }

    public double getAttack() {
        return (sword != null) ? attack + sword.getAttack() : attack;
    }

    public double getDefense() {
        return (shield != null) ? shield.getDefense() : 0;
    }

    public double getSpeed() {
        return speed;
    }

    public int getLevel() {
        return level;
    }

    public Sword getSword() {
        return sword;
    }

    public Shield getShield() {
        return shield;
    }

    public void equipSword(Sword sword) {
        this.sword = sword;
        calculateStats();
    }

    public void equipShield(Shield shield) {
        this.shield = shield;
        calculateStats();
    }

    public void upgrade() {
        this.level++;
        calculateStats();
    }

    private void getAttacked(double damage) {
        if (shield != null) {
            damage -= shield.getDefense();
        }
        if (damage > 0) {
            hp -= damage;
        }
    }

    public void attack(Character enemy) {
        enemy.getAttacked(getAttack());
    }

    public void heal(double amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    public void restoreMana(double amount) {
        mana += amount;
        if (mana > maxMana) {
            mana = maxMana;
        }
    }
}
