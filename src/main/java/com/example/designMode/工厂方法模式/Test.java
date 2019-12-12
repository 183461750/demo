package com.example.designMode.工厂方法模式;

/**
 * @author Fa
 * @date 2019-11-10 22:40
 */
public class Test {
    public static void main(String[] args) {
        BroomFactory broomFactory = new BroomFactory();
        Moveable moveable = broomFactory.create();
        moveable.run();
    }
}
