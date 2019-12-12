package com.example.designMode.抽象工厂模式;

import com.example.designMode.抽象工厂模式.entity.Food;
import com.example.designMode.抽象工厂模式.entity.Vehicle;
import com.example.designMode.抽象工厂模式.entity.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @author Fa
 * @date 2019-11-12 0:44
 */
public class Test {

    public static void main(String[] args) {

        System.out.println(new Test().splitString("ab你好", 6));

        System.exit(0);

        DefaultFactory f = new DefaultFactory();
        Vehicle v = f.createVehicle();
        v.run();
        Weapon w = f.createWeapon();
        w.shoot();
        Food a = f.createFood();
        a.printName();

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(null);
        objects.add(null);
        objects.add(null);
        HashSet<Object> objects1 = new HashSet<>();
        objects1.add(null);
        objects1.add(null);
        objects1.add(null);

        System.out.println(objects.size() + ":::" + objects1.size());

        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);

        Hashtable<String, String> table = new Hashtable<>();
        table.put(null, null);


    }

    /**
     * 截取字符串，输入为一个字符串或字节数，输出为按字节截取的字符串，但要保证汉字不能截取半个
     * 如“我ABC”4，应该截为“我AB”，输入“我ABC汉DEF”，6，应该输出为“我ABC”而不是“我ABC+汉的半个”。
     */
    public String splitString(String str, int length) {
        String resultStr = null;
        byte[] strBytes = str.getBytes();
        int byteLength = strBytes.length;

        if (length > byteLength) {
            length = byteLength;
        }

        int splitLen = length;
        while (strBytes[splitLen-1] < 0) {
            --splitLen;
        }

        resultStr = new String(strBytes, 0, splitLen);
        return resultStr;
    }

}
