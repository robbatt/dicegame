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

        budget += Dice.play(INPUT);

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
    public void calculatePaybackReturns1xInput() throws Exception {
        assertThat(Dice.calculatePayback(7, INPUT), is(1 * INPUT));
        assertThat(Dice.calculatePayback(8, INPUT), is(1 * INPUT));
        assertThat(Dice.calculatePayback(9, INPUT), is(1 * INPUT));
    }

    @Test
    public void calculatePaybackReturns2xInput() throws Exception {
        assertThat(Dice.calculatePayback(10, INPUT), is(2 * INPUT));
    }

    @Test
    public void calculatePaybackReturns3xInput() throws Exception {
        assertThat(Dice.calculatePayback(11, INPUT), is(3 * INPUT));
    }

    @Test
    public void calculatePaybackReturns4xInput() throws Exception {
        assertThat(Dice.calculatePayback(12, INPUT), is(4 * INPUT));
    }

    @Test
    public void checkWinningChanceAbove50Percent() throws Exception {
        int testRuns = 1000;
        int winCount = 0;

        for (int i = 0; i < 1000; i++) {
            float payback = Dice.play(INPUT);

            if(payback >= INPUT) {
                winCount++;
            }
        }

        System.out.println(
                String.format(
                        "winCount at %s runs is %s -> winning chance = %s %%",
                        testRuns,
                        winCount,
                        1.0f * winCount / testRuns)
        );

        assertThat(winCount, is(greaterThan(testRuns / 2)));
    }
}
