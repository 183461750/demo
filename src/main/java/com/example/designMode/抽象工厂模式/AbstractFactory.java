package com.example.designMode.抽象工厂模式;

import com.example.designMode.抽象工厂模式.entity.Food;
import com.example.designMode.抽象工厂模式.entity.Vehicle;
import com.example.designMode.抽象工厂模式.entity.Weapon;

/**
 * 抽象工厂类
 * @author Fa
 * @date 2019-11-12 0:42
 */
public abstract class AbstractFactory {

    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
    public abstract Food createFood();

}
