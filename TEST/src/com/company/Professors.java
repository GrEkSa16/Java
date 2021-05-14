package com.company;
//класс, реализующий поведение противников
public final class Professors {
    //поля для значений имени и статистик
    private final String name;
    private int tasks;
    private int questions;
    private final int difficulty;

    //конструктор для инициализации противников по сложности
    Professors(int val) {
        //массив имен
        String[] profLvL = new String[3];
        profLvL[0] = "Преподователь по истории";
        profLvL[1] = "Преподователь по социологии";
        profLvL[2] = "Преподователь по философии";
        //устанавливаем имя врага в зависимости от переданной сложности
        name = profLvL[val-1];
        //устанавливаем значения для полей класса в зависимости от сложности
        tasks = 2 * val;
        questions = val;
        difficulty = val;
    }

    //метод, реализующий получение "урона" противником
    public void takeAnswer(int answer) {
        if (answer > questions) {
            tasks = tasks - (answer - questions);
            questions = 0;
            if (tasks < 0) tasks = 0;
        } else
            questions -= answer;
    }

    //метод, реализующий ход противника
    public int turn(int val) {
        //если значение на кубике меньше 3, то увеличивает количество вопросов
        if (val < 3) {
            extraQuest(val);
            return 0;
        }
        //иначе топит
        else
            return difficulty;
    }
    //метод реализующий пополнение вопросов
    public void extraQuest(int val) { questions += val; }
    //метод возвращающий имя врага
    public String Name() { return name; }
    //метод возвращающий значение задач для преподователя
    public int getTasks() { return tasks; }
    //метод возвращающий значение вопросов для преподователя
    public int getQuestions() { return questions; }
}