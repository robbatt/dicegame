package me.brendler;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created on 28.10.2016.
 */
public class DiceTest {

    @Test
    public void playGame() throws Exception {
        float budget = 0.50f;
        float input = 0.50f;

        budget += Dice.play(input);

        assertThat(budget, is(both(greaterThanOrEqualTo(0.0f)).and(lessThanOrEqualTo(2.00f))));
    }
}