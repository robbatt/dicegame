package me.brendler;

import java.util.Map;
import java.util.Random;

/**
 * Created on 28.10.2016.
 */
public class Dice {

    private static PaybackMultiplierMap paybackMultiplierMap = new PaybackMultiplierMap();

    public static float play(float input) {

        int dice1Value = throwDice();
        int dice2Value = throwDice();
        int sum = dice1Value + dice2Value;

        return calculatePayback(sum, input);
    }

    private static int throwDice() {
        return 1 + new Random().nextInt(6);
    }

    static float calculatePayback(int sum, float input) {
        return paybackMultiplierMap.get(sum) * input;
    }


}
