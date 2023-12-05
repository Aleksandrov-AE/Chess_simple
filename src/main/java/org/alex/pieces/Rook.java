package org.alex.pieces;

import org.alex.Board;
import org.alex.BoardUtil;
import org.alex.Color;
import org.alex.Coordinates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rook extends PieceLongRange implements IRook {
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getShift() {
        return rookShift();
    }
}
