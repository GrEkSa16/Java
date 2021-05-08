package com.company;
import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Класс позволяет отображать фракталы
 */
public class JImageDisplay extends JComponent {
    //создаем поле с информацией об изображении
    private BufferedImage displayImage;

    /**
     * Method to get display image from another class.
     */
    public BufferedImage getImage() {
        return displayImage;
    }
    /**
     * Конструктор инициализирует поле и задает размеры изображения
     */
    JImageDisplay (int width, int height) {
        //инициализируем поле с заданной шириной, высотой и типом изображения INT_RGB
        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //задаем размеры изображения при отображении с помощью метода родительского класса setPreferredSize
        Dimension val = new Dimension(width,height);
        super.setPreferredSize(val);
    }

    /**
     * Для правильного отображения границ изображения используем компонет суперкласса, а потом рисуем изобраежние
     * с помощью метода drawImage
     */
    @Override
    /*здесь вроде как должен стоять public, но если будет работать то оставить protected*/
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(displayImage, 0,0,displayImage.getWidth(),displayImage.getHeight(),null);
    }

    /**
     * Метод меняет цвет всех пикселей на черный
     */
    public void clearImage(){
        int[] rgbArray = new int[getWidth() * getHeight()];
        displayImage.setRGB(0,0,getWidth(),getHeight(),rgbArray,0,1);
    }

    /**
     * Метод меняет цвет пикселя на заданный
     */
    public void drawPixel (int x, int y, int rgbColor){
        displayImage.setRGB(x,y,rgbColor);
    }
}
