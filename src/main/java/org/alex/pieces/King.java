package org.alex.pieces;

import org.alex.board.Board;
import org.alex.Color;
import org.alex.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {
    public King(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getShift() {
        Set<CoordinatesShift> result = new HashSet<>();
        for (int horizont = -1; horizont <= 1; horizont++) {
            for (int vertical = -1; vertical <= 1; vertical++) {
                if (horizont == 0 && vertical == 0) {
                    continue;
                }
                result.add(new CoordinatesShift(horizont, vertical));
            }

        }
        return result;
    }

    @Override
    protected boolean squareAvailableForMove(Coordinates newCoordinates, Board board) {
        boolean result = super.squareAvailableForMove(newCoordinates, board);
        if (result) {
            if (board.isAttackSquareForColor(newCoordinates, this.getColor())) {
                return  false;
            }
        }
        return result;
    }
}
