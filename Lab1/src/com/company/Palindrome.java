package com.company;
import java.util.Scanner;

public class Palindrome
{
    public static void main(String[] args)
    {
        String str ="";//создаем переменную для записи отдельных слов, записывем пустую строку
        char Letter;//создаем переменную для записи отдельных букв
        Scanner in = new Scanner(System.in);//создаем переменную типа Scanner для использования методов этого класса
        System.out.println("Введите слова через пробел");
        String s = in.nextLine();//считываем введенную строку
        if(s.length() != 0)//если строка непустая, то
        {
            //проходим ко всем символам
            for (int i = 0; i < s.length(); i++)
            {
                Letter = s.charAt(i);//записываем символ в переменную
                if (Letter == ' ')//если символ является пробелом (слово закончилось)
                {
                    System.out.println(str);//выводим слово
                    if(isPalind(str))//проверяем является ли слово полиндромом
                        System.out.println('+');//если да, то пишем +
                    else
                        System.out.println('-');//иначе -
                    str = "";//очищаем переменную со словом
                }
                else//если символ не пробел, то добавляем его к слову
                    str += Letter;
            }
            //так как после последнего слова пробела нет, его нужно проверить отдельно
            System.out.println(str);
            if(isPalind(str))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    public static String RString(String string)//метод для переворачивания слова
    {
        String revers   ="";//создаем переменную для записи перевернутого слова
        for(int i = string.length()-1; i>=0; i--)//находим количество букв в слове
            revers += string.charAt(i);//записываем буквы с конца
        return (revers);//возвращаем перевернутое слово
    }

    public static boolean isPalind(String s)//метод для проверки на "палиндромность"
    {
        return s.equals(RString(s));//возвращаем результат сравнение слова и результата переворачивающей функции
    }
}