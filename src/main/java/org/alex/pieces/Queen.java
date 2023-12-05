package org.alex.pieces;

import org.alex.Color;
import org.alex.Coordinates;

import java.util.Set;

public class Queen extends PieceLongRange implements IRook, IBishop {
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getShift() {
        Set<CoordinatesShift> result = rookShift();
        result.addAll(bishopShift());
        return result;
    }
}
