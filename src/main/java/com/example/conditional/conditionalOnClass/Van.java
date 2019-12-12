package com.example.conditional.conditionalOnClass;

/**
 * @author Fa
 * @date 2019-11-19 18:56
 */
public class Van {

    private Fighter fighter;

    public Van(Fighter fighter) {
        this.fighter = fighter;
    }

    public void fight(){
        System.out.println("van：boy next door,do you like 玩游戏");
        fighter.fight();
    }
}