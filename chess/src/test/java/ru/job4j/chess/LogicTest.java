package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LogicTest {
    @Test
    public void whenMoveTrue() {
        Cell c1 = Cell.C1;
        Cell e3 = Cell.E3;
        BishopBlack bishopBlack = new BishopBlack(c1);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        boolean rst = logic.move(c1, e3);
        assertThat(true, is(rst));
    }
    @Test
    public void whenIsFigureOnWay() {
        Cell c1 = Cell.C1;
        Cell d2 = Cell.D2;
        Cell e3 = Cell.E3;
        BishopBlack bishopBlack = new BishopBlack(c1);
        PawnBlack pawnBlack = new PawnBlack(d2);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        boolean rst = logic.move(c1, e3);
        assertThat(false, is(rst));
    }
    @Test
    public void whenInPointIsFigure() {
        Cell c1 = Cell.C1;
        Cell e3 = Cell.E3;
        BishopBlack bishopBlack = new BishopBlack(c1);
        PawnBlack pawnBlack = new PawnBlack(e3);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        boolean rst = logic.move(c1, e3);
        assertThat(false, is(rst));
    }
}
