package org.knit.lab3;

public abstract class Player {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected boolean isAlive;
    protected int posX;
    protected int posY;
    protected int attackPower;
    protected int defense;

    public Player(String name, int maxHealth, int attackPower, int defense) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.isAlive = true;
        this.posX = 0;
        this.posY = 0;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public void increaseHealth(int value) {
        if (isAlive) {
            health = Math.min(health + value, maxHealth);
            System.out.println(name + " исцелён на " + value + " HP. Текущее здоровье: " + health);
        }
    }


    public void decreaseHealth(int value) {
        if (isAlive) {
            health -= (value - defense);
            if (health <= 0) {
                health = 0;
                isAlive = false;
                System.out.println(name + " умер.");
            } else {
                System.out.println(name + " получил урон: " + value + " HP. Текущее здоровье: " + health);
            }
        }
    }


    public void moveTo(int x, int y) {
        posX = x;
        posY = y;
        System.out.println(name + " перемещён на позицию (" + posX + ", " + posY + ").");
    }


    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return name + ": Здоровье: " + health + "/" + maxHealth + ", Атака: " + attackPower + ", Защита: " + defense;
    }
}
