package org.alex.pieces;

import org.alex.Board;
import org.alex.BoardUtil;
import org.alex.Color;
import org.alex.Coordinates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends Piece {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getShift() {
        Set<CoordinatesShift> coordinatesShifts = new HashSet<>();
        for (int i = -7; i < 7; i++) {
            if (i == 0) {
                continue;
            }
            coordinatesShifts.add(new CoordinatesShift(i, i));
        }
        for (int i = -7; i < 7; i++) {
            if (i == 0) {
                continue;
            }
            coordinatesShifts.add(new CoordinatesShift(-i, i));
        }

        return coordinatesShifts;
    }

    @Override
    public Set<Coordinates> getAvailableSquare(Board board) {
        return super.getAvailableSquare(board);
    }

    @Override
    protected boolean squareAvailableForMove(Coordinates newCoordinates, Board board) {
        boolean result = super.squareAvailableForMove(newCoordinates, board);

        if (result) {
            List<Coordinates> list = BoardUtil.getDiagonalBetween(this.getCoordinates(), newCoordinates);
            for (Coordinates moveCoordinates: list) {
                if (!board.isSquareEmpty(moveCoordinates)) {
                    return  false;
                }
            }
        }
        return result;
    }
}
