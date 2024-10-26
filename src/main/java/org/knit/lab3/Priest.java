package org.knit.lab3;

public class Priest extends Player implements Healer{
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
