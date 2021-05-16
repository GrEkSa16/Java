package com.company;

import java.util.Scanner;
public class Game {

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        //поле для обработки данных о персонаже
        Student student;
        //поле для обработки данных о противнике
        Professors Professor;
        //переменная для перехода хода
        int turn = 0;
        //переменная для записи значения кубика
        int Dice;
        //переменная, содержащая сложность противника
        int ProfDifficulty = 1;
        String str;
        System.out.println("Добро пожаловать в игру \"Закрыть долги!\"");
        System.out.println("Введите имя вашего игрока: ");
        str = in.next();
        student = new Student(str);
        System.out.println("Загрузка...");
        Thread.sleep(1000);
        System.out.println("АХТУНГ!");
        Thread.sleep(300);
        System.out.println("Чрезмерное употрбление энергетических напитков может привести к серьезным проблемам со здоровьем.");
        Thread.sleep(300);
        System.out.println("Загрузка завершена. Приятного времяпрепровождения. ");
        Thread.sleep(500);
        System.out.println("Вы студент 2 курса информационной безопасности. Как и подобает всем студентам жизнь вашу можно описать как *от сессии, до сессии*...");
        Thread.sleep(2000);
        System.out.println("В очередной день вашей бесконечной прокрастинации вы замечаете сообщение от старосты");
        Thread.sleep(2000);
        System.out.println("В нем говорится о том, что с сегодня последний день для закрытия своих долгов, и те, кто их не закроет - будет отчислен");
        Thread.sleep(2000);
        System.out.println("Вы спешно вылетаете из общаги и спешите в вуз. Возле входа вы сталкиваетесь со своим хорошим другом, по иронии таким же лентяем как и вы.");
        Thread.sleep(2000);
        System.out.println("Женя: О!"+student.Name()+" и ты тут. Тоже все в последний день решил сдавать?");
        Thread.sleep(500);
        System.out.println(student.Name()+": Ну ты же меня знаешь, не изменяю традиции. А ты чего? Тоже решил?");
        Thread.sleep(500);
        System.out.println("Женя: Не, я свое уже оттанцевал");
        Thread.sleep(500);
        System.out.println(student.Name()+": Шустро ты, и как?");
        Thread.sleep(500);
        System.out.println("Женя: Да не без божьей помощи, кстати о ней, у меня тут тетрадь с конспектами завалялась. Старшие поделились. Держи, может поможет");
        Thread.sleep(500);
        System.out.println("Женя: Вид у тебя так себе, ты вообще спал? На, держи.");
        System.out.println("Женя *протянул банку с энергетиком*");
        Thread.sleep(1500);
        student.riseEnergy(3);
        System.out.println("Вы выпиваете банку залпом. Ваша энергия увеличена на 3, и теперь равна: " + student.getEnergy());
        Thread.sleep(1500);
        System.out.println(student.Name() + ": Спасибо, надеюсь поможет. Ну, я побежал. До встречи!");
        Thread.sleep(2000);
        System.out.println("Вы идете по университету и лениво вчитываетесь в свой *список долгов* :");
        //пока игрок не закрылся или не проиграл
        while (ProfDifficulty > 0 && ProfDifficulty < 4) {
            //инициализируем профессора с соответствующей сложностью
            Professor = new Professors(ProfDifficulty);
            if (ProfDifficulty==1) {
                System.out.println("Первым в вашем списке Зачет по истории.");
                Thread.sleep(500);
                System.out.println("К сожалению вы не появлялись на парах с начала семестра и даже не знаете как зовут преподавателя. Пробежавшись глазами в конспектах... ");
                Thread.sleep(500);
                System.out.println("Вы отправляетесь в аудиторию... ");
                Thread.sleep(500);

            }
            if (ProfDifficulty==2) {
                System.out.println("Второй в вашем списке Зачет по социологии.");
                Thread.sleep(500);
                System.out.println("Поговаривают, что он не очень жалует прогульщиков и лентяев. Хотя, кто их вообще любит?");
                Thread.sleep(500);
            }
            if (ProfDifficulty==3) {
                System.out.println("Зачет по философии. Преподаватель - гроза всех должников. Лишь единицы выходили из его кабинета живым, и те выжаты как лимон.");
                Thread.sleep(500);
                System.out.println("Вы делаете глубокий вдох и заходите в кабинет");
            }
            System.out.println("Перед вами " + Professor.Name() + "...");
            System.out.println("У него " + Professor.getQuestions() + " дополнительных вопросов и " + Professor.getTasks()+" задач");
            Thread.sleep(2000);
            //пока игрок и враг живы ходы будут повтаряться
            while (Professor.getTasks() > 0 && student.getNerves() > 0) {
                //повторяем до тех пор пока идет ход игрока и предмет не сдан
                do {
                    //ждем пока игрок правильно введет название хода
                    do {
                        System.out.println("Ваш ход... (ответить/подготовиться)");
                        str = in.next();
                    } while (!checkInput(str));
                    //метод, реализующий ответ на вопросы
                    if (str.equals("ответить")) {
                        System.out.println("Бросок кубика...");
                        Dice = rollTheDice();
                        Thread.sleep(1000);
                        System.out.println("Выпало число = " + Dice + "...");
                        Thread.sleep(1000);
                        Professor.takeAnswer(student.tryToPass(Dice));
                        System.out.println("Вы ответили на " + student.tryToPass(Dice) + " вопроса/задачи...");
                        Thread.sleep(1500);
                        System.out.println("У преподавателя осталось " + Professor.getQuestions() + " дополнительных вопросов и " + Professor.getTasks()+" задач ");
                        Thread.sleep(1500);
                        //если игрок не ответил на вопросы, ход переходит противнику
                        if (student.tryToPass(Dice) == 0) turn = 1;
                    }
                    //метод, реализующий добавление энергии
                    else{
                        System.out.println("Бросок кубика...");
                        Dice = rollTheDice();
                        Thread.sleep(1000);
                        System.out.println("Выпало число = " + Dice + "...");
                        Thread.sleep(1000);
                        student.riseEnergy(Dice);
                        if (Dice>0)
                        System.out.println("Вы выпили энергетик, и увеличили показатель энергии на " + Dice);
                        else System.out.println("Вы выпили энергетик, но лучше вам от этого не стало");
                        Thread.sleep(1500);
                        System.out.println("Ваша энергия: " + student.getEnergy() + ", осталось нервных клеток: " + student.getNerves());
                        Thread.sleep(1500);
                        turn = 1;
                    }
                }while (turn == 0 && Professor.getTasks() > 0);
                //если предмет сдан, то выходим из цикла
                if (student.getNerves() < 1) break;
                if (Professor.getTasks() < 1) break;
                //после перехода хода кубик бросается и враг совершает одно из действий (задать вопросы/пополнить вопросы)
                System.out.println("Ход переходит к " + Professor.Name() + "...");
                System.out.println("Бросок кубика...");
                Dice = rollTheDice();
                Thread.sleep(1000);
                System.out.println("Выпало число = " + Dice + "...");
                Thread.sleep(1000);
                //если очков на "атаку" не хватило, то противник увеличивает "защиту"
                if (Professor.turn(Dice) == 0){
                    if(Dice>0){
                    System.out.println("Преподаватель пополоняет список дополнительных вопросов на " + Dice);
                    }
                    else {
                        System.out.println("Преподаватель не придумал дополнительных вопросов");
                    }
                    Thread.sleep(1500);
                    System.out.println("У преподавателя " + Professor.getQuestions() + " дополнительных вопросов и " + Professor.getTasks()+" задач");
                }
                //при достаточном количестве очков, враг атакует
                else {
                    System.out.println(Professor.Name() + " Преподаватель начинает тебя валить и задает " + Professor.turn(Dice)+" вопроса");
                    student.getStressed(Professor.turn(Dice));
                    Thread.sleep(1500);
                    System.out.println("Ваша энергия: " + student.getEnergy() + ", осталось нервных клеток: " + student.getNerves());
                }
                Thread.sleep(1500);
                //если игрок жив, то ход переходит к нему вне зависимости от хода противника
                if (student.getNerves() > 0) {
                    turn = 0;
                    System.out.println("Ход переходит к " + student.Name() + "...");
                    Thread.sleep(1500);
                }
            }
            //если игрок проиграл, то выходим из цикла обнулив сложность
            if (student.getNerves() < 1) ProfDifficulty = 0;
                //если игрок защитился, то увеличиваем сложность
            else {
                ProfDifficulty++;
                //если предмет сдан, выводим сообщение о победе
                if (ProfDifficulty < 4) {
                    System.out.println("Вы справились с этим педметом...");
                    Thread.sleep(3000);
                    //разные подводки для разных уровней "врагов"
                    if (ProfDifficulty == 2){
                        System.out.println("Вы идете дальше по списку и понимаете, что...");
                        Thread.sleep(1500);
                    }
                    else
                        System.out.println("У вас остался последний пункт в плане, но тут вы осознали, что это...");
                    Thread.sleep(1500);
                }
            }
        }
        //если игрок завалил, то выводим сообщение о проигрыше
        if (student.getNerves() < 1) {
            System.out.println("К сожалению, ты не смог сдать дисциплины и идешь на пересдачу," );
            Thread.sleep(1500);
            System.out.println("но может тебе повезет в следующий раз.");
            Thread.sleep(1500);
            System.out.println("Перезапустите игру и попробуйте еще раз...");
        }
            //если игрок защитился, то выводим сообщение о победе и заканчиваем игру
        else{
            System.out.println("Вы успешно закрыли все предметы");
            Thread.sleep(3000);
            System.out.println("И теперь можете спокойно наслаждаться ЗАСЛУЖЕННЫМ отдыхом...");
            Thread.sleep(2000);
            System.out.println("И не задумываться об учебе до следующей сессии...");
            Thread.sleep(2000);
            System.out.println("На выходе из университета вы снова встречаете Женя");
            Thread.sleep(2000);
            System.out.println("Женя: О! " + student.Name() + ", ты жив! Это уже неожиданно");
            Thread.sleep(2000);
            System.out.println("Женя: Ну, как успехи? Узнал когда пересдача?");
            Thread.sleep(2000);
            System.out.println(student.Name()+": Хах, не поверишь. Все сдал, впервые за все время обучения.");
            Thread.sleep(2000);
            System.out.println("Женя: Ого! Да это стоит отпраздновать. А тебе уже сказали где ты будешь проходить учебную практику?");
            Thread.sleep(2000);
            System.out.println(student.Name()+": ...");
            Thread.sleep(2000);
            System.out.println(student.Name()+": ...помогите...");
            Thread.sleep(2000);
            System.out.println();
            Thread.sleep(3000);
            System.out.println("Курсовая работа");
            System.out.println("студента 2 курса");
            System.out.println("группы БИБ1903");
            System.out.println("Салахов А.И.");
            System.out.println("проверила ст.преподаватель");
            System.out.println("Мосева М.С.");
        }
    }
    //метод для реализации броска кубика с значениями от 0 до 5
    public static int rollTheDice(){ return (int) (Math.random() * 6); }

    //метод для проверки правильности введенной команды
    public static boolean checkInput(String str){
        if (!str.equals("ответить") && !str.equals("подготовиться")) {
            System.out.println("Введено неверное значение");
            return false;
        }
        return true;
    }
}