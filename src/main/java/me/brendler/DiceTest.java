package me.brendler;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created on 28.10.2016.
 */
public class DiceTest {

    private static float INPUT = 0.50f;
    private static float INITIAL_BUDGET = 0.50f;

    @Test
    public void playGame() throws Exception {
        float budget = INITIAL_BUDGET;
        float input = INPUT;

        budget += Dice.play(input);

        assertThat(budget, is(both(greaterThanOrEqualTo(0.0f)).and(lessThanOrEqualTo(2.00f))));
    }

    @Test
    public void calculatePaybackReturns0xInput() throws Exception {
        assertThat(Dice.calculatePayback(2, INPUT), is(0 * INPUT));
        assertThat(Dice.calculatePayback(3, INPUT), is(0 * INPUT));
        assertThat(Dice.calculatePayback(4, INPUT), is(0 * INPUT));
        assertThat(Dice.calculatePayback(5, INPUT), is(0 * INPUT));
        assertThat(Dice.calculatePayback(6, INPUT), is(0 * INPUT));
    }

    @Test
    @Ignore
    public void calculatePaybackReturns1xInput() throws Exception {
        assertThat(Dice.calculatePayback(7, INPUT), is(1 * INPUT));
        assertThat(Dice.calculatePayback(8, INPUT), is(1 * INPUT));
        assertThat(Dice.calculatePayback(9, INPUT), is(1 * INPUT));
    }

    @Test
    @Ignore
    public void calculatePaybackReturns2xInput() throws Exception {
        assertThat(Dice.calculatePayback(10, INPUT), is(2 * INPUT));
    }

    @Test
    @Ignore
    public void calculatePaybackReturns3xInput() throws Exception {
        assertThat(Dice.calculatePayback(11, INPUT), is(3 * INPUT));
    }

    @Test
    @Ignore
    public void calculatePaybackReturns4xInput() throws Exception {
        assertThat(Dice.calculatePayback(12, INPUT), is(4 * INPUT));
    }
}