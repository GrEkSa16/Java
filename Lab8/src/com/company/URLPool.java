package com.company;

import java.util.*;

/**
 * Класс пула URL-адресов для хранения списка URL-адресов для поиска по глубине.
 * Сохраняется как экземпляр URLDepthPair.
 */
public class URLPool {

    /** Связанный список для представления ожидающих URL-адресов. */
    private LinkedList<URLDepthPair> pendingURLs;

    /** Связанный список для представления обработанных URL-адресов. */
    public LinkedList<URLDepthPair> processedURLs;

    /** Список массивов для представления просмотренных URL. */
    private ArrayList<String> seenURLs = new ArrayList<String>();

    /** An int to keep track of number of threads waiting. */
    public int waitingThreads;

    /** Конструктор для инициализации ожидающих потоков, обработанных URL-адресов и ожидающих URLs.
     */
    public URLPool() {
        waitingThreads = 0;
        pendingURLs = new LinkedList<URLDepthPair>();
        processedURLs = new LinkedList<URLDepthPair>();
    }

    /** Синхронизированный метод для получения количества ожидающих потоков. */
    public synchronized int getWaitThreads() {
        return waitingThreads;
    }

    /** Синхронизированный метод для возврата размера пула. */
    public synchronized int size() {
        return pendingURLs.size();
    }

    /** Синхронизированный метод добавления пары глубин в пул. */
    public synchronized void put(URLDepthPair depthPair) {

            pendingURLs.addLast(depthPair);


            this.notify();

    }

    /**
     * Синхронизированный метод получения следующей пары глубин из пула.
     */
    public synchronized URLDepthPair get() {

        // Set depth pair to null.
        URLDepthPair myDepthPair = null;

        // While the pool is empty, wait.
        if (pendingURLs.size() == 0) {
            waitingThreads++;
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                System.err.println("MalformedURLException: " + e.getMessage());
                return null;
            }
        }
        // Remove the first depth pair, add to seen URLs and processed URLs,
        // and return it.
        myDepthPair = pendingURLs.removeFirst();
        seenURLs.add(myDepthPair.getURL());
        processedURLs.add(myDepthPair);
        return myDepthPair;
    }
    /**
     * Синхронизированный метод получения списка просмотренных URL.
     */
    public synchronized ArrayList<String> getSeenList() {
        return seenURLs;
    }
}