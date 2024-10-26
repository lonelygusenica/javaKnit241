package org.knit.lab3;

public class Task6 {

    public static void main(String[] args) {
        Mage mage = new Mage("Маг");
        Priest priest = new Priest("Священник");
        WarriorGuard warriorGuard = new WarriorGuard("Воин-страж");

        mage.castSpell(warriorGuard);
        priest.heal(warriorGuard);

        System.out.println(mage);
        System.out.println(priest);
        System.out.println(warriorGuard);
    }
}


