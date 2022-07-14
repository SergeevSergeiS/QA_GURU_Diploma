package ru.internet.sergeevss90.tests.ui;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    Faker faker = new Faker();

    public int getPriority() {
        return faker.number().numberBetween(0, 5);
    }

    public String getTaskName() {
        return faker.funnyName().toString();
    }

    public String getTaskDescription() {
        return "Visit " + faker.address().fullAddress();
    }
}