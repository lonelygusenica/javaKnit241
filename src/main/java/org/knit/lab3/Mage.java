package org.knit.lab3;

public class Mage extends Player implements SpellCaster{
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
