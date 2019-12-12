package com.example.designMode.简单工厂模式;

/**
 * @author Fa
 * @date 2019-11-10 22:43
 */
public class Factory {
    public static Sample creator(int which) {
        if (which == 1) {
            return new SampleA();
        } else if (which == 2) {
            return new SampleB();
        } else {
            return new Sample() {

            };
        }
    }
}

interface Sample {

}

class SampleA implements Sample {

}

class SampleB implements Sample {

}