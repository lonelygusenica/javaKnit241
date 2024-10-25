package org.knit.lab3;

public class Task6 {
package org.knit.rpg;

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
}

package org.knit.rpg;

public class Mage extends Player {
    private int spellPower;

    public Mage(String name) {
        super(name, 80, 25, 5);
        this.spellPower = 30;
    }

    public void castSpell(Player player) {
        if (isAlive()) {
            System.out.println(name + " накладывает заклинание на " + player.name);
            player.decreaseHealth(spellPower);
        }
    }
}

package org.knit.rpg;

public class Priest extends Player {
    private int healPower;

    public Priest(String name) {
        super(name, 100, 10, 10);
        this.healPower = 20;
    }

    public void heal(Player player) {
        if (isAlive()) {
            System.out.println(name + " лечит " + player.name);
            player.increaseHealth(healPower);
        }
    }
}

package org.knit.rpg;

public class WarriorGuard extends Warrior {
    private int additionalDefense;

    public WarriorGuard(String name) {
        super(name);
        this.additionalDefense = 10;
    }

    @Override
    public void decreaseHealth(int value) {
        int effectiveDefense = defense + additionalDefense;
        System.out.println(name + " использует дополнительную защиту: " + additionalDefense + " единиц.");
        super.decreaseHealth(value - effectiveDefense);
    }
}