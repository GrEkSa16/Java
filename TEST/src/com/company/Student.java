package com.company;
//класс реализующий поведение игрока
public final class Student {
    //поля для значений здоровья и статистик
    private final String name;
    private final int knowledge;
    private int nerves;
    private int energy;

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
        if (value >=3) {
            return knowledge;
        }
        return 0;
    }

    //конструктор для инициализации персонажа с его именем
    Student(String name) {
        //устанавливаем значения для полей класса
        this.name = name;
        nerves = 4;
        knowledge = 3;
        energy = 1;

    }

    //метод реализующий пополнение энергии
    public void riseEnergy(int val) { energy += val; }
    //метод возвращающий имя игрока
    public String Name() { return name; }
    public int getNerves() { return nerves; }
    public int getEnergy() { return energy; }

}