package com.example.designMode.抽象工厂模式.entity.sub;

import com.example.designMode.抽象工厂模式.entity.Vehicle;

/**
 * @author Fa
 * @date 2019-11-12 14:51
 */
public class Car extends Vehicle {

    @Override
    public void run() {
        System.out.println("Car run。。。");
    }
}
