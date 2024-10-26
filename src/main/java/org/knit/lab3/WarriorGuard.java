package org.knit.lab3;

public class WarriorGuard extends Player implements Attaker{
    private int additionalDefense;

    public WarriorGuard(String name) {
        super(name, 100, 100, 100);
        this.additionalDefense = 100;
    }

    @Override
    public void decreaseHealth(int value) {
        int effectiveDefense = defense + additionalDefense;
        System.out.println(name + " использует дополнительную защиту: " + additionalDefense + " единиц.");
        super.decreaseHealth(value - effectiveDefense);
    }
}
