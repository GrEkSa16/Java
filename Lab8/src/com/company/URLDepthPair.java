package com.company;
import java.net.*;

/**
 * Класс для представления пар [URL, depth] для нашего сканера.
 */
public class URLDepthPair {


    /**
     * Поля для представления текущего URL-адреса и текущей глубины.
     */
    private int currentDepth;
    private String currentURL;

    /**
     * Конструктор, который устанавливает для ввода текущий URL-адрес и глубину.
     */
    public URLDepthPair(String URL, int depth) {
        currentDepth = depth;
        currentURL = URL;
    }
    /**
     * Метод, возвращающий текущий URL.
     */
    public String getURL() {
        return currentURL;
    }
    /**
     * Метод, возвращающий текущую глубину.
     */
    public int getDepth() {
        return currentDepth;
    }
    /**
     * Метод, который возвращает текущий URL-адрес и текущую глубину в строковом формате.
     */
    public String toString() {
        String stringDepth = Integer.toString(currentDepth);
        return stringDepth + '\t' + currentURL;
    }
    /**
     * Метод, который возвращает docPath текущего URL-адреса.
     */
    public String getDocPath() {
        try {
            URL url = new URL(currentURL);
            return url.getPath();
        }
        catch (MalformedURLException e) {
            System.err.println("MalformedURLException: " + e.getMessage());
            return null;
        }
    }
    /**
     * Метод, который возвращает webHost текущего URL-адреса.
     */
    public String getWebHost() {
        try {
            URL url = new URL(currentURL);
            return url.getHost();
        }
        catch (MalformedURLException e) {
            System.err.println("MalformedURLException: " + e.getMessage());
            return null;
        }
    }


}
