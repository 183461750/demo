package com.example.designMode.简单工厂模式;

/**
 * @author Fa
 * @date 2019-11-10 23:00
 */
public class Complex {
    private final float re;
    private final float im;

    private Complex(float re, float im){
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(float re, float im){
        return new Complex(re, im);
    }

    public static Complex valueOfPolar(float r, float theta){
        return new Complex((float)(r * Math.cos(theta)), (float)(r * Math.sin(theta)));
    }
}