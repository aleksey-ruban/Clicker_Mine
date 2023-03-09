package ru.alekseyruban.clicker_mine.ui;

public class Deposit {
    private int money;
    private float multiplyCoeficient;

    public int getMoneyQuantity() {
        return money;
    }
    public void addMoney(int summ) {
        money += summ * multiplyCoeficient;
    }
    public void spendMoney(int summ) {
        money -= summ;
    }

    public void setMultiplyCoeficient(float x) {
        multiplyCoeficient = x;
    }

}
