package com.company;

import java.util.*;

/** CrawlerTask реализует интерфейс Runnable.
 * Каждый экземпляр имеет ссылку на экземпляр класса URLPool.
 * Получает пару глубины URL-адресов из пула (ожидает, если недоступен),
 * извлекает веб-страницу, получает все URL-адреса со страницы и добавляет
 * новую пару URLDepth в пул URL-адресов для каждого найденного URL-адреса.
 */
public class CrawlerTask implements Runnable {
    //поле для полученной пары
    public URLDepthPair depthPair;
    //поле для пула
    public URLPool myPool;
    //конструктор для записи в соответствующее поле переданного пула
    public CrawlerTask(URLPool pool) { myPool = pool; }
    //метод для выполнения задач класса
    public void run() {
        //получаем пару из пула
        depthPair = myPool.get();
        //получаем глубину из пары
        int myDepth = depthPair.getDepth();
        //считываем все URL на сайте и записываем их в новый список
        LinkedList<String> linksList;
        linksList = Crawler.getAllLinks(depthPair);
        //проходим по всем ссылкам
        for (String newURL : linksList) {
            //создаем для каждой ссылки соответствующую пару и записываем в пул
            URLDepthPair newDepthPair = new URLDepthPair(newURL, myDepth + 1);
            myPool.put(newDepthPair);
        }
    }
}