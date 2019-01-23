package charpter14_AOP.joincut.impl;

import charpter14_AOP.joincut.Animals;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-23
 */
public class Person implements Animals {

    // 切入点PointCut，对应代理模式中的主要业务方法, 切入点说白了就是连接点的实现，即目标对象中真正被切面织入的方法
    // 一句话可以帮助记忆: [切面]织入到[连接点]中[目标对象]的[切入点]
    @Override
    public void eat() {
        System.out.println("吃泡面");
    }

    @Override
    public void wc() {
        System.out.println("上厕所");
    }
}
