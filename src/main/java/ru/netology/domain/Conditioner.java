package ru.netology.domain;

public class Conditioner {
    private String name;
    private int maxTemperature;
    private int minTemperature;
    private int currentTemperature;
    private boolean on;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        if (maxTemperature < minTemperature)
            return;
        this.maxTemperature = maxTemperature;
        if (this.maxTemperature < currentTemperature)
            currentTemperature = maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        if (minTemperature > maxTemperature)
            return;
        this.minTemperature = minTemperature;
        if (this.minTemperature > currentTemperature)
            currentTemperature = minTemperature;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(int currentTemperature) {
        if (currentTemperature > maxTemperature || currentTemperature < minTemperature)
            return;
        this.currentTemperature = currentTemperature;
    }

    public void increaseCurrentTemperature() {
        if (currentTemperature == maxTemperature)
            return;
        ++currentTemperature;
    }

    public void decreaseCurrentTemperature() {
        if (currentTemperature == minTemperature)
            return;
        --currentTemperature;
    }
}
