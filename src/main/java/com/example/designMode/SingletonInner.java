package com.example.designMode;

/**
 * 双重线程检查模式
 * 优点：延迟加载，线程安全
 * 缺点： 写法复杂，不简洁
 *
 * @author Fa
 * @date 2019-10-21 15:42
 */
public class SingletonInner {
    /**
     * 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
     */
    private static volatile SingletonInner instance = null;

    /**
     * 私有构造方法，防止被实例化
     */
    private SingletonInner() {
    }

    /**
     * 1:懒汉式，静态工程方法，创建实例
     */
    public static SingletonInner getInstance() {
        // 在这里创建临时变量
        SingletonInner temp = instance;
        if (temp == null) {
            synchronized (SingletonInner.class) {
                temp = instance;
                if (temp == null) {
                    temp = new SingletonInner();
                    instance = temp;
                }
            }
        }
        // 注意这里返回的是临时变量
        return temp;
    }

}
