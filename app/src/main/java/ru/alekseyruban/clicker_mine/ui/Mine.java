package ru.alekseyruban.clicker_mine.ui;

public class Mine {

    Mine(int number) {
        level = 0;
        this.number = number;
        upgradeCoast = (int) (Math.pow(10, number) * 10);
        goldPerS = 0;
        goldSaved = 0;
    }

    private final int number;

    private int level;
    public int getLevel() {
        return level;
    }

    private int upgradeCoast;
    public int getUpgradeCoast() {
        return upgradeCoast;
    }

    private int goldPerS;
    public int getGoldPerS() {
        return goldPerS;
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
        this.goldPerS = (int) (Math.pow(10, number) * 10) / 4;
        this.upgradeCoast = (int) (Math.pow(10, number) * 10 * level);
    }

    public void click() {
        this.goldSaved += this.goldPerS;
    }

}
