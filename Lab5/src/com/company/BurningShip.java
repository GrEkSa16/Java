package com.company;

import java.awt.geom.Rectangle2D;
/**
 * Класс для вычисления фрактала BurningShip
 */
public class BurningShip extends FractalGenerator{
    //константа с максимальным количеством итераций
    public static final int MAX_ITERATIONS = 2000;
    /**
     * Метод позволяет генератору фракталов определить наиболее
     * «интересную» область комплексной плоскости для конкретного фрактала
     */
    public void getInitialRange(Rectangle2D.Double range){
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }
    /**
     * Метод реализует итеративную функцию для фрактала Мандельброта,
     * возвращает количество итераций или -1, если количество итераций
     * достигло максимума.
     */
    public int numIterations(double x, double y)
    {
        //создаем переменную, в которую запишем количество итераций
        int iteration;
        //инициализируем комплексное число равное 0
        Complex zreal = new Complex ();
        //создаем комплексную переменную для определенной точки фрактала,
        // которую мы отображаем на экране
        Complex zimaginary = new Complex (x,y);
        /*
          Вычисляем фрактал по функции Zn = Zn-1^2+с,
          где все значения — это комплексные числа, z0 = 0.
          Вычисления повторяются до тех пор, пока |zreal| > 2
          или пока число итераций не достигнет максимального значения.
         */
        for (iteration = 0; iteration < MAX_ITERATIONS && zreal.sqrAbsoluteValue() < 4; iteration++) {
            //каждый компонент комплексного числа берем по модулю
            zreal.absolutComponent();
            zreal = zimaginary.add(zreal.sqrValue()); //zreal = zimaginary + zreal^2
        }
        //если колличество повторений достигло заданного максимума, то возвращаем -1
        if (iteration == MAX_ITERATIONS) return -1;
        //возвращаем количество итераций
        return iteration;
    }
    public String toString() {
        return "BurningShip";
    }
}
