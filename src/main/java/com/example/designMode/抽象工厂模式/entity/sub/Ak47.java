package com.example.designMode.抽象工厂模式.entity.sub;

import com.example.designMode.抽象工厂模式.entity.Weapon;

/**
 * @author Fa
 * @date 2019-11-12 14:51
 */
public class Ak47 extends Weapon {

    @Override
    public void shoot() {
        System.out.println("Ak47 shoot。。。");
    }

}
