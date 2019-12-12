package com.example.designMode.抽象工厂模式;

import com.example.designMode.抽象工厂模式.entity.Food;
import com.example.designMode.抽象工厂模式.entity.Vehicle;
import com.example.designMode.抽象工厂模式.entity.Weapon;
import com.example.designMode.抽象工厂模式.entity.sub.Ak47;
import com.example.designMode.抽象工厂模式.entity.sub.Apple;
import com.example.designMode.抽象工厂模式.entity.sub.Car;

/**
 * 具体工厂类，其中Food,Vehicle，Weapon是抽象类，
 *
 * @author Fa
 * @date 2019-11-12 0:43
 */
public class DefaultFactory extends AbstractFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new Ak47();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }

}
