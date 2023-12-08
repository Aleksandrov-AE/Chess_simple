package org.alex.pieces;

import org.alex.Board;
import org.alex.Color;
import org.alex.Coordinates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {
    public Knight(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getShift() {
        return new HashSet<>(Arrays.asList(
                new CoordinatesShift(1, 2),
                new CoordinatesShift(2, 1),

                new CoordinatesShift(2, -1),
                new CoordinatesShift(1, -2),

                new CoordinatesShift(-2, -1),
                new CoordinatesShift(-1, -2),

                new CoordinatesShift(-2, 1),
                new CoordinatesShift(-1, 2)
        ));
    }
}
