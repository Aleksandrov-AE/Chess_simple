package org.alex.pieces;

import org.alex.Board;
import org.alex.BoardUtil;
import org.alex.Color;
import org.alex.Coordinates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends PieceLongRange implements  IBishop {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    public Set<CoordinatesShift> getShift() {
        return bishopShift();
    }
}
