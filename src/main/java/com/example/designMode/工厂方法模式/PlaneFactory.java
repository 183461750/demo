package com.example.designMode.工厂方法模式;

/**
 * @author Fa
 * @date 2019-11-10 22:39
 */
public class PlaneFactory extends VehicleFactory {
    @Override
    Moveable create() {
        return new Plane();
    }
}
