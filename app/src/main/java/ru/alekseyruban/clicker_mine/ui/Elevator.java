package ru.alekseyruban.clicker_mine.ui;

public class Elevator {

    Elevator() {
        level = 1;
        upgradeCoast = 200;
        goldMaxSize = 20;
        goldSaved = 0;
        position = 0;
    }

    private int position;
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    private int level;
    public int getLevel() {
        return level;
    }

    private int upgradeCoast;
    public int getUpgradeCoast() {
        return upgradeCoast;
    }

    private int goldMaxSize;
    public int getGoldMaxSize() {
        return goldMaxSize;
    }

    private int goldSaved;
    public int getGoldSaved() {
        return goldSaved;
    }
    public void setGoldSaved(int goldSaved) {
        this.goldSaved = goldSaved;
    }

    public void upgrade() {
        this.level += 1;
        this.goldMaxSize = (int) (100 * level) / 4;
        this.upgradeCoast = (int) (upgradeCoast * 1.6);
    }

}
