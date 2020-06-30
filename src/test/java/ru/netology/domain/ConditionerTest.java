package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {
    @Test
    void shouldGetAndSetMinTemperature() {
        Conditioner conditioner = new Conditioner();
        assertEquals(0, conditioner.getMinTemperature());

        conditioner.setMinTemperature(-10);
        assertEquals(-10, conditioner.getMinTemperature());
        assertEquals(0, conditioner.getCurrentTemperature());

        conditioner.setMinTemperature(1);
        assertEquals(-10, conditioner.getMinTemperature());

        conditioner.setCurrentTemperature(-10);
        conditioner.setMinTemperature(-5);
        assertEquals(-5, conditioner.getMinTemperature());
        assertEquals(-5, conditioner.getCurrentTemperature());
    }

    @Test
    void shouldGetAndSetMaxTemperature() {
        Conditioner conditioner = new Conditioner();
        assertEquals(0, conditioner.getMaxTemperature());

        conditioner.setMaxTemperature(10);
        assertEquals(10, conditioner.getMaxTemperature());
        assertEquals(0, conditioner.getCurrentTemperature());

        conditioner.setMaxTemperature(-1);
        assertEquals(10, conditioner.getMaxTemperature());

        conditioner.setCurrentTemperature(10);
        conditioner.setMaxTemperature(5);
        assertEquals(5, conditioner.getMaxTemperature());
        assertEquals(5, conditioner.getCurrentTemperature());
    }

    @Test
    void shouldGetAndSetCurrentTemperature() {
        Conditioner conditioner = new Conditioner();
        assertEquals(0, conditioner.getCurrentTemperature());

        conditioner.setMinTemperature(-10);
        conditioner.setMaxTemperature(10);

        conditioner.setCurrentTemperature(0);
        assertEquals(0, conditioner.getCurrentTemperature());

        conditioner.setCurrentTemperature(-10);
        assertEquals(-10, conditioner.getCurrentTemperature());

        conditioner.setCurrentTemperature(10);
        assertEquals(10, conditioner.getCurrentTemperature());

        conditioner.setCurrentTemperature(-11);
        assertEquals(10, conditioner.getCurrentTemperature());

        conditioner.setCurrentTemperature(11);
        assertEquals(10, conditioner.getCurrentTemperature());
    }


    @Test
    void shouldIncreaseCurrentTemperature() {
        Conditioner conditioner = new Conditioner();
        conditioner.setMaxTemperature(30);
        conditioner.setMinTemperature(10);
        conditioner.setCurrentTemperature(10);

        int countPossibleOptions = conditioner.getMaxTemperature() - conditioner.getMinTemperature() + 1;

        conditioner.increaseCurrentTemperature();
        assertEquals(11, conditioner.getCurrentTemperature());

        for (int i = 0; i < countPossibleOptions - 1; ++i)
            conditioner.increaseCurrentTemperature();

        assertEquals(30, conditioner.getCurrentTemperature());
    }
    @Test
    void shouldDecreaseCurrentTemperature() {
        Conditioner conditioner = new Conditioner();
        conditioner.setMaxTemperature(30);
        conditioner.setMinTemperature(10);
        conditioner.setCurrentTemperature(30);

        conditioner.decreaseCurrentTemperature();
        assertEquals(29, conditioner.getCurrentTemperature());

        int countPossibleOptions = conditioner.getMaxTemperature() - conditioner.getMinTemperature() + 1;

        for (int i = 0; i < countPossibleOptions; ++i)
            conditioner.decreaseCurrentTemperature();

        assertEquals(10, conditioner.getCurrentTemperature());
    }

}