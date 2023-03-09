package ru.alekseyruban.clicker_mine.ui;

import java.util.Random;

public class Investor {
    private int invested;

    public void setInvested(int summ) {
        invested = summ;
    }
    public int getResult() {
        return (int)(randFloat((float) 0.01, 2.5F) * invested);
    }

    private static float randFloat(float min, float max) {
        Random rand = new Random();
        return rand.nextFloat() * (max - min) + min;
    }
}
