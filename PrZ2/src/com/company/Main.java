package com.company;


import java.util.Scanner;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String str;
        String string;
        int n;
        int [] arr;
        int choice = -1;
        Scanner in = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("Выберите какой метод использовать:");
            System.out.println(" 1 - повторить каждую букву в слове n раз");
            System.out.println(" 2 - найти разницу между максимальным и минимальным элементами массива");
            System.out.println(" 3 - проверка среднего значения на целочисленность");
            System.out.println(" 4 - просуммировать все предыдущие числа");
            System.out.println(" 5 - узнать количество знаков в дробной части числа");
            System.out.println(" 6 - найти значение числа Фибоначчи по его номеру");
            System.out.println(" 7 - проверить строку на соответствие требованиям индекса");
            System.out.println(" 8 - проверить являются ли строки странной парой");
            System.out.println(" 9 - проверить приставку");
            System.out.println("10 - проверить суффикс");
            System.out.println("11 - проверить количество ходов");
            System.out.println(" 0 - Выход");
            choice = in.nextInt();
            switch (choice) {
                case (1) -> {
                    System.out.println("Введите слово:");
                    str = in.next();
                    System.out.println("Введите количество повторений:");
                    n = in.nextInt();
                    System.out.println("Полученное слово = " + repeat(str, n));
                }
                case (2) -> {
                    System.out.println("Введите длину массива:");
                    n = in.nextInt();
                    arr = new int[n];
                    System.out.println("Введите массив:");
                    for (int i = 0; i < n; i++)
                        arr[i] = in.nextInt();
                    System.out.println("Разница = " + differenceMaxMin(arr));
                }
                case (3) -> {
                    System.out.println("Введите длину массива:");
                    n = in.nextInt();
                    arr = new int[n];
                    System.out.println("Введите массив:");
                    for (int i = 0; i < n; i++)
                        arr[i] = in.nextInt();
                    System.out.println("Среднее значение целочисленно? - " + isAvgWhole(arr));
                }
                case (4) -> {
                    System.out.println("Введите длину массива:");
                    n = in.nextInt();
                    int[] oldA = new int[n];
                    Arrays.fill(oldA, 0);
                    System.out.println("Введите массив:");
                    for (int i = 0; i < n; i++)
                        oldA[i] = in.nextInt();
                    int[] newA = new int[oldA.length];
                    Arrays.fill(newA, 0);
                    newA = camulativeSum(oldA);
                    for (int i = 0; i < n; i++)
                        System.out.print(newA[i] + " ");
                    System.out.println();
                }
                case (5) -> {
                    System.out.println("Введите дробное число:");
                    str = in.next();
                    System.out.println("В дробной части числа " + getDecimalPlaces(str) + "знаков");
                }
                case (6) -> {
                    System.out.println("Введите номер числа:");
                    n = in.nextInt();
                    System.out.println("Значение " + n + " числа Фиббоначи = " + searchFibonacci(n));
                }
                case (7) -> {
                    System.out.println("Введите строку:");
                    str = in.next();
                    //если строка была введена с пробелами, то считываем следующие слова
                    System.out.println("Строка является индексом? " + isValid(str));
                    System.out.println();
                }
                case (8) -> {
                    System.out.println("Введите первую строку:");
                    str = in.next();
                    System.out.println("Введите вторую строку:");
                    string = in.next();
                    System.out.println("Строки являются странной парой? " + isValid(str, string));
                }
                case (9) -> {
                    System.out.println("Введите слово для проверки:");
                    string = in.next();
                    System.out.println("Введите приставку:");
                    str = in.next();
                    System.out.println("Приставка в этом слове есть? " + isPrefix(string, str));
                }
                case (10) -> {
                    System.out.println("Введите слово для проверки:");
                    string = in.next();
                    System.out.println("Введите суффикс:");
                    str = in.next();
                    System.out.println("Суффикс в этом слове есть? " + isSuffix(string, str));
                }
                case (11) -> {
                    System.out.println("Введите число шагов:");
                    n = in.nextInt();
                    if (n % 2 == 0) {System.out.println("Число шагов равно:"+n);}
                    else {System.out.println("Число шагов равно:"+(n+2));}
                }
            }
            Thread.sleep(1000);
        }
    }

    //метод повторяет каждую букву в слове заданное количество раз
    public static String repeat(String oldWord, int n) {

        String newWord = "";

        for (int i = 0; i < oldWord.length(); i++)

            for(int j = 0; j < n; j++)
                newWord += oldWord.charAt(i);
        return newWord;
    }
    //метод возвращает разницу между максимальным и минимльным элементами массива
    public static int differenceMaxMin(int[] array){
        int max = array[0];
        int min = array[0];

        for (int j : array) {
            if (j < min) min = j;
            if (j > max) max = j;
        }

        return max-min;
    }

    //метод возвращает является ли среднее значение целым числом
    public static boolean isAvgWhole(int[] array){

        return Arrays.stream(array).sum()%array.length==0;
    }

    //метод возвращает массив, каждый элемент которого является суммой всех предыдущих элементов старого массива
    public static int[] camulativeSum(int[] array){

        int[] newArray = new int[array.length];

        newArray[0] = array[0];
        for(int i = 1; i < array.length; i++)

            newArray[i] = newArray[i-1] + array[i];
        return newArray;
    }

    //метод возвращает количество знаков в дробной части числа
    public static int getDecimalPlaces(String a){

        int count = 0;

        for(int i = a.length() - 1; i >= 0; i--)
            if (a.charAt(i) != '.')
                count++;
            else
                return count;
        return count;
    }

    //метод возвращает значение число Фибоначи по его порядковому номеру
    public static long searchFibonacci(int k) {
        int a = 1;
        int res = 1;
        for (int i = 1; i < k; i++) {
            res += a;
            a = res - a;
        }
        return res;
    }

    //метод проверяет, является ли строка индексом
    public static boolean isValid(String a){
        if (a.length() != 5) return false;
        int count = 0;
        for(int i = 0; i < 5; i++)
            if(Character.isDigit(a.charAt(i))) count++;
        return count == 5;
    }

    //метод проверяет являются ли строки странной парой
    public static boolean isValid(String a, String b){
        return a.charAt(0) == b.charAt(b.length() - 1) & a.charAt(a.length() - 1) == b.charAt(0);
    }

    //метод проверяет начнается ли данное слово с определенного сочетания
    public static boolean isPrefix(String str, String pref){
        return pref.equals(str.substring(0,pref.length()));
    }

    //метод проверяет заканчивается ли данное слово определенным сочетанием
    public static boolean isSuffix(String str, String suf) {
        return suf.equals(str.substring(str.length() - suf.length()));
    }
}