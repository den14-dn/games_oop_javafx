package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {
    @Test
    public void whenPositionCell2On0() {
        Cell c1 = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(c1);
        Cell result = bishopBlack.position();
        assertThat(c1, is(result));
    }
    @Test
    public void whenCopyBishopBlackHasPosition2On0() {
        Cell c1 = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(c1);
        Figure result = bishopBlack.copy(c1);
        assertThat(c1, is(result.position()));
    }
    @Test
    public void whenWayWith4Points() {
        Cell c1 = Cell.C1;
        Cell g5 = Cell.G5;
        BishopBlack bishopBlack = new BishopBlack(c1);
        Cell[] result = bishopBlack.way(c1, g5);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expect, is(result));
    }
    @Test
    public void when2PointsOnDiagonal() {
        Cell c1 = Cell.C1;
        Cell g5 = Cell.G5;
        BishopBlack bishopBlack = new BishopBlack(c1);
        boolean result = bishopBlack.isDiagonal(c1, g5);
        assertThat(true, is(result));
    }
    @Test
    public void when2PointsOnNotDiagonal() {
        Cell c1 = Cell.C1;
        Cell g7 = Cell.G7;
        BishopBlack bishopBlack = new BishopBlack(c1);
        boolean result = bishopBlack.isDiagonal(c1, g7);
        assertThat(false, is(result));
    }
    @Test (expected = IllegalStateException.class)
    public void whenWayNotDiagonal() {
        Cell c1 = Cell.C1;
        Cell g4 = Cell.G4;
        BishopBlack bishopBlack = new BishopBlack(c1);
        bishopBlack.way(c1, g4);
    }
}
