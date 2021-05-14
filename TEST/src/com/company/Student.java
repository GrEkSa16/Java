package com.company;
//класс реализующий поведение игрока
public final class Student {
    //поля для значений здоровья и статистик
    private final String name;
    private int nerves;
    private int energy;
    private final int knowledge;

    //конструктор для инициализации персонажа с его именем
    Student(String name) {
        //устанавливаем значения для полей класса
        this.name = name;
        nerves = 4;
        energy = 1;
        knowledge = 3;
    }

    //метод, реализующий получение урона
    public void getStressed(int stress) {
        if (stress > energy) {
            nerves = nerves - (stress - energy);
            energy = 0;
            if (nerves < 0) nerves = 0;
        }
        else
            energy -= stress;
    }

    //метод, реализующий "атаку" персонажа
    public int tryToPass(int value) {
        if (value > 2) {
            return knowledge;
        }
        return 0;
    }

    //метод реализующий пополнение энергии
    public void riseEnergy(int val) { energy += val; }
    //метод возвращающий имя игрока
    public String getName() { return name; }
    public int getNerves() { return nerves; }
    public int getEnergy() { return energy; }

}